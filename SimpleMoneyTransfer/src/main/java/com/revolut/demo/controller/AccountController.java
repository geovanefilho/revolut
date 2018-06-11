package com.revolut.demo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revolut.demo.model.Account;
import com.revolut.demo.service.AccountService;
import com.revolut.demo.service.impl.AccountServiceImpl;

/**
 * Servlet implementation class User
 */
public class AccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AccountService accountService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.accountService = new AccountServiceImpl(null);
		
		String accNumber = request.getParameter("accNumber");
		String strAmount = request.getParameter("amount");
		
		BigDecimal amount = null;
		String error = "";
		if (strAmount == null || strAmount.isEmpty()) {
			error = "You have to inform the value amount!";
		} else {
			try {
				amount = new BigDecimal(strAmount);
			} catch (NumberFormatException nfe) {
				error = "Amount format invalid!";
			}
		}
		
		Account acc = this.accountService.findByNumber(accNumber);
		
		response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        PrintWriter writer = response.getWriter();
        
        if (acc == null) {
        	if (error.isEmpty()) {
        		error = "It does not exists an account whit the number: " + accNumber;
        	} else {
        		error += " It does not exists an account whit the number: " + accNumber;
        	}
        }
        
        if (!error.isEmpty()) {
        	writer.print("<html><head><title>User</title></head><body>");
	        writer.print(error);
	        writer.print("</body></html>");
        	return;
        }
        
		try {
			this.accountService.credit(acc, amount);
			
			writer.print("<html><head><title>User</title></head><body>");
			writer.print("Successful credit of value!");
	        writer.print(" Credit of: " + amount.setScale(2, RoundingMode.HALF_UP) + " " + acc.getCurrency() + " in Account: " + acc.getNumber());
	        writer.print("</body></html>");
		} catch (Exception e) {
			writer.print("<html><head><title>User</title></head><body>");
	        writer.print(e.getMessage());
	        writer.print("</body></html>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

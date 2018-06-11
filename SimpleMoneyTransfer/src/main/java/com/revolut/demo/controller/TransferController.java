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
import com.revolut.demo.model.Transfer;
import com.revolut.demo.service.AccountService;
import com.revolut.demo.service.TransferService;
import com.revolut.demo.service.impl.AccountServiceImpl;
import com.revolut.demo.service.impl.TransferServiceImpl;

/**
 * Servlet implementation class User
 */
public class TransferController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private TransferService transferService;
	private AccountService accountService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransferController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.transferService = new TransferServiceImpl(null);
		this.accountService = new AccountServiceImpl(null);
		
		String oriAccNumber = request.getParameter("oriAccNumber");
		String destAccNumber = request.getParameter("destAccNumber");
		BigDecimal amount = new BigDecimal(request.getParameter("amount"));
		
		Account origin = this.accountService.findByNumber(oriAccNumber);
		Account destiny = this.accountService.findByNumber(destAccNumber);
		
		response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        PrintWriter writer = response.getWriter();
        
        String error = "";
        if (origin == null) {
        	error = "It does not exists an account whit the number(s): " + oriAccNumber;
        }
        if (destiny == null) {
        	if (error.isEmpty()) {
        		error = "It does not exists an account whit the number(s): " + destAccNumber;
        	} else {
        		error += ", " + destAccNumber;
        	}
        }
        
        if (!error.isEmpty()) {
        	writer.print("<html><head><title>User</title></head><body>");
	        writer.print(error);
	        writer.print("</body></html>");
        	return;
        }
        
		try {
			Transfer transfer = this.transferService.transfer(origin, destiny, amount);
			
			writer.print("<html><head><title>User</title></head><body>");
			writer.print("Successful transfer of value!");
	        writer.print("\nDebit of: " + transfer.getOriginTransferAmount().setScale(2, RoundingMode.HALF_UP) + " " + transfer.getOriginAccount().getCurrency() + " in Account: " + transfer.getOriginAccount().getNumber());
	        writer.print("\nCredit of: " + transfer.getOriginTransferAmount().multiply(transfer.getExchangeRate()).setScale(2, RoundingMode.HALF_UP) + " " + transfer.getDestinationAccount().getCurrency() + " in Account: " + transfer.getDestinationAccount().getNumber());
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

package com.revolut.demo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revolut.demo.model.Account;
import com.revolut.demo.model.User;
import com.revolut.demo.service.UserService;
import com.revolut.demo.service.impl.UserServiceImpl;

/**
 * Servlet implementation class User
 */
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService userService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.userService = new UserServiceImpl(null);
		
		String name = request.getParameter("userName");
		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
		String accNumber = request.getParameter("accNumber");
		String accCurrency = request.getParameter("accCurrency");
		BigDecimal accBalance = new BigDecimal(request.getParameter("accBalance"));
		
		User user = new User(name, userName, email);
		Account acc = new Account(accNumber, accBalance, accCurrency);
		user.setAccount(acc);
		
		response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        PrintWriter writer = response.getWriter();
        
		try {
			this.userService.save(user);
			
			writer.print("<html><head><title>User</title></head><body>");
	        writer.print("Created user with username: " + userName + " and account number: " + accNumber);
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

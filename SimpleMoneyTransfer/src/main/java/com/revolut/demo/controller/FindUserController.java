package com.revolut.demo.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revolut.demo.model.User;
import com.revolut.demo.service.UserService;
import com.revolut.demo.service.impl.UserServiceImpl;

/**
 * Servlet implementation class User
 */
public class FindUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService userService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindUserController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.userService = new UserServiceImpl(null);
		
		String userName = request.getParameter("userName");
		
		User user = this.userService.findByUserName(userName);
		
		response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        if (user == null) {
        	PrintWriter writer = response.getWriter();
            writer.print("<html><head><title>User</title></head><body>");
            writer.print("User not found with username: " + userName);
            writer.print("</body></html>");
        } else {
        	PrintWriter writer = response.getWriter();
            writer.print("<html><head><title>User</title></head><body>");
            writer.print("User: " + user.getName() + ", account number: " + user.getAccount().getNumber() + ", Balance: " + user.getAccount().getBalance() + " " + user.getAccount().getCurrency().name());
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

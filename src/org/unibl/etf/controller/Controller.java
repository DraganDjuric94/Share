package org.unibl.etf.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.unibl.etf.bean.UserBean;
import org.unibl.etf.dao.UserDAO;
import org.unibl.etf.dto.User;
import org.unibl.etf.helper.Utility;

public class Controller extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public Controller() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String address = "/WEB-INF/pages/index.jsp";
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		
		UserBean userBean = (UserBean) session.getAttribute("userBean");
		if (userBean == null) {
			userBean = new UserBean();
			session.setAttribute("userBean", userBean);
		}
		
		
		if	(action == null || action.equals("")) {
			address = "/WEB-INF/pages/index.jsp";
		} else if ("register".equals(action)) {
			// check if logged in
			address = "/WEB-INF/pages/register.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String address = "/WEB-INF/pages/index.jsp";
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		
		UserBean userBean = (UserBean) session.getAttribute("userBean");
		if (userBean == null) {
			userBean = new UserBean();
			session.setAttribute("userBean", userBean);
		}
		
		if	(action == null || action.equals("")) {
			address = "/WEB-INF/pages/index.jsp";
		} else if ("login".equals(action)) {
			System.out.println("Action login");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			System.out.println("parameters: " + email + " " + password);
		} else if ("register".equals(action)) {
			if (!userBean.isLoggedIn()) {
				// get all request parameters
				String firstName = request.getParameter("first_name");
				String lastName = request.getParameter("last_name");
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				String passwordRepeated = request.getParameter("password_repeated");
				String email = request.getParameter("email");
				
				if (!userBean.isRegisterDataOK(firstName, lastName, username, password, passwordRepeated, email)) {
					// Show message that entered data is not valid
					address = "/WEB-INF/pages/register.jsp";
				} else if (!password.equals(passwordRepeated)) {
					// Show message that passwords don't match
					address = "/WEB-INF/pages/register.jsp";
				} else if (userBean.isUsernameUsed(username)) {
					// Show message that username is used
					address = "/WEB-INF/pages/register.jsp";
				} else if (userBean.isEmailUsed(email)) {
					// Show message that email is used
					address = "/WEB-INF/pages/register.jsp";
				} else {
					// Data ok, register user
					String passwordHash = Utility.sha256(password);
					User newUser = new User(null, firstName, lastName, username, passwordHash, email, null, null, null, null, null);
					
					if (UserDAO.getInstance().createUser(newUser)) {
						// Success
						// Log in user and send him to edit profile
						userBean.setUser(newUser);
						userBean.setLoggedIn(true);
						address = "/WEB-INF/pages/edit_profile.jsp";
					} else {
						// Show message that something went wrong
						// Go to 500
					}
					
				}
			} else {
				address = "/WEB-INF/pages/home.jsp";
			}
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

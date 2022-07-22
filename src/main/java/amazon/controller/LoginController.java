package amazon.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import amazon.Bean.UserBean;
import amazon.dao.UserDao;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		UserDao userDao = new UserDao();

		UserBean user = userDao.login(email, password);

		RequestDispatcher rd = null;
		if (user == null) {
			request.setAttribute("errorMsg", "Invalid Credencials");
			rd = request.getRequestDispatcher("Login.jsp");

		} else {
			
			HttpSession session = request.getSession(); 
			session.setAttribute("userId", user.getUserId());
			if (user.getUserType().equals("customer")) {
				rd = request.getRequestDispatcher("Home.jsp");
			} else if (user.getUserType().equals("admin")) {
				
				  rd = request.getRequestDispatcher("Dashboard.jsp");
				 			} else {
				rd = request.getRequestDispatcher("404.jsp");
			}

		}

		rd.forward(request, response);

	}
}

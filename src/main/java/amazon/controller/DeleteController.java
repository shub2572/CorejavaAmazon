package amazon.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import amazon.Bean.UserBean;
import amazon.dao.UserDao;

@WebServlet("/DeleteController")
public class DeleteController extends HttpServlet {

	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int UserID = Integer.parseInt(request.getParameter("UserId"));
		 UserDao userDao =new UserDao();
		 UserBean user = userDao.getUserByUserID(UserID);
		 UserDao userDao1 = new UserDao();
			if(userDao1.deleteUser(UserID)) {	
				request.setAttribute("successMsg", "User Deleted Successfully");
			}
			else {
				request.setAttribute("errorMsg", "Some error Occured in userDao");
			}
			request.getRequestDispatcher("ListUserController").forward(request, response);
		
	}
	
}

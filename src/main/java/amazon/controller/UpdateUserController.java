package amazon.controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import amazon.Bean.UserBean;
import amazon.Dao.UserDao;

@WebServlet("/UpdateUserController")
public class UpdateUserController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			int userId= Integer.parseInt( request.getParameter("userId"));
			String firstName=request.getParameter("firstName");
			String lastName=request.getParameter("lastName");
			String gender=request.getParameter("gender");
			
		      UserBean userBean = new UserBean();
			
			UserBean.setFirstName(firstName);
			UserBean.setLastName(lastName);
			UserBean.setUserId(userId);
			UserBean.setGender(gender);
			
			SignupDao signupDao = new SignupDao();
			
			Boolean flag = signupDao.UpdateSignupUser(signupBean);
			System.out.println("Flag In UpdateSignup User"+flag);
			RequestDispatcher rd =null;
			if(flag == true) {
				rd  = request.getRequestDispatcher("ListSignupUsersController");
				request.setAttribute("DataAdded", "Data Successfull Added");
			}else {
				rd  = request.getRequestDispatcher("UpdateSignupUser.jsp");
				request.setAttribute("DataNotAdded", "Data Not Added");
			}
			
			rd.forward(request, response);
	}
}
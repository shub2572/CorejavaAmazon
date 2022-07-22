package amazon.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import amazon.Bean.CartBean;
import amazon.dao.CartDao;

@WebServlet("/DeleteCartController")
public class DeleteCartController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cartId =Integer.parseInt(request.getParameter("cartId"));
		
		CartDao addToCartDao = new CartDao();
		boolean flag = addToCartDao.deleteCart(cartId);
		RequestDispatcher rd = null;
		if(flag==true) {
			rd= request.getRequestDispatcher("ViewCartController");
		}
		rd.forward(request, response);
	}

}
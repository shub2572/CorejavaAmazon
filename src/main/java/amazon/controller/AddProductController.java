package amazon.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import amazon.Bean.ProductBean;
import amazon.dao.ProductDao;
@WebServlet("/AddProductController")
public class AddProductController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		int qty = Integer.parseInt(request.getParameter("qty"));

		ProductBean product = new ProductBean();
		product.setName(name);
		product.setPrice(price);
		product.setQty(qty);
		product.setImgUrl(
				"https://www.freepnglogos.com/uploads/notebook-png/download-laptop-notebook-png-image-png-image-pngimg-2.png");
		
		
		  ProductDao productDao = new ProductDao();
		  productDao.addProduct(product);
		  request.setAttribute("product",product );
		  request.getRequestDispatcher("AllProducts.jsp").forward(request, response);

		     
	}

}

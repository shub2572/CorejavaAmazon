package amazon.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import amazon.Bean.ProductBean;
import amazon.dao.ProductDao;

public class GetProductsController extends HttpServlet{
   
	 @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
                    ProductDao productDao =new ProductDao();
                    ArrayList<ProductBean> products = productDao.getAllProducts();
                    
                    request.setAttribute("products", products);
                    request.getRequestDispatcher("ListProduct.jsp").forward(request, response);
                    
	}
}

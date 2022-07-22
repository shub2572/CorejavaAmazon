package amazon.dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import amazon.Bean.CartProductBean;
import amazon.Bean.OrderBean;
import amazon.util.DbConnection;

public class OrderDao {

	public void placeOrder(int userId) {
		CartDao cartDao = new CartDao();
		ArrayList<CartProductBean> carts = cartDao.getCartItems(userId);

		int total = 0;
		for (CartProductBean cartProductBean : carts) {
			total = total + cartProductBean.getPrice();
		}
		
		
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("insert into orders (userid,amount,orderstatus,paymentmode,paymentstatus) values (?,?,?,?,?) \",\r\n"
					+ "					Statement.RETURN_GENERATED_KEYS");
			pstmt.setInt(1, userId);
			pstmt.setInt(2, total);
			pstmt.setString(3, "placed");
			pstmt.setString(4, "COD");
			pstmt.setString(5, "pending");
		
			  pstmt.executeUpdate();

		  ResultSet rs = pstmt.getGeneratedKeys();
		  rs.next();
			int orderId = rs.getInt("orderid");
			System.out.println("orderid ==> " + orderId);   
		  
		}
		catch(Exception e) {
			
			System.out.println("SMW in OrderDao :: in placeOrder");
			e.printStackTrace();
		}
		
	}

	public void insertOrder(int userId) {

		int total=0;
		CartDao cartDao = new CartDao();
		ArrayList<CartProductBean> cp = new ArrayList<CartProductBean>();
		for(CartProductBean cpb:cp) {
			total = cpb.getPrice()+total;
		}
		
		try(Connection con = DbConnection.getConnection();
			PreparedStatement ptmt = con.prepareStatement("insert into orders (user_id,amount,order_status,payment_mode,payment_status) values (?,?,?,?,?)",Statement.RE);
				) {
			ptmt.setInt(1, userId);
			ptmt.setInt(2, total);
			ptmt.setString(3, "pending");
			ptmt.setString(4, "cod");
			ptmt.setString(5, "pending");
			ptmt.executeUpdate(); 
			ResultSet rs = ptmt.getGeneratedKeys();
	
			rs.next();
			int orderId = rs.getInt("orderid");
			System.out.println("orderId"+orderId);

			OrderDao orderDao = new OrderDao();
			for(CartProductBean cpb:cp) {
				OrderBean orderBean1 = new OrderBean();
				orderBean1.setProductId(cpb.getProductId());
				orderBean1.setProductPrice(cpb.getPrice());
				orderBean1.setOrderId(orderId);
				orderDao.insertOrder(userId);
			}
			
			boolean flag=CartDao.DeteteAddToCartByUserId(userId);
			System.out.println(flag);
			
		} catch (Exception e) {
			System.out.println("SW in OrderDao -> insertOrder()");
			e.printStackTrace();
		}
		
	}
	}
	
	

}

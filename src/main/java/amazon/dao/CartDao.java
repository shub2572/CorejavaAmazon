package amazon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import amazon.Bean.CartBean;
import amazon.Bean.CartProductBean;
import amazon.Bean.OrderBean;
import amazon.util.DbConnection;

public class CartDao {
	public void addToCart(CartBean cart) {
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstm = con.prepareStatement("insert into carts (userid,productid) values (?,?)");
			pstm.setInt(1, cart.getUserId());
			pstm.setInt(2, cart.getProductId());

			pstm.executeUpdate();
		} catch (Exception e) {
			System.out.println("SMW CartDao::addToCart()");
			e.printStackTrace();
		}
	}

	public ArrayList<CartProductBean> getCartItems(int userId) {
		ArrayList<CartProductBean> carts = new ArrayList<CartProductBean>();
		
		try {
			
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select p.name , p.price , c.cartid , p.productid , c.userid  from products p,carts c where c.userid = ? and c.productid = p.productid ");
			pstmt.setInt(1, userId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
			 CartProductBean cart = new CartProductBean();
			 cart.setCartId(rs.getInt("cartid"));
			 cart.setProductId(rs.getInt("productid"));
			 cart.setUserId(rs.getInt("userid"));
			 cart.setName(rs.getString("Name"));
			 cart.setPrice(rs.getInt("price"));
			carts.add(cart);
			}
		}
		
		catch(Exception e){
			System.out.println("SMW in CartDao:: getCartItems");
			e.printStackTrace();
			
			
		}
		return carts;
	}

	public boolean deleteCart(int cartId) {
		boolean flag=false;
		try(Connection con = DbConnection.getConnection();
				PreparedStatement ptmt = con.prepareStatement("delete from carts where cartid =?");
				) {
			ptmt.setInt(1, cartId);
			int record = ptmt.executeUpdate();
			
			if(record == 1) {
				flag=true;
			}
		} catch (Exception e) {

		}
		return flag;
	}

	public ArrayList<CartProductBean> AddToCart(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public static boolean DeteteAddToCartByUserId(int userId) {
		// TODO Auto-generated method stub
		return false;
	}

	public static boolean DeteteAddToCartByUserId(OrderBean orderBean12) {
		// TODO Auto-generated method stub
		return false;
	}

	
}

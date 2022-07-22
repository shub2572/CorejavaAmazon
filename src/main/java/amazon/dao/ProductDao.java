package amazon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import amazon.Bean.ProductBean;
import amazon.util.DbConnection;
public class ProductDao {

	public ArrayList<ProductBean> getAllProducts() {
		
		ArrayList<ProductBean> products = new ArrayList<>();

		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from products"); 
                  ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ProductBean p = new ProductBean();
				p.setProductId(rs.getInt("productid"));
				p.setPrice(rs.getInt("price"));
				p.setQty(rs.getInt("qty"));
				p.setName(rs.getString("name"));
				p.setImgUrl(rs.getString("imgurl"));
				
				products.add(p);	
		}
			}
		  catch(Exception e){
			System.out.println("SMW  ProductsDao:: getAllProducts");
			e.printStackTrace();
			
			
		}
		return products;
		
	}
	public void addProduct(ProductBean product) {
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("insert into products (name,price,qty) values (?,?,?) ");
			pstmt.setString(1, product.getName());
			pstmt.setInt(2, product.getPrice());
			pstmt.setInt(3, product.getQty());
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("SMW in ProductDao:: add new products ");
			e.printStackTrace();
		}
}
	
}

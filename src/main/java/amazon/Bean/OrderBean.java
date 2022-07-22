package amazon.Bean;

public class OrderBean {
      int orderId;
	 public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	int ProductId;
	int ProductPrice;
	 String insertOrderDetails;
	public int getProductId() {
		return ProductId;
	}
	public void setProductId(int productId) {
		ProductId = productId;
	}
	public int getProductPrice() {
		return ProductPrice;
	}
	public void setProductPrice(int productPrice) {
		ProductPrice = productPrice;
	}
	public String getInsertOrderDetails() {
		return insertOrderDetails;
	}
	public void setInsertOrderDetails(String insertOrderDetails) {
		this.insertOrderDetails = insertOrderDetails;
	}
}

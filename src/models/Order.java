package models;

public class Order extends Customer
{
	int orderID;
	String itemName;
	int quantity;
	String orderdate;
	public Order(String name, long phoneNo, String deliveryAddress, int orderID, String itemName, int quantity,
			String orderdate) {
		super(name, phoneNo, deliveryAddress);
		this.orderID = orderID;
		this.itemName = itemName;
		this.quantity = quantity;
		this.orderdate = orderdate;
	}
	public int getOrderID() {
		return orderID;
	}
	public String getItemName() {
		return itemName;
	}
	public int getQuantity() {
		return quantity;
	}
	public String getOrderdate() {
		return orderdate;
	}
	
}


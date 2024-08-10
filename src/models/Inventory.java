package models;

public class Inventory {
	String itemName;
	int quantity;
	String type;
	int price;
	public Inventory(String itemName, int quantity, String type, int price) {
		super();
		this.itemName = itemName;
		this.quantity = quantity;
		this.type = type;
		this.price = price;
	}
	public String getItemName() {
		return itemName;
	}
	public int getQuantity() {
		return quantity;
	}
	public String getType() {
		return type;
	}
	public int getPrice() {
		return price;
	}
	
}

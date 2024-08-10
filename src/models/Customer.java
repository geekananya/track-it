package models;

public class Customer {
	private String name;
	private long phoneNo;
	private String deliveryAddress;
	protected Customer(String name, long phoneNo, String deliveryAddress) {
		super();
		this.name = name;
		this.phoneNo = phoneNo;
		this.deliveryAddress = deliveryAddress;
	}
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	public String getName() {
		return name;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public String getDeliveryAddress() {
		return deliveryAddress;
	}
}



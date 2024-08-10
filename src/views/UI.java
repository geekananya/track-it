package views;
import java.io.*;

import controllers.Management;

public class UI {

	public static void main(String[] args) throws IOException {
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		Management manage=new Management();
		
//		manage.setItemDetails();
		manage.setOrderDetails();
		
//		manage.maintainfile();
		
		//menu driven
		System.out.println("Enter 1 to add an item in inventory list\n2 to delete an item from inventory list\n3 to display all items of inventory");
		System.out.println("4 to display total price of all items\n5 to check item availability\n6 to search for an order\n7 to change delivery address\n8 to make an order");
		
		int choice=Integer.parseInt(br.readLine());
		while(choice!=0)
		{
			switch(choice)
			{
			case 1:
				{
					System.out.println("Enter name of item");
					String itname=br.readLine();
					System.out.println("Enter available quantity");
					int quantity=Integer.parseInt(br.readLine());
					System.out.println("Enter type of item");
					String type=br.readLine();
					System.out.println("Enter price of item");
					int price=Integer.parseInt(br.readLine());
					manage.addItem(itname, quantity, type, price);
					manage.maintainfile();
					break;
				}
			case 2:
				{
					System.out.println("Enter name of item");
					String itname=br.readLine();
					if(manage.deleteItem(itname));
						manage.fileSearchAndDelete(itname);
					break;
				}
			case 3:	manage.displayInventory(); break;
			case 4: System.out.println("Total price in inventory: Rs. "+manage.getTotalPrice()); break;
			case 5: {
					System.out.println("Enter name of item");
					String itname=br.readLine();
					manage.checkAvailability(itname);
					break;
				}
			case 6:
				{
					System.out.println("Enter name of customer");
					String name=br.readLine();
					System.out.println("press 1 to display all orders placed by customer\npress 2 to search an order by ID");
					int c=Integer.parseInt(br.readLine());
					if(c==1)
						manage.searchCustomer(name);
					else if(c==2)
					{
						System.out.println("enter order ID");
						int id=Integer.parseInt(br.readLine());
						manage.searchOrder(id);
					}
					else
						System.out.println("Invalid choice");
					break;
				}
			case 7:
				{
					System.out.println("Enter customer name");
					String name=br.readLine();
					System.out.println("Enter new Delivery Address");
					String newad=br.readLine();
					manage.changeAddress(name, newad);
					break;
				}
			case 8: {
					System.out.println("Enter customer name");
					String name=br.readLine();
					System.out.println("Enter phone no.");
					long mob=Long.parseLong(br.readLine());
					System.out.println("Enter delivery address");
					String addr=br.readLine();
					System.out.println("Enter item name");
					String item=br.readLine();
					System.out.println("Enter quantity to buy");
					int q=Integer.parseInt(br.readLine());
					System.out.println("Enter date");
					String date=br.readLine();
					manage.addOrder(name,mob,addr,item,q,date);
					break;
				}
			default: System.out.println("Invalid choice");
			}
			System.out.println("\nEnter 0 to exit,\n1 to add an item in inventory list,\n2 to delete an item from inventory list,\n3 to display all items of inventory,");
			System.out.println("4 to display total price of all items,\n5 to check item availability,\n6 to search for an order,\n7 to change delivery address,\n8 to make an order");
			choice=Integer.parseInt(br.readLine());
		}
		System.out.println("Thank you for interacting with us!");
		br.close();
	}

}

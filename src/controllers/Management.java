package controllers;

import java.util.LinkedList;
import java.lang.String;

import models.*;
import java.io.*;

public class Management {
	LinkedList<Inventory> i=new LinkedList<Inventory>();
	LinkedList<Order> obj=new LinkedList<Order>();
	
	//setDetails functions
//		i.add(new Inventory("Toothbrush", 45, "Domestic", 20));
//		i.add(new Inventory("Blue Pen", 100, "Stationary", 5));
//		i.add(new Inventory("Black Pen", 60, "Stationary", 20));
//		i.add(new Inventory("Scissors", 45, "General", 40));
//		i.add(new Inventory("Comb", 40, "Domestic", 35));
//		i.add(new Inventory("Safety Pin pack",30, "General", 10));
//		i.add(new Inventory("Plastic Bottle", 50, "Domestic", 150));
	
	public void setOrderDetails() {
		obj.add(new Order("Rajiv",9032949429L,"123abc Street", 2003, "Comb", 4, "25/08/22"));
		obj.add(new Order("Rahul",9032949459L,"456abc Street", 2004, "Toothbrush", 2, "26/06/22"));
		obj.add(new Order("Raam",9032948290L,"789abc Street", 2348, "Scissors", 1, "27/04/22"));
		obj.add(new Order("Rajiv",9032949429L,"123abc Street", 2005, "Black Pen", 5, "28/08/22"));
		obj.add(new Order("Rita",9072949429L,"654abc Street", 2349, "Plastic Bottle", 5, "14/09/22"));

	}
	public void maintainfile() throws FileNotFoundException, IOException
	{
		
        File file = new File("inventory.txt");
        file.createNewFile();
//        System.out.println(file.getPath());
        FileWriter w= new FileWriter("inventory.txt", false);
        
        //write, not append, i.e. file is rewritten everytime this statement is run.
        
        w.write(String.format("%-22s","ITEM NAME")+String.format("%-11s", "TYPE")+String.format("%-8s", "PRICE")+"QUANTITY\n");
		for(Inventory inv: i)
		{
			w.write(String.format("%-20s",inv.getItemName())+String.format("%-14s", inv.getType())+String.format("%-8s", inv.getPrice())+inv.getQuantity()+"\n");
		}
        w.close();
//
	}
	public void fileSearchAndDelete(String item)throws FileNotFoundException, IOException
	{
		File temp= new File("temp.txt");
		temp.createNewFile();
		File file = new File("inventory.txt");
		FileReader r=new FileReader(file);
		FileWriter w=new FileWriter(temp, false);
		BufferedReader br=new BufferedReader(r);
		String l=null;
		l=br.readLine();
		do {
			w.write(l+"\n");
			l=br.readLine();
		}while(l!=null);
		w.close();
		r.close();
		br.close();
		r=new FileReader(temp);
		w=new FileWriter(file, false);
		br=new BufferedReader(r);
		l=br.readLine();
		do {
			if(l.contains(item))
			{
				l=br.readLine();
				continue;
			}
			w.write(l+"\n");
			l=br.readLine();
		}while(l!=null);
		w.close();
		r.close();
		br.close();
	}
	
/*==================MenuDriven methods=======================*/	
	public void addItem(String itemName, int quantity, String type, int price)
	{
		i.add(new Inventory(itemName, quantity, type,price));
//		w= new FileWriter("inventory.txt", true);
//		System.out.println(String.format("\n%-20s",itemName)+String.format("%-14s", type)+String.format("%-8s", String.valueOf(price))+quantity);
//		w.write("test");
//		w.write(String.format("%-20s",itemName)+String.format("%-14s", type)+String.format("%-8s", String.valueOf(price))+quantity+"\n");
		System.out.println("Item added successfully!");
//		w.close();
	}
	public boolean deleteItem(String itemName)
	{
		int a=-1;
		if(i.size()==0)
		{
			System.out.println("No items are present in the list!");
			return false;
		}
		for(int inv=0; inv<i.size(); inv++)
		{
			if (i.get(inv).getItemName().equalsIgnoreCase(itemName))
			{
				a=inv;
				break;
			}
		}
		try
		{
			i.remove(a);
			System.out.println("Item successfully deleted.");
		}
		catch(Exception e)
		{
			System.err.println("Item not found");
		}
		return true;
	}
	public void displayInventory()throws IOException, FileNotFoundException
	{
		if(i.size()==0)
		{
			System.out.println("There are no items in the inventory!");
			return;
		}
		File file = new File("inventory.txt");
		FileReader r=new FileReader(file);
		BufferedReader br=new BufferedReader(r);
		String l=null;
		l=br.readLine();
		do {
			System.out.println(l);
			l=br.readLine();
		}while(l!=null);
		r.close();
		br.close();
	}
	public int getTotalPrice()
	{
		int t=0;
		for(Inventory inv: i)
		{
			t+=inv.getPrice()*inv.getQuantity();
		}
		return t;
	}
	public void searchCustomer(String name)
	{
		boolean f=false;
		for(Order o:obj)
		{
			if(o.getName().equals(name))
			{
				f=true;
				System.out.println("=========Customer Details=========");
				System.out.println("Customer Name:"+o.getName());
				System.out.println("Phone No.:"+o.getPhoneNo());
				System.out.println("Delivery Address:"+o.getDeliveryAddress());
				System.out.println("\n========Order Details========");
				System.out.printf("ORDER-ID   ORDER-DATE   %-20sQUANTITY","ITEM-NAME");
				for(Order or:obj)
				{
					if(or.getName().equals(name))
						System.out.printf("\n%-12s%-12s%-23s%s",or.getOrderID(),or.getOrderdate(),or.getItemName(), or.getQuantity());
				}
				break;
			}
		}
		if(f==false)
			System.err.println("Customer not found");
	}
	public void searchOrder(int id)
	{
		boolean f=false;
		for(Order o:obj)
		{
			if(o.getOrderID()==id)
			{
				f=true;
				System.out.println("=========Customer Details=========");
				System.out.println("Customer Name:"+o.getName());
				System.out.println("Phone No.:"+o.getPhoneNo());
				System.out.println("Delivery Address:"+o.getDeliveryAddress());
				System.out.println("\n========Order Details========");
				System.out.println("Order ID:"+id);
				System.out.println("Order Date:"+o.getOrderdate());
				System.out.println("Item Name:"+o.getItemName());
				System.out.println("Quantity:"+o.getQuantity());
				break;
			}
		}
		if(f==false)
			System.err.println("Order ID not found");
	}
	public void changeAddress(String name, String add) {
		boolean f=false;
		for(Order o:obj)
		{
			if(o.getName().equals(name))
			{
				f=true;
				o.setDeliveryAddress(add);
				System.out.println("Address changed successfully");
				//change in file
				break;
			}
		}
		if(f==false)
			System.err.println("Customer not found");
	}
	public void checkAvailability(String itemname)
	{
		boolean f=false;
		for(Inventory inv: i)
		{
			if(inv.getItemName().equalsIgnoreCase(itemname))
			{
				f=true;
				if(inv.getQuantity()<10)
					System.out.println("Item:"+inv.getItemName()+"\nInsufficient quantity. More items need to be ordered.");
				else if(inv.getQuantity()>20)
					System.out.println("Item:"+inv.getItemName()+"\nSufficient quantity available.");
				else
					System.out.println("Item quantity is between 10 and 20");
			}
		}
		if(f==false)
			System.err.println("Item not found");
	}
	public void addOrder(String name,long mob,String addr,String item,int q, String date)
	{
		int id=(int)(10000*Math.random());
		obj.add(new Order(name, mob, addr, id,item, q, date));
		System.out.println("Order added successfully! Order ID: "+id);
	}
}


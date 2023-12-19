package com.app.rooms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.app.gadget.AC;
import com.app.gadget.Light;
import com.app.gadget.Refrigerator;
import com.app.gadget.Tv;
import com.app.interfaces.Device;

public class Room {
	
	String name;
	List<Device> d;
	Scanner sc=new Scanner(System.in);
	public Room() {
		this.name = "Empty room";
		d=new ArrayList<Device>();
		d.add(new Light());
	}
	public Room(String name) {
		super();
		this.name = name;
		d=new ArrayList<Device>();
//		d.add(new Light());
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	////methods///
	public int addDevice(int choice) {
		
		System.out.println("enter the brand name");
		String name=sc.nextLine();
		switch(choice) {
		case 1:
			d.add(new Tv(name));
			break;
		case 2:
			d.add(new AC(name));
			break;
		case 3:
			d.add(new Light(name));
			break;
		case 4:
			d.add(new Refrigerator(name));
			break;
		case 0:
			break;
		default :
			System.out.println("	Invalid choice");
			return -1;
		}
		return 1;
	}
	
	public void controlDevice(int ch) {
		if(d.isEmpty())
		{
			System.out.println("  -----Select action-----");
			System.out.println("  1. on device");
			System.out.println("  2. off device");
			int a=sc.nextInt();
			switch(a) {
			case 1:
				d.get(ch-1).onDevice();
				break;
			case 2:
				d.get(ch-1).offDevice();
				break;
			default :
				System.out.println("   invalid option");
				
			}
		}
		else
			System.out.println("no device in the room");
	}

	public void roomStatus() {
		
		System.out.println("  ***Check status of*** :\n  1. all devices\n  2. single device\n  0. go back");
		int choice=sc.nextInt();
		switch(choice) {
			case 1:
			{
				for(Device ref:d)
				{
					if(ref instanceof AC)
					{
						AC a=(AC) ref;
						System.out.println(" AC :"+a.getSwtich());
						System.out.println("temprature : "+a.getTemp());
					}
					else if(ref instanceof Tv)
					{
						Tv a=(Tv) ref;
						System.out.println(" TV :"+a.getSwtich());
					}
					else if(ref instanceof Light)
					{
						Light a=(Light) ref;
						System.out.println(" Light :"+a.getSwtich());
					}
					else if(ref instanceof Refrigerator)
					{
						Refrigerator a=(Refrigerator) ref;
						System.out.println(" Refrigerator :"+a.getSwtich());
					} 
				}
			}
			break;
			case 2:
			{
				listDevice();
				System.out.println("  -----select the device-----");
				int ch=sc.nextInt();
				d.get(ch-1).deviceStatus();
			}
			break;
			case 0:
				break;
			default :
				System.out.println("	invalid choice");
			break;
		}
		
	}

	public void listDevice() {
		
		System.out.println("  device        | brand");
		for(int i=0;i<d.size();i++)
		{
			System.out.print("  "+i+1+". ");
			d.get(i).displayDevice();
		}
	}
	
	public void removedevice(int ch) {
		
		d.remove(ch);
	}
	
	public String toString() {
		
		return this.name;
	}
	
}

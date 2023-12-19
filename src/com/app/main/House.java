package com.app.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.app.rooms.Room;

public class House {

	
	List<Room> r;
	public static House instance ;
	Scanner sc=new Scanner(System.in);
	private House() {
		r=new ArrayList<Room>();
		System.out.println("shbv");
	}
	public static House getInstance(){
		
		if(instance==null)
		{
			instance=new House();
		}
        return instance;
    }
	public void addRoom()
	{
		List<String> room=new ArrayList<String>();
		room.add("Kitchen");
		room.add("Living Room");
		room.add("Bedroom");
		room.add("Bathroom");
		room.add("corridor");
		String ch="y";
		do {
			int i;
			System.out.println("  -----select the room type-----");
			for(i=0;i<room.size();i++)
			{
				System.out.println("  "+(i+1)+" "+room.get(i));
			}
			System.out.println("  "+(i+1)+" "+"custom room");
			int ch1=sc.nextInt();
			sc.nextLine();
			if(ch1>room.size()) {
				System.out.println("enter the room name");
			    String name=sc.nextLine();
			    r.add(new Room(name));
			}   	
			else
				r.add(new Room(room.get(ch1-1)));
			
			System.out.println("	!!-Room Added successfully-!!");
			System.out.println("do you want continue adding room y/n");
			ch = sc.nextLine();
		}while(!ch.equals("n"));
	}
	public void goToRoom() {
		
		if(!r.isEmpty()) {
			
			System.out.println("  -----select the room----- ");
			showRooms();
			int ch=sc.nextInt();
			int o;
			do {
				System.out.println("  -------you are in "+r.get(ch-1).getName()+"-------- ");
				System.out.println("  1. add device\n  2. control device\n  3. room status\n  4. remove device\n  0. Exit room");
				o=sc.nextInt();
				switch(o) {
					case 1:
					{
						int choice;
						do {
							System.out.println("  -----select the device to add-----");
							System.out.println("  1. tv\n  2. Ac\n  3. light\n  4. refrigerator\n  0. stop adding");
							choice=sc.nextInt();
							if(choice!=0)
							if(r.get(ch-1).addDevice(choice)!=-1)
							{
								System.out.println("	!!-device Added successfully-!!");
							}
							else
								System.out.println("	!!-device not Added-!!");
						}while(choice!=0);
					}
						break;
					case 2:
					{
						int choice;
						do {	
							r.get(ch-1).listDevice();
							System.out.println("  0. to go back");
							System.out.println("  -----select the device-----");
							choice=sc.nextInt();
							if(choice!=0)
							r.get(ch-1).controlDevice(choice-1);
						}while(choice!=0);
					}
						break;
					case 3:
						r.get(ch-1).roomStatus();
						break;
					case 4:
					{
						r.get(ch-1).listDevice();
						System.out.println("  0. to go back");
						System.out.println("  ------select the device------");
						int choice=sc.nextInt();
						if(choice!=0)
						r.get(ch-1).removedevice(choice-1);
					}
						break;
					case 0:
						System.out.println("	*Exiting room*");
						break;
					default:
						System.out.println("	invalid choice");
						
				}
			}while(o!=0);
		}
		else
		{
			System.out.println("No Rooms in the house\n do you like to add rooms y/n");
			String ans=sc.nextLine();
			if(ans.equals("y"))
			{
				addRoom();
			}
		}
	}
	public void showRooms()
	{
		for(int i=0;i<r.size();i++)
		System.out.println("  "+(i+1)+" "+r.get(i));
		
	}
	
	
}

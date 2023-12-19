package com.app.main;

import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
//		House h=new House();
		House.getInstance();
		System.out.println("welcome to the house");
		int ch;
		do {
			System.out.println("  -------select option-------- ");
			System.out.println("	|1. Add room   |\n	|2. go to room |\n	|0. exit house |");
			
			ch=sc.nextInt();
			switch(ch) {
			case 1:
			{
				House.instance.addRoom();
			}
			break;
			case 2 :
			{
				House.instance.goToRoom();
			}
			break;
			case 0:
				System.out.println("	XXXX- EXITED FROM HOUSE -XXXX");
			break;
			default:
				System.out.println("	invalid choice");
			}
		}while(ch!=0);
		
		sc.close();
	}

}

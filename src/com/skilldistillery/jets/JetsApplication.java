package com.skilldistillery.jets;

import java.util.List;
import java.util.Scanner;

public class JetsApplication {
	//FIELDS
	private AirField airfield;
	private Scanner kb;

	//CONSTRUCTORS
	public JetsApplication() {

	}
	//METHODS
	public static void main(String[] args) {
	JetsApplication ja = new JetsApplication();
	ja.launch();
	}//end of main
	
	public void launch() {
		airfield = new AirField();
		System.out.println(airfield.getJets().toString());
		kb = new Scanner(System.in);
		
	}
	
	public void displayUserMenu(Scanner kb) {
		System.out.println("1.) List fleet"); 
		System.out.println("2.) Fly all jets"); 
		System.out.println("3.) View fastest jet"); 
		System.out.println("4.) View jet with longest range"); 
		System.out.println("5.) Load all Cargo Jets"); 
		System.out.println("6.) Dogfight!"); 
		System.out.println("7.) Add a jet to Fleet"); 
		System.out.println("8.) Remove a jet from Fleet"); 
		System.out.println("9.) Quit"); 

		int input = kb.nextInt();
		
		switch (input) {
		case 1:
			break;
		default:
			break;
		}
		
	}

}

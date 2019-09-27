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
	ja.airfield = new AirField();
	ja.kb = new Scanner(System.in);
	
	ja.launch(ja.kb, ja.airfield.getJets());
	
	}//end of main
	
	public void launch(Scanner kb, List<Jet> jets) {
		airfield = new AirField();
		System.out.println(airfield.getJets().toString());
		
	}
	
	public void displayUserMenu(Scanner kb, List<Jet> jets) {
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
			for (Jet jet : jets) {
				jet.toString();
				System.out.println();
			}
			break;
		case 2:
			for (Jet jet : jets) {
				jet.fly();
			}
			break;
		case 3:
			Jet fastest = jets.get(0);
			for (Jet jet : jets) {
				if(jet.getSpeed() > fastest.getSpeed()) {
					fastest = jet;
				}
			}
			System.out.println(fastest);
			break;
		case 4:
			Jet rangiest = jets.get(0);
			for (Jet jet : jets) {
				if(jet.getRange() > rangiest.getRange()) {
					rangiest = jet;
				}
			}
			System.out.println(rangiest);
			break;
		case 5:
			for (Jet jet : jets) {
				if(jet instanceof CargoPlane) {
					((CargoPlane) jet).loadCargo();
				}
			}
			break;
		case 6:
			for (Jet jet : jets) {
				if(jet instanceof FighterJet) {
					((FighterJet) jet).fight();
				}
			}
			break;
		case 7:
			break;
		case 8:
			break;
		case 9:
			break;
		default:
			break;
		}
		
	}

}

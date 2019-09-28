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
		boolean keepGoing = true;
		
		
		do {
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
//			System.out.println("Add a jet. ");
				System.out.println("Enter jet model/name: ");
				String model = kb.nextLine();
				kb.nextInt();
				System.out.println("Enter speed: ");
				double speed = kb.nextDouble();
				System.out.println("Enter range: ");
				int range = kb.nextInt();
				System.out.println("Enter price: ");
				long price = kb.nextInt();
				
				System.out.println("If your jet is a fighter, enter an 'f': ");
				System.out.println("If your jet is a cargo plane, enter a 'c': ");
				String jetType = kb.next();
				
				Jet jet = null;
				switch (jetType) {
				case "f":
					jet = new FighterJet(model, speed, range, price);
					break;
				case "c":
					jet = new CargoPlane(model, speed, range, price);
					break;
				default:
					jet = new BasicJet(model, speed, range, price);
					break;
				}
				jets.add(jet); //need to return this list
				break;
			case 8:
				System.out.println("Which jet would you like to remove? Enter # in the list: ");
				int toRemove = kb.nextInt();
				toRemove++;
				jets.remove(toRemove);
				break;
			case 9:
				System.out.println("Quitting...");
				keepGoing = false;
				break;
			default:
				System.out.println("Invalid entry. Try again.");
				break;
			}
			
		}while(keepGoing);
		
		
	}

}

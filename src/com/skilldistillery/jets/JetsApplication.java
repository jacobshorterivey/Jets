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
//		System.out.println(airfield.getJets().toString());
		displayUserMenu(kb, jets);
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
			
			int input = 1;
			input = kb.nextInt();
			
			switch (input) {
			case 1:
				listAllJets(jets);
				break;
			case 2:
				flyAllJets(jets);
				break;
			case 3:
				viewFastest(jets);
				break;
			case 4:
				viewRangiest(jets);
				break;
			case 5:
				loadAllCargoJets(jets);
				
				break;
			case 6:
				dogfightFighters(jets);
				break;
			case 7:
				addJet(jets);
				break;
			case 8:
				removeJet(jets);
				break;
			case 9:
				System.out.println("Quitting...");
				keepGoing = false;
				break;
			default:
				System.out.println("Invalid entry. Try again.");
				break;
			}
			System.out.println();
		}while(keepGoing);
	}
	
	public void listAllJets(List<Jet> jets) {
		for (Jet jet : jets) {
			System.out.println(jet);
		}
	}
	public void flyAllJets(List<Jet> jets) {
		for (Jet jet : jets) {
			jet.fly();
			System.out.println();
		}
	}
	public void viewFastest(List<Jet> jets) {
		Jet fastest = jets.get(0);
		for (Jet jet : jets) {
			if(jet.getSpeed() > fastest.getSpeed()) {
				fastest = jet;
			}
		}
		System.out.println(fastest);
	}
	public void viewRangiest(List<Jet> jets) {
		Jet rangiest = jets.get(0);
		for (Jet jet : jets) {
			if(jet.getRange() > rangiest.getRange()) {
				rangiest = jet;
			}
		}
		System.out.println(rangiest);
	}
	public void loadAllCargoJets(List<Jet> jets) {
		for (Jet jet : jets) {
			if(jet instanceof CargoPlane) {
				((CargoPlane) jet).loadCargo();
			}
		}
	}
	public void dogfightFighters(List<Jet> jets) {
		for (Jet jet : jets) {
			if(jet instanceof FighterJet) {
				((FighterJet) jet).fight();
			}
		}
	}
	public List<Jet> addJet(List<Jet> jets) {
		Scanner jetIn = new Scanner(System.in);
		
		System.out.println("If your jet is a fighter, enter an 'f'. ");
		System.out.println("If your jet is a cargo plane, enter a 'c'. ");
		System.out.println("Enter any other letter for a basic jet: ");
		String jetType = kb.next();
		System.out.println("Enter jet model/name: ");
		String model = jetIn.nextLine();
		System.out.println("Enter speed: ");
		double speed = jetIn.nextDouble();
		System.out.println("Enter range: ");
		int range = jetIn.nextInt();
		System.out.println("Enter price: ");
		long price = jetIn.nextLong();
		
		
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
		System.out.println(jets);
		
		jetIn.close();
		
		return jets;
		
	}
	public List<Jet> removeJet(List<Jet> jets) {
		Scanner jetOut = new Scanner(System.in);
		
		System.out.println("Which jet would you like to remove? Enter # in the list: ");
		int toRemove = jetOut.nextInt();
		toRemove++;
		jets.remove(toRemove);
		System.out.println(jets);
		
		jetOut.close();
		
		return jets;
		
	}
	
	
	
	
	
	
}

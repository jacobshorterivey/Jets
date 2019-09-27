package com.skilldistillery.jets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AirField {
	// FIELDS
	private List<Jet> jets = new ArrayList<Jet>();;
	private String fileName = "jets.txt";

	// CONSTRUCTORS
	public AirField() {
		parseJets(fileName);
	}

	// METHODS
	public List<Jet> getJets() {
		return jets;
	}

	public void setJets(List<Jet> jets) {
		this.jets = jets;
	}

	public List<Jet> parseJets(String fileName) {
		try (BufferedReader bufIn = new BufferedReader(new FileReader(fileName))) {
			String line;

			while ((line = bufIn.readLine()) != null) {
				String[] jetLine = line.split(", ");

				String jetType = jetLine[0];
				String model = jetLine[1];
				Double speed = Double.parseDouble(jetLine[2]);
				Integer range = Integer.parseInt(jetLine[3]);
				Long price = Long.parseLong(jetLine[4]);


				switch (jetType) {
				case "b":
					BasicJet b = new BasicJet(model, speed, range, price);
					jets.add(b);
					break;
				case "f":
					FighterJet f = new FighterJet(model, speed, range, price);
					jets.add(f);
					break;
				case "c":
					CargoPlane c = new CargoPlane(model, speed, range, price);
					jets.add(c);
					break;
				default:
					break;
				}

//				Jet j = new Jet(model, speed, range, price);
//				jets.add(j);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return jets;
	}

//	public static void main(String[] args) {
//		AirField af = new AirField();
//		System.out.println(af.getJets());
//	}

}

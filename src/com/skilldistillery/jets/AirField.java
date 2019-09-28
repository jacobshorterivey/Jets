package com.skilldistillery.jets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AirField {
	// FIELDS
	private List<Jet> jets = new ArrayList<>();
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

				
				Jet jet = null;

				switch (jetType) {
				case "b":
					jet = new BasicJet(model, speed, range, price);
					break;
				case "f":
					jet = new FighterJet(model, speed, range, price);
					break;
				case "c":
					jet = new CargoPlane(model, speed, range, price);
					break;
				default:
					break;
				}

				jets.add(jet);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return jets;
	}

	public static void main(String[] args) {
		AirField af = new AirField();
		System.out.println(af.getJets());
	}

}

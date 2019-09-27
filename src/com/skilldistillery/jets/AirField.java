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
		List<Jet> jets = new ArrayList<Jet>();

		try (BufferedReader bufIn = new BufferedReader(new FileReader(fileName))) {
			String line;

			while ((line = bufIn.readLine()) != null) {
				String[] jetLine = line.split(", ");
				
				String model = jetLine[0];
				
				Double speed = Double.parseDouble(jetLine[1]);
				Integer range = Integer.parseInt(jetLine[2]);
				Long price = Long.parseLong(jetLine[3]);
				Jet j = new Jet(model, speed, range, price);

				jets.add(j);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return jets;
	}
	
//	public static void main(String[] args) {
//		AirField af = new AirField();
//		System.out.println(af.getJets().toString());
//	}

}

package com.skilldistillery.jets;

public class Jet {
	
	//FIELDS
	private String model;
	private double speed;
	private int range;
	private long price;
	
	//CONSTRUCTORS
	public Jet(String model, double speed, int range, long price) {
		super();
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}

	//METHODS
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}
	
	public void fly() {
		System.out.printf(getModel() + " taking off. This jet can fly for %2f hours.", (range/speed));
	}
	
	public double getSpeedInMach() {
		
		return getSpeed() / 767.269;
	}

	@Override
	public String toString() {
		return "Model: " + model + ", speed: " + speed + " MPH, speed in Mach: Mach " + getSpeedInMach() + ", range: " + range + ", price: $" + price;
	}


	
	
}

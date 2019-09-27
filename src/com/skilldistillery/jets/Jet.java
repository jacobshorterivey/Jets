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
		toString();
		System.out.println("Flying...");
		System.out.println("This jet can fly for " + (range/speed) + " hours." );
	}
	
	public double getSpeedInMach() {
		return getSpeed() / 767.269;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Model:")
		.append(model)
		.append(", speed: ")
		.append(speed)
		.append(" MPH, speed (in Mach): Mach ")
		.append(getSpeedInMach())
		.append(", range: ")
		.append(range)
		.append(" miles, price: $")
		.append(price)
		.append("]\n");
		return builder.toString();
	}
	
	
}

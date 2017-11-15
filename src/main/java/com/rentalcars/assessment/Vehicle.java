package com.rentalcars.assessment;

import java.util.HashMap;

public class Vehicle {
	
	private String name;
	private String sipp;
	private float price;
	private String supplier;
	private float rating;
	
	private static HashMap<String, String> carTypeHash = new HashMap<String, String>();
    private static HashMap<String, String> doorTypeHash = new HashMap<String, String>();
    private static HashMap<String, String> transmissionTypeHash = new HashMap<String, String>();
    private static HashMap<String, String> airConTypeHash = new HashMap<String, String>();
	

	public Vehicle(String name, String sipp, float price, String supplier, float rating) {
		this.name = name;
		this.sipp = sipp;
		this.price = price;
		this.supplier = supplier;
		this.rating = rating;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
        this.name = name;
    }
	
	public String getSipp() {
        return sipp;
    }

    public void setSipp(String sipp) {
        this.sipp = sipp;
    }
    
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
    
    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
    
    public static void initSipp() {
    		createHashes();
    }
    
    
    public String getCarType() {
	    	String type = new String();
	    	type = carTypeHash.get(sipp.substring(0,1));
	    	return type;
    }
    
    public String getDoorType() {
	    	String type = new String();
	    	type = doorTypeHash.get(sipp.substring(1,2));
	    	return type;
    }
    
    public String getTransmissionType() {
	    	String type = new String();
	    	type = transmissionTypeHash.get(sipp.substring(2,3));
	    	return type;
    }
    
    public String getAirConType() {
	    	String type = new String();
	    	type = airConTypeHash.get(sipp.substring(3,4));
	    	return type;
    }
    
    public String toString() {
        return "name=" + name + "," + "Price = " + price + ", " + "Supplier = " + supplier + ", " + "Rating = " + rating;
    }
    
    public int getScore() {
		
		int score = 0;
		
		if (this.getTransmissionType() == "Manual") 
			score += 1;
		else if (this.getTransmissionType() == "Automatic")
			score += 5;
		
		if (this.getAirConType() == "Petrol/no AC")
			score += 2;
			
		return score;
		
	}
    
    public float sumOfScores() {
    		float sum = 0;
    		sum = this.getRating() + this.getScore();
    		return sum;
    }
    
    public static void createHashes() {
    	carTypeHash.put("M", "Mini");
        carTypeHash.put("E", "Economy");
        carTypeHash.put("C", "Compact");
        carTypeHash.put("I", "Intermediate");
        carTypeHash.put("S", "Standard");
        carTypeHash.put("F", "Full size");
        carTypeHash.put("P", "Premium");
        carTypeHash.put("L", "Luxury");
        carTypeHash.put("X", "Special");

        // Doors/car type map
        doorTypeHash.put("B", "2 doors");
        doorTypeHash.put("C", "4 doors");
        doorTypeHash.put("D", "5 doors");
        doorTypeHash.put("W", "Estate");
        doorTypeHash.put("T", "Convertible");
        doorTypeHash.put("F", "SUV");
        doorTypeHash.put("P", "Pick up");
        doorTypeHash.put("V", "Passenger Van");

        // Transmission map
        transmissionTypeHash.put("M", "Manual");
        transmissionTypeHash.put("A", "Automatic");

        // Fuel/Air con map
        airConTypeHash.put("N", "Petrol/no AC");
        airConTypeHash.put("R", "Petrol/AC");
    }

}

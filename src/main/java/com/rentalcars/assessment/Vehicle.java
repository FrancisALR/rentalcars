package com.rentalcars.assessment;

import java.util.HashMap;

public class Vehicle {
	
	private String name;
	private String sipp;
	private float price;
	private String supplier;
	private float rating;
	
	private static HashMap<String, String> carTypeMap = new HashMap<String, String>();
    private static HashMap<String, String> doorTypeMap = new HashMap<String, String>();
    private static HashMap<String, String> tranmissionTypeMap = new HashMap<String, String>();
    private static HashMap<String, String> airConTypeMap = new HashMap<String, String>();
	

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
	    	type = carTypeMap.get(sipp.substring(0,1));
	    	return type;
    }
    
    public String getDoorType() {
	    	String type = new String();
	    	type = doorTypeMap.get(sipp.substring(1,2));
	    	return type;
    }
    
    public String getTransmissionType() {
	    	String type = new String();
	    	type = tranmissionTypeMap.get(sipp.substring(2,3));
	    	return type;
    }
    
    public String getAirConType() {
	    	String type = new String();
	    	type = airConTypeMap.get(sipp.substring(3,4));
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
    	carTypeMap.put("M", "Mini");
        carTypeMap.put("E", "Economy");
        carTypeMap.put("C", "Compact");
        carTypeMap.put("I", "Intermediate");
        carTypeMap.put("S", "Standard");
        carTypeMap.put("F", "Full size");
        carTypeMap.put("P", "Premium");
        carTypeMap.put("L", "Luxury");
        carTypeMap.put("X", "Special");

        // Doors/car type map
        doorTypeMap.put("B", "2 doors");
        doorTypeMap.put("C", "4 doors");
        doorTypeMap.put("D", "5 doors");
        doorTypeMap.put("W", "Estate");
        doorTypeMap.put("T", "Convertible");
        doorTypeMap.put("F", "SUV");
        doorTypeMap.put("P", "Pick up");
        doorTypeMap.put("V", "Passenger Van");
  
        // Transmission map
        tranmissionTypeMap.put("M", "Manual");
        tranmissionTypeMap.put("A", "Automatic");

        // Fuel/Air con map
        airConTypeMap.put("N", "Petrol/no AC");
        airConTypeMap.put("R", "Petrol/AC");
    }

}

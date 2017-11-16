package com.rentalcars.assessment;

import com.google.gson.Gson;
import java.util.*;
import static spark.Spark.*;

import java.io.FileReader;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class JsonParser {
	
	
    
	public static void main(String[] args) {
		ArrayList<Vehicle> vehicles = parseJSON("vehicles.json");
		// Task 1
		System.out.println("Task 1");
		formatArrList(sortByPrice(vehicles));
		// Task 2
		System.out.println("Task 2");
		formatArrListQ2(vehicles);
		// Task 3
		System.out.println("Task 3");
		formatArrListQ3(sortBySupplierRating(vehicles));
		// Task 4
		System.out.println("Task 4");
		formatArrListQ4(sortBySumOfScores(vehicles));
	}
	
	public static ArrayList<Vehicle> parseJSON(String file_path) {
		ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

		Gson gson = new Gson();
		try {
			JsonObject object = gson.fromJson(new FileReader(file_path), JsonObject.class);
			JsonArray vehicleArray = object.getAsJsonObject("Search").getAsJsonArray("VehicleList");
			
			for (int i=0; i < vehicleArray.size(); i++) {
				Vehicle vehicle = gson.fromJson(vehicleArray.get(i), Vehicle.class);
				vehicles.add(vehicle);
			};
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return vehicles;
	}    
	
	public static ArrayList<Vehicle> sortByPrice(ArrayList<Vehicle> vehicles){
		
		Collections.sort(vehicles, new Comparator<Vehicle>() {
		    public int compare(Vehicle c1, Vehicle c2) {
		        return Double.compare(c1.getPrice(), c2.getPrice());
		    }
		});
		return vehicles;
		
	}
	
	public static ArrayList<Vehicle> sortBySupplierRating(ArrayList<Vehicle> vehicles){
		
		Collections.sort(vehicles, new Comparator<Vehicle>() {
		    public int compare(Vehicle v1, Vehicle v2) {
		    	int val = v1.getSupplier().compareTo(v2.getSupplier());
		    	val = Double.compare(v1.getRating(), v2.getRating());
		        return val;
		    }
		    
		});
		Collections.reverse(vehicles);
		return vehicles;
		
	}
	
	public static ArrayList<Vehicle> sortBySumOfScores(ArrayList<Vehicle> vehicles) {
		Collections.sort(vehicles, new Comparator<Vehicle>() {
		    public int compare(Vehicle v1, Vehicle v2) {
		    	int val = Double.compare(v1.sumOfScores(), v2.sumOfScores());
		        return val;
		    }
		    
		});
		Collections.reverse(vehicles);
		return vehicles;
	}
	
	
	public static void formatArrList(ArrayList<Vehicle> a) {
		 for (int i = 0; i < a.size() ; i++) {
	            System.out.printf("%2d. %s - %s%n", i+1, a.get(i).getName(), a.get(i).getPrice());
		 }	
	}
	
	public static void formatArrListQ2(ArrayList<Vehicle> a) {
		Vehicle.initSipp();
		for (int i = 0; i < a.size() ; i++) {
			System.out.printf("%2d. %s - %s - %s - %s - %s - %s%n", i+1, a.get(i).getName(), a.get(i).getSipp(), a.get(i).getCarType(), a.get(i).getDoorType(), a.get(i).getTransmissionType(), a.get(i).getAirConType());
		}	
	}
	
	public static void formatArrListQ3(ArrayList<Vehicle> a) {
		for (int i = 0; i < a.size() ; i++) {  
			System.out.printf("%2d. %s - %s - %s - %s%n", i+1, a.get(i).getName(), a.get(i).getSipp(), a.get(i).getRating(), a.get(i).getSupplier());
		}	
	}
	
	public static void formatArrListQ4(ArrayList<Vehicle> a) {
		for (int i = 0; i < a.size() ; i++) {
			System.out.printf("%2d. %s - %s - %s - %s%n", i+1, a.get(i).getName(), a.get(i).getCarType(), a.get(i).getSupplier(), a.get(i).sumOfScores());
		}	
	}
	
	
	 
}

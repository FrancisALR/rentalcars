package com.rentalcars.assessment;
import static spark.Spark.*;
import spark.Request;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.FileReader;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.FileReader;
import java.util.ArrayList;


public class Service {
		private static Gson gson = new Gson();
		static JsonParser json_parser = new JsonParser();
		private static ArrayList<Vehicle> vehicles = JsonParser.parseJSON("vehicles.json");
 
	public static void main(String[] args) {
		get("/", (req,res) -> "Hello world");
		System.out.println(vehicles);
		System.out.println(vehicles);

		
		get("/t1", (req, res) -> {
	            res.status(200);
	            return JsonParser.sortByPrice(vehicles);
		});
		
		get("/t3", (req, res) -> {
            res.status(200);
            return JsonParser.sortBySupplierRating(vehicles);
	});
		
		get("/t4", (req, res) -> {
            res.status(200);
            return JsonParser.sortBySumOfScores(vehicles);
	});
		
	
	}
	
}
    
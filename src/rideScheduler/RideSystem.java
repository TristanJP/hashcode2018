package rideScheduler;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import importer.Importer;
import trip.Ride;
import trip.Vehicle;

public class RideSystem {
	
	private void mainMethod() {
		/*
		try {
			System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream("output.txt"))));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		Importer importer = Importer.getInstance();
		
		RideQueue rideQueue = new RideQueue();
		
		VehicleManager vehicleManager = new VehicleManager(importer.getNumberOfVehicles());
		
		RideManager rideManager = new RideManager(rideQueue, vehicleManager);
				
		while (ticker < importer.getNumberOfSteps()) {
			tick();
			rideManager.tick();
			//System.out.println("Current Tick is " + ticker);
		}
				
		for (Vehicle vehicle : vehicleManager.getVehicles()) {
			System.out.println(vehicle.toString());
		}		
	}
	
	private static int ticker;
	
	public void tick() {
		ticker++;
	}
	
	public static int getTick() {
		return ticker;
	}

	public static void main(String args[]) {
		RideSystem rideSystem = new RideSystem();
		rideSystem.mainMethod();		
		
		
			
	}
}


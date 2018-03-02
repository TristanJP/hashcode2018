package rideScheduler;

import importer.Importer;

public class RideSystem {
	
	private static int ticker;
	
	public static void tick() {
		ticker++;
	}
	
	public static int getTick() {
		return ticker;
	}

	public static void main(String args[]) {
		Importer importer = Importer.getInstance();
		
		RideQueue rideQueue = new RideQueue();
		
		VehicleManager vehicleManager = new VehicleManager(importer.getNumberOfVehicles());
		
		RideManager rideManager = new RideManager(rideQueue, vehicleManager);
		
		rideManager.initialise();
		
		while (ticker < importer.getNumberOfSteps()) {
			tick();
		}
		
			
	}
}


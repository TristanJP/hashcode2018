package rideScheduler;

import importer.Importer;

public class RideSystem {
	
	private void mainMethod() {
		Importer importer = Importer.getInstance();
		
		RideQueue rideQueue = new RideQueue();
		
		VehicleManager vehicleManager = new VehicleManager(importer.getNumberOfVehicles());
		
		RideManager rideManager = new RideManager(rideQueue, vehicleManager);
		
		rideManager.initialise();
		
		while (ticker < importer.getNumberOfSteps()) {
			tick();
			vehicleManager.tick();
			System.out.println("Current Tick is " + ticker);
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


package rideScheduler;

import importer.Importer;

public class RideSystem {
	
	private int ticker;
	
	public void tick() {
		ticker++;
	}

	
	
	public static void main(String args[]) {
		Importer importer = Importer.getInstance();
		
		RideQueue rideQueue = new RideQueue();
		
		
	}
}

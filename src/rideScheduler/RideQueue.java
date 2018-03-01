package rideScheduler;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;

import importer.Importer;
import trip.Ride;

public class RideQueue  {

	private ArrayBlockingQueue<Ride> queue;
	
	public RideQueue() {
		ArrayList<Ride> rides = Importer.getInstance().getRides();
	}
	
	public ArrayBlockingQueue getQueue() {
		return queue;
	}
	
}

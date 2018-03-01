package rideScheduler;

import java.util.concurrent.ArrayBlockingQueue;

import trip.Ride;

public class RideQueue  {

	private ArrayBlockingQueue<Ride> queue;
	
	public RideQueue() {
		
	}
	
	public ArrayBlockingQueue getQueue() {
		return queue;
	}
	
}

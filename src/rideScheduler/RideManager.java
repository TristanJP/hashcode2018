package rideScheduler;

import trip.*;
import java.util.Queue;

public class RideManager {
	private Queue<Ride> rideQueue;
	private VehicleManager vehicleManager;
	
	public RideManager(Queue rq, VehicleManager vm) 
	{
		rideQueue = rq;
		vehicleManager = vm;
	}
	
	public void step() 
	{
		
	}
	
	public void assignNextRide()
	{
		Ride ride = rideQueue.poll();
		
		if (ride != null) {
			
		}
	}

}

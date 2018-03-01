package rideScheduler;

import trip.*;
import java.util.Queue;
import importer.*;

public class RideManager {
	private Queue<Ride> rideQueue;
	private VehicleManager vehicleManager;
	
	public RideManager(RideQueue rq, VehicleManager vm) 
	{
		rideQueue = rq.getQueue();
		vehicleManager = vm;
		
		initialise();
		
	}
	
	public void initialise()
	{
		int free = Importer.getInstance().getNumberOfVehicles();
		
		for (int i = 0; i < free; i++) {
			Vehicle v = vehicleManager.getVehicle(i);
			Ride r = rideQueue.poll();
			v.setRide(r);	
			
			//TEMP
			System.out.println("" + i + " " + r);
		}
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

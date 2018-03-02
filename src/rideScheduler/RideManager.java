package rideScheduler;

import trip.*;
import java.util.ArrayList;
import java.util.Queue;
import importer.*;

public class RideManager implements Ticker {
	private Queue<Ride> rideQueue;
	private ArrayList<Ride> pendingRides;
	private VehicleManager vehicleManager;
	
	public RideManager(RideQueue rq, VehicleManager vm) 
	{
		rideQueue = rq.getQueue();
		pendingRides = new ArrayList<Ride>();
		vehicleManager = vm;
		
		initialise();
		
	}
	
	public void tick() {
		vehicleManager.tick();
	}
	
	public void initialise()
	{
		int free = Importer.getInstance().getNumberOfVehicles();
		
		for (int i = 0; i < free; i++) {
			Vehicle v = vehicleManager.getVehicle(i);
			Ride r = rideQueue.poll();
			pendingRides.add(r);
			v.setRide(r);	
			
			//TEMP
			System.out.println(v.toString());
		}
	}
	
	public void findClosestVehicle()
	{
		int pendingLength = pendingRides.size();
		
		for (int i = 0; i < pendingLength; i++) {
			Ride r = pendingRides.get(i);
			
			Vehicle currentV = null;
			for (Vehicle v : vehicleManager.getAvailableVehicles()){
				if (v.getRide().equals(r)){
					currentV = v;
				}
			}
			Vehicle closestVehicle = currentV;
			int distance = r.getStartPos().getDistanceBetween(currentV.getLocation());
			int lowestDistance = distance;
			int availableLength = vehicleManager.getAvailableVehicles().size();
			
			for (int j = 0; j < availableLength; j++) {
				Vehicle v = vehicleManager.getAvailableVehicles().get(j);
				int d = r.getStartPos().getDistanceBetween(v.getLocation());
				
				if (d < lowestDistance) {
					lowestDistance = d;
					closestVehicle = v;
				}				
			}
			
			if (lowestDistance < distance) {
				currentV.removeRide();
				closestVehicle.setRide(r);
			}
			
		}
		Ride ride = rideQueue.poll();
		
		if (ride != null) {
			
		}
	}

}

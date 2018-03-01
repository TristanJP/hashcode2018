package rideScheduler;
import java.util.ArrayList;

import Types.Coordinate;
import trip.Vehicle;

public class VehicleManager {
	
	private ArrayList<Vehicle> vehicles;
	
	public VehicleManager(int vNum)
	{
		vehicles = new ArrayList<Vehicle>(); 
		for(int i = 0; i < vNum; i++)
		{
			vehicles.add(new Vehicle());
		}
	}
	
	public void updateList(Vehicle vehicle) {
		Coordinate newPos = vehicle.getRide().getEndPos();
		
		for (int i = 0; i < vehicles.size(); i++) {
		}
	}
	
}

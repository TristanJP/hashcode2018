package rideScheduler;
import java.util.ArrayList;

import trip.Vehicle;

public class VehicleManager {
	private ArrayList<Vehicle> generatedVehicles;
	public VehicleManager(int vNum)
	{
		generatedVehicles = new ArrayList<Vehicle>(); 
		for(int i = 0; i< vNum; i++)
		{
			generatedVehicles.add(new Vehicle());
		}
	}
}

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
			vehicles.add(new Vehicle(this));
		}
	}
	
	public void updateList(Vehicle vehicle) {
		Coordinate newPos = vehicle.getRide().getEndPos();
		int indexToInsert = 0;
		
		indexToInsert = sortX(indexToInsert, newPos);
		indexToInsert = sortY(indexToInsert, newPos);
		
		vehicles.remove(vehicle);
		vehicles.add(indexToInsert+1, vehicle);
	}
	
	public ArrayList<Vehicle> getVehicles()
	{
		return vehicles;
	}
	
	public int sortX(int indexToInsert, Coordinate newPos) {
		for (int i = indexToInsert; i < vehicles.size(); i++) {
			if (vehicles.get(i).getLocation().getX() <= newPos.getX()) {
				indexToInsert = i;
			}
			else {
				return indexToInsert;
			}
		}
		return indexToInsert;
	}
	
	public int sortY(int indexToInsert, Coordinate newPos) {
		for (int i = indexToInsert; i < vehicles.size(); i++) {
			if (vehicles.get(i).getLocation().getY() <= newPos.getY()) {
				indexToInsert = i;
			}
			else {
				return indexToInsert;
			}
		}
		return indexToInsert;
	}
	
	public Vehicle getVehicle(int index) {
		return vehicles.get(index);
	}
	
	public tick() {
		for (Vehicle vehicle : vehicles) {
			vehicle.tick();
		}
	}

}

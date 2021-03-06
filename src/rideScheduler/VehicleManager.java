package rideScheduler;
import java.util.ArrayList;

import Types.Coordinate;
import trip.Vehicle;

public class VehicleManager implements Ticker {
	
	private ArrayList<Vehicle> vehicles;
	private ArrayList<Vehicle> availableVehicles;
	
	public VehicleManager(int vNum)
	{
		vehicles = new ArrayList<Vehicle>(); 
		availableVehicles = new ArrayList<Vehicle>();
		for(int i = 0; i < vNum; i++)
		{
			Vehicle v = new Vehicle(this);
			
			vehicles.add(v);
			availableVehicles.add(v);
		}
	}
	
	public void updateList(Vehicle vehicle) {
		Coordinate newPos = vehicle.getRide().getEndPos();
		int indexToInsert = 0;
		
		indexToInsert = sortX(indexToInsert, newPos);
		indexToInsert = sortY(indexToInsert, newPos);
		
		vehicles.remove(vehicle);
		try {
			vehicles.add(indexToInsert+1, vehicle);
		}
		catch(IndexOutOfBoundsException e){
			vehicles.add(vehicle);
		}
	}
	
	public ArrayList<Vehicle> getVehicles()
	{
		return vehicles;
	}
	
	public ArrayList<Vehicle> getAvailableVehicles() {
		return availableVehicles;
	}
	
	public int sortX(int indexToInsert, Coordinate newPos) {
		for (int i = indexToInsert; i < vehicles.size(); i++) {
			Vehicle v = vehicles.get(i);
			if (v == null) {
				System.out.println("vehicle");
				}
			Coordinate c = v.getLocation();
			if (c == null) {
				System.out.println("coordinate");
				}
			int x = c.getX();
			if (x <= newPos.getX()) {
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
			Vehicle v = vehicles.get(i);
			Coordinate c = v.getLocation();
			int y = c.getY();
			if (y <= newPos.getY()) {
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
	
	public void makeAvailable(Vehicle v) {
		availableVehicles.add(v);
	}
	
	public void makeUnavailable(Vehicle v) {
		availableVehicles.remove(v);
	}
	
	public void tick() {
		for (Vehicle vehicle : vehicles) {
			vehicle.tick();
		}
	}

}

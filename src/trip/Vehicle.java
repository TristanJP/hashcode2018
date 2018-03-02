package trip;

import rideScheduler.*;
import Types.Coordinate;

public class Vehicle {
	private Ride ride;
	private Coordinate loc;
	private VehicleManager vehicleManager;
	
	public Vehicle(VehicleManager vm)
	{
		vehicleManager = vm;
		setLocation(new Coordinate(0,0));
	}
	
	public Coordinate getLocation()
	{
		return loc;
	}
	public void setLocation(Coordinate newLoc)
	{
		loc = newLoc;
	}
	public Ride getRide()
	{
		return ride;
	}
	public void setRide(Ride cRide)
	{
		ride = cRide;
		//vehicleManager.updateList(this);
	}
	
	public void tick() {
		this.ride.tick();
		if (this.ride.getDistanceLeft() == 0) {
			this.ride = null;
		}
	}
	
}

package trip;

import rideScheduler.*;

import java.util.ArrayList;

import Types.Coordinate;

public class Vehicle {
	private Ride ride;
	private Coordinate loc;
	private VehicleManager vehicleManager;
	
	private ArrayList<Ride> ridesCompleted = new ArrayList<>();
	private boolean atStartPoint = false;
	
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
	
	public ArrayList<Ride> getPastRides() {
		return this.ridesCompleted;
	}
	
	public boolean isAtStartPoint() {
		return this.atStartPoint;
	}
	
	public String toString() {
		String returnString = new Integer(this.ridesCompleted.size()).toString();
		for (Ride ride : this.ridesCompleted) {
			returnString += " " + ride.toString();
		}
		return returnString;
	}
	
	public void tick() {
		if (getRide() != null) {
			if ((this.getLocation().getX() -  getRide().getStartPos().getX()) > 0) { //forwards along X
				this.getLocation().move(1, 0);
			} else if ((getRide().getStartPos().getX() -  this.getLocation().getX()) > 0) { //backwards along X
				this.getLocation().move(-1, 0);
			} else if (Math.abs(this.getLocation().getY() -  getRide().getStartPos().getY()) > 0){ //forwards along Y
				this.getLocation().move(0, 1);
			} else if ((getRide().getStartPos().getY() -  this.getLocation().getY()) > 0) { //backwards along Y
				this.getLocation().move(0, -1);
			} else { //At start point
				atStartPoint = true;
			}
			
			this.ride.tick();
			if (this.ride.getDistanceLeft() == 0) {
				ridesCompleted.add(this.ride);
				this.ride = null;
				this.atStartPoint = false;
			}
			
		}
		
	}
	
	
	
}

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
		vehicleManager.updateList(this);
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
	
	public void removeRide()
	{
		ride = null;
	}
	
	public void tick() {
		if (getRide() != null) {
			if (!isAtStartPoint()) {
				if ((this.getLocation().getX() -  getRide().getStartPos().getX()) > 0) { //forwards along X
					this.getLocation().move(1, 0);
				} else if ((getRide().getStartPos().getX() -  this.getLocation().getX()) > 0) { //backwards along X
					this.getLocation().move(-1, 0);
				} else if (Math.abs(this.getLocation().getY() -  getRide().getStartPos().getY()) > 0){ //forwards along Y
					this.getLocation().move(0, 1);
				} else if ((getRide().getStartPos().getY() -  this.getLocation().getY()) > 0) { //backwards along Y
					this.getLocation().move(0, -1);
				}
			}
			
			if (this.getLocation().equals(this.ride.getStartPos())) {
				this.atStartPoint = true;
			}
			
			if (isAtStartPoint()) {
				if (RideSystem.getTick() > this.ride.getEarliestStep()) {
					this.ride.tick();
					if ((this.getLocation().getX() -  getRide().getEndPos().getX()) > 0) { //forwards along X
						this.getLocation().move(1, 0);
					} else if ((getRide().getEndPos().getX() -  this.getLocation().getX()) > 0) { //backwards along X
						this.getLocation().move(-1, 0);
					} else if (Math.abs(this.getLocation().getY() -  getRide().getEndPos().getY()) > 0){ //forwards along Y
						this.getLocation().move(0, 1);
					} else if ((getRide().getEndPos().getY() -  this.getLocation().getY()) > 0) { //backwards along Y
						this.getLocation().move(0, -1);
					}
					if (this.ride.getDistanceLeft() == 0) {
						ridesCompleted.add(this.ride);
						this.ride = null;
						this.atStartPoint = false;
					}
				}
			}
			
			
			
		}
		
	}
	
	
	
}

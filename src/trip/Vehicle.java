package trip;
import Types.Coordinate;

public class Vehicle {
	private Ride ride;
	private Coordinate loc;
	
	public Vehicle()
	{

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
	}
	
}

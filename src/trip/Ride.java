package trip;

import Types.Coordinate;
import rideScheduler.*;

public class Ride implements Ticker {
	
	private Integer id;
	private Coordinate startPos, endPos;
	private int earliestStep, latestStep, distance, distanceLeft;
	
	public Ride(Integer id, Coordinate startPosition, Coordinate endPosition, int earliestStep, int latestStep) {
		this.id = id;
		setStartPos(startPosition);
		setEndPos(endPosition);
		setEarliestStep(earliestStep);
		setLatestStep(latestStep);
		setDistance();
		setDistanceLeft(distance);
	}
	
	public Coordinate getStartPos() {
		return startPos;
	}
	
	private void setStartPos(Coordinate startPos) {
		this.startPos = startPos;
	}
	
	public Coordinate getEndPos() {
		return endPos;
	}
	
	private void setEndPos(Coordinate endPos) {
		this.endPos = endPos;
	}

	public int getEarliestStep() {
		return earliestStep;
	}

	private void setEarliestStep(int earliestStep) {
		this.earliestStep = earliestStep;
	}

	public int getLatestStep() {
		return latestStep;
	}

	private void setLatestStep(int latestStep) {
		this.latestStep = latestStep;
	}

	public int getDistance() {
		return distance;
	}
	
	public Integer getID() {
		return this.id;
	}
	
	public void tick() {
		travel();
	}

	private void setDistance() {
		distance = Math.abs((startPos.getX()-endPos.getX())+(startPos.getY()-endPos.getY()));
	}
	
	/**
	 * decreases the distance left by 1
	 */
	public void travel() {
		distanceLeft--;
	}

	public int getDistanceLeft() {
		return distanceLeft;
	}

	private void setDistanceLeft(int distanceLeft) {
		this.distanceLeft = distanceLeft;
	}

	public String toString() {
		return this.id.toString();
	}
}

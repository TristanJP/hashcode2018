package trip;

import Types.Coordinate;

public class Ride {
	
	private Coordinate startPos, endPos;
	private int earliestStep, latestStep, distance;
	
	public Ride(Coordinate startPosition, Coordinate endPosition, int earliestStep, int latestStep) {
		setStartPos(startPosition);
		setEndPos(endPosition);
		setEarliestStep(earliestStep);
		setLatestStep(latestStep);
		setDistance();
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

	private void setDistance() {
		distance = Math.abs((startPos.getX()-endPos.getX())+(startPos.getY()-endPos.getY()));
	}

}

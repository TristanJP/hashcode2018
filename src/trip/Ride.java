package trip;

import Types.Coordinate;

public class Ride {
	
	private Coordinate startPos, endPos;
	private int earliestStep;
	
	public Ride(Coordinate startPosition, Coordinate endPosition, int earliestStep) {
		setStartPos(startPosition);
		setEndPos(endPosition);
		setEarliestStep(earliestStep);
	}
	
	public Coordinate getStartPos() {
		return startPos;
	}
	
	public void setStartPos(Coordinate startPos) {
		this.startPos = startPos;
	}
	
	public Coordinate getEndPos() {
		return endPos;
	}
	
	public void setEndPos(Coordinate endPos) {
		this.endPos = endPos;
	}

	public int getEarliestStep() {
		return earliestStep;
	}

	public void setEarliestStep(int earliestStep) {
		this.earliestStep = earliestStep;
	}

}

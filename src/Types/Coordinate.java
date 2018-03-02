package Types;

public class Coordinate {
	
	private int xPos, yPos;
	
	public Coordinate(int xPos, int yPos) {
		setX(xPos);
		setY(yPos);
	}
	
	public void move(int x, int y) {
		setX(getX() + x);
		setY(getY() + y);
	}

	public int getX() {
		return xPos;
	}

	public void setX(int xPos) {
		this.xPos = xPos;
	}

	public int getY() {
		return yPos;
	}

	public void setY(int yPos) {
		this.yPos = yPos;
	}

	public String toString() {
		return "(" + getX() + ", " + getY() + ")";
	}
	
	public int getDistanceBetween(Coordinate end) {
		return Math.abs((xPos-end.getX())+(yPos-end.getY()));
	}
}

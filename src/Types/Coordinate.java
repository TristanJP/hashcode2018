package Types;

public class Coordinate {
	
	private int xPos, yPos;
	
	public Coordinate(int xPos, int yPos) {
		setX(xPos);
		setY(yPos);
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

	
}

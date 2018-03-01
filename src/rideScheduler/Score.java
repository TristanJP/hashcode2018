package rideScheduler;

public class Score {

	private static Score instance = null;
	
	private Integer score;
	
	private Score() {
		this.score = 0;
	}
	
	public void increaseBy(Integer increase) {
		this.score = this.score + increase;
	}
	
	public static Score getInstance() {
		if (instance == null) {
			instance = new Score();
		}
		return instance;
	}
}

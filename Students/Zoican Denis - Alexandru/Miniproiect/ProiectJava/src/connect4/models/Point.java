package connect4.models;

/**
 * Class used for the BotController to store the best move
 * @author Denis Zoican
 */
public class Point {
	private int x;
	private int y;
	
	public Point(int x,int y) {
		this.setX(x);
		this.setY(y);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}

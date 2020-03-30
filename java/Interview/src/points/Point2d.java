package points;

public class Point2d extends Point{

	protected int y;

	public void move(int dx , int dy) {
		x += dx;
		y += dy;
	}

}

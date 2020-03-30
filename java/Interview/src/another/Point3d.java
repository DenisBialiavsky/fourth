package another;

import points.Point2d;

public class Point3d extends Point2d{

	int z;
	public void move(int dx , int dy, int dz) {
		x += dx;
		y += dy;
		z += dz;
	}

}

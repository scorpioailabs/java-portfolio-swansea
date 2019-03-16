public class Point3d {
	private double x, y, z;
	public Point3d(double x0, double y0, double z0) {
		x = x0;
		y = y0;
		z = z0;
	}
	public boolean equals(Point3d other) {
		return x == other.x && y == other.y && z == other.z;
	} 
}
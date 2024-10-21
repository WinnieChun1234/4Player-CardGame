
/**
 * The RegularPolygon class is a subclass of the Shape class, and is used to
 * model regular n-sided polygons. Besides the properties it inherited from the
 * Shape class, the RegularPolygon class also declares a number of private
 * instance variables for storing the number of sides and the radius of a
 * polygon. It has public getters and setters for accessing its private instance
 * variables. It also has public methods for setting the local coordinates of
 * the vertices of a polygon and for checking if a point (in the screen
 * coordinate system) is contained by a polygon.
 * 
 * @author Winnie Chun
 *
 */
public class RegularPolygon extends Shape {
	/**
	 * the number of sides of the regular n-sided polygon.
	 */
	private int numOfSides;
	/**
	 * the radius of the regular n-sided polygon.
	 */
	private double radius;

	/**
	 * A constructor for building a regular n-sided polygon with a radius of r.
	 * (Note that if the argument n is less than 3, the number of sides will be set
	 * to 3; if the argument r is less than 0, the radius will be set to 0).
	 * 
	 * @param n The number of side of the polygon
	 * @param r The radius of the polygon
	 */
	public RegularPolygon(int n, double r) {
		this.setNumOfSides(n);
		this.setRadius(r);
	}

	/**
	 * A constructor for building a regular n-sided polygon with a radius of 1.0.
	 * (Note that if the argument n is less than 3, the number of sides will be set
	 * to 3).
	 * 
	 * @param n The number of side of the polygon
	 */
	public RegularPolygon(int n) {
		this(n, 1);
	}

	/**
	 * A constructor for building a regular 3-sided polygon with a radius of 1.0.
	 */
	public RegularPolygon() {
		this(3, 1);
	}

	/**
	 * Returns the number of sides of the regular polygon.
	 * 
	 * @return the numOfSides
	 */
	public int getNumOfSides() {
		return numOfSides;
	}

	/**
	 * Returns the radius of the regular polygon.
	 * 
	 * @return the radius
	 */
	public double getRadius() {
		return radius;
	}

	/**
	 * Sets the number of sides of the regular n-sided polygon. This method will
	 * reset the local coordinates of the vertices
	 * 
	 * (Note that if the argument n is less than 3, the number of sides will be set
	 * to 3).
	 * 
	 * @param n the number of sides to set
	 */
	public void setNumOfSides(int n) {
		this.numOfSides = n < 3 ? 3 : n;
		this.setVertices();
	}

	/**
	 * Sets the radius of the regular n-sided polygon. This method will reset the
	 * local coordinates of the vertices . (Note that if the argument r is less than
	 * 0, the radius will be set to 0).
	 * 
	 * @param r the radius to set
	 */
	public void setRadius(double r) {
		this.radius = r < 0 ? 0 : r;
		this.setVertices();
	}

	/**
	 * Sets the local coordinates of the vertices based on the number of sides and
	 * radius. The vertices will be set in counter-clockwise manner. If the number
	 * of sides is an odd number, the first vertex should lie on the positive x-axis
	 * and its distance from the origin is given by the radius of the regular
	 * n-sided polygon. If the number of sides is an even number, the first vertex
	 * should lie in the first quadrant (i.e., both its x and y coordinates being
	 * positive) and make an angle of p/n, where n is the number of sides, with the
	 * positive x-axis. Its distance from the origin is again given by the radius of
	 * the regular n-sided polygon.
	 * 
	 */
	public void setVertices() {
		double[] x = new double[this.getNumOfSides()];
		double[] y = new double[this.getNumOfSides()];
		double alpha = this.getNumOfSides() % 2 == 0 ? Math.PI / this.getNumOfSides() : 0;
		double theta = Math.PI * 2 / this.getNumOfSides();
		for (int i = 0; i < this.getNumOfSides(); i++) {
			x[i] = this.getRadius() * Math.cos(alpha - i * theta);
			y[i] = this.getRadius() * Math.sin(alpha - i * theta);
		}
		this.setXLocal(x);
		this.setYLocal(y);
	}

	/**
	 * determining if a point (x, y) in the screen coordinate system is contained by
	 * the regular n-sided polygon. A point is considered to be contained by a
	 * polygon if it lies either completely inside the polygon, or on any of the
	 * sides or vertices of the polygon
	 * 
	 * @param x the x-coordinate of the screen coordinate system
	 * @param y the y-coordinate of the screen coordinate system
	 * @return true if the point is contained in the polygon, or false otherwise
	 */
	public boolean contains(double x, double y) {
		int n = this.getNumOfSides();
		double delta = 2 * Math.PI / n;
		double left = this.getXLocal()[0];

		for (int i = 0; i < n; i++) {
			if (this.getXLocal()[i] < left) {
				left = this.getXLocal()[i];
			}
		}
		for (int i = 0; i < n; i++) {
			double xl = (x - this.getXc()) * Math.cos(-this.getTheta() + i * delta)
					- (y - this.getYc()) * Math.sin(-this.getTheta() + i * delta);
			if (xl < left) {
				return false;
			}
		}
		return true;
	}

}

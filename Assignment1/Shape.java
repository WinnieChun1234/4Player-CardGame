import java.awt.Color;

/**
 * The Shape class is used to model the generate shapes. This includes some
 * instance variables for storing color, fill-type, orientation, screen
 * coordinates of the center, and local coordinates of the vertices of the
 * shape. This also includes methods for getting the screen coordinates of the
 * vertices of a shape.
 * 
 * @author Winnie Chun
 */
public class Shape {
	/**
	 * Specify the color of the shape
	 */
	public Color color;
	/**
	 * Specify whether the shape is filled with color
	 */
	public boolean filled;
	/**
	 * Specify the orientation (in Radians) of the shape in the screen coordinate
	 */
	public double theta;
	/**
	 * Specify the x-coordinate of the center of the shape in the screen
	 */
	public double xc;
	/**
	 * Specify the y-coordinate of the center of the shape in the screen
	 */
	public double yc;
	/**
	 * Specify the x-coordinates of the vertices (in anti-clockwise) of the shape in
	 * its local coordinate system
	 */
	public double[] xLocal = new double[0];
	/**
	 * Specify the y-coordinates of the vertices (in anti-clockwise order) of the
	 * shape in its local coordinate system
	 */
	public double[] yLocal = new double[0];

	public Shape() {

	}

	/**
	 * Setting the local coordinates of the vertices of the shape
	 * 
	 * @param d parameter for setting vertices
	 */
	public void setVertices(double d) {

	}

	/**
	 * Translating the center of the shape by dx and dy respectively, along x- and
	 * y-directions of the screen coordinate system.
	 * 
	 * @param dx value to be added to the xc (the x-coordinate of the center of the
	 *           shape)
	 * @param dy value to be added to the yc (the y-coordinate of the center of the
	 *           shape)
	 */
	public void translate(double dx, double dy) {
		this.xc += dx;
		this.yc += dy;
	}

	/**
	 * Rotating the shape about its center by an angle (ie. dt)
	 * 
	 * @param dt the angle for rotation
	 */
	public void rotate(double dt) {
		this.theta += dt;
	}

	/**
	 * Retrieving the x-coordinates of the vertices (in anti-clockwise order) of the
	 * shape in the screen coordinate system, rounded to the nearest integers.
	 * 
	 * @return the array of x-coordinates of the vertices (in anti-clockwise order)
	 *         of the shape in the screen coordinate system, rounded to the nearest
	 *         integers.
	 */
	public int[] getX() {
		int[] xScreen = new int[this.xLocal.length];
		for (int i = 0; i < this.xLocal.length; i++) {
			xScreen[i] = (int) Math
					.round(this.xLocal[i] * Math.cos(theta) - this.yLocal[i] * Math.sin(theta) + this.xc);
		}
		return xScreen;
	}

	/**
	 * Retrieving the y-coordinates of the vertices (in anti-clockwise order) of the
	 * shape in the screen coordinate system, rounded to the nearest integers.
	 * 
	 * @return the array of y-coordinates of the vertices (in anti-clockwise order)
	 *         of the shape in the screen coordinate system, rounded to the nearest
	 *         integers.
	 */
	public int[] getY() {
		int[] yScreen = new int[this.yLocal.length];
		for (int i = 0; i < this.yLocal.length; i++) {
			yScreen[i] = (int) Math
					.round(this.xLocal[i] * Math.sin(theta) + this.yLocal[i] * Math.cos(theta) + this.yc);
		}
		return yScreen;
	}
}

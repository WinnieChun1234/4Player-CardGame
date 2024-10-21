import java.awt.Color;

/**
 * The Shape class is used to model general shapes. It has private instance
 * variables for storing color, fill-type, orientation, screen coordinates of
 * the center, and the local coordinates of the vertices of a shape. It has
 * public getters and setters for accessing its private instance variables. It
 * also has public methods for translating and rotating a shape, and for getting
 * the screen coordinates of the vertices of a shape.
 * 
 * @author Winnie Chun
 *
 */
public class Shape {
//---------------------------------------------------------------------------------//
	/**
	 * a Color object specifying the color of the shape.
	 */
	private Color color;

	/**
	 * a boolean value specifying whether the shape is filled or not filled.
	 */
	private boolean filled;

	/**
	 * a double value specifying the orientation (in radians) of the shape in the
	 * screen coordinate system.
	 */
	private double theta;

	/**
	 * a double value specifying the x-coordinate of the center of the shape in the
	 * screen coordinate system.
	 */
	private double xc;

	/**
	 * a double value specifying the y-coordinate of the center of the shape in the
	 * screen coordinate system.
	 */
	private double yc;

	/**
	 * an array of double values specifying the x-coordinates of the vertices (in
	 * counter clock-wise order) of the shape in its local coordinate system.
	 */
	private double[] xLocal = { 0 };

	/**
	 * an array of double values specifying the y-coordinates of the vertices (in
	 * counter clock-wise order) of the shape in its local coordinate system.
	 */
	private double[] yLocal = { 0 };

//---------------------------------------------------------------------------------//
	/**
	 * a method for retrieving the color of the shape.
	 * 
	 * @return the color of the shape
	 */

	public Color getColor() {
		return this.color;
	}

	/**
	 * a method for retrieving the fill-type of the shape.
	 * 
	 * @return the fill-type of the shape.
	 */
	public boolean getFilled() {
		return this.filled;
	}

	/**
	 * a method for retrieving the orientation (in radians) of the shape in the
	 * screen coordinate system.
	 * 
	 * @return the orientation (in radians) of the shape in the screen coordinate
	 *         system.
	 */
	public double getTheta() {
		return this.theta;
	}

	/**
	 * a method for retrieving the x-coordinate of the center of the shape in the
	 * screen coordinate system.
	 * 
	 * @return the x-coordinate of the center of the shape in the screen coordinate
	 *         system.
	 */
	public double getXc() {
		return this.xc;
	}

	/**
	 * a method for retrieving the y-coordinate of the center of the shape in the
	 * screen coordinate system.
	 * 
	 * @return the y-coordinate of the center of the shape in the screen coordinate
	 *         system.
	 */
	public double getYc() {
		return this.yc;
	}

	/**
	 * a method for retrieving the x-coordinates of the vertices (in counter
	 * clock-wise order) of the shape in its local coordinate system.
	 * 
	 * @return the x-coordinates of the vertices (in counter clock-wise order) of
	 *         the shape in its local coordinate system.
	 */
	public double[] getXLocal() {
		return this.xLocal;
	}

	/**
	 * a method for retrieving the y-coordinates of the vertices (in counter
	 * clock-wise order) of the shape in its local coordinate system.
	 * 
	 * @return the y-coordinates of the vertices (in counter clock-wise order) of
	 *         the shape in its local coordinate system.
	 */
	public double[] getYLocal() {
		return this.yLocal;
	}

	/**
	 * a method for setting the color of the shape.
	 * 
	 * @param color the color of the shape.
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * a method for setting the fill-type of the shape.
	 * 
	 * @param filled the fill-type of the shape.
	 */
	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	/**
	 * a method for setting the orientation of the shape.
	 * 
	 * @param theta the orientation of the shape.
	 */
	public void setTheta(double theta) {
		this.theta = theta;
	}

	/**
	 * a method for setting the x-coordinate of the center of the shape in the
	 * screen coordinate system.
	 * 
	 * @param xc the x-coordinate of the center of the shape in the screen
	 *           coordinate system.
	 */
	public void setXc(double xc) {
		this.xc = xc;
	}

	/**
	 * a method for setting the y-coordinate of the center of the shape in the
	 * screen coordinate system.
	 * 
	 * @param yc the y-coordinate of the center of the shape in the screen
	 *           coordinate system.
	 */
	public void setYc(double yc) {
		this.yc = yc;
	}

	/**
	 * a method for setting the x-coordinates of the vertices (in counter clock-wise
	 * order) of the shape in its local coordinate system.
	 * 
	 * @param xLocal the x-coordinates of the vertices (in counter clock-wise order)
	 *               of the shape in its local coordinate system.
	 */
	public void setXLocal(double[] xLocal) {
		this.xLocal = xLocal;
	}

	/**
	 * a method for setting the y-coordinates of the vertices (in counter clock-wise
	 * order) of the shape in its local coordinate system.
	 * 
	 * @param yLocal the y-coordinates of the vertices (in counter clock-wise order)
	 *               of the shape in its local coordinate system.
	 */
	public void setYLocal(double[] yLocal) {
		this.yLocal = yLocal;
	}

//---------------------------------------------------------------------------------//
	/**
	 * a method for translating the center of the shape by dx and dy, respectively,
	 * along the x and y directions of the screen coordinate system.
	 * 
	 * @param dx the translation of the center of the shape along the x direction of
	 *           the screen coordinate system.
	 * @param dy the translation of the center of the shape along the y direction of
	 *           the screen coordinate system.
	 */
	// (i.e., dx and dy should be added to xc and yc respectively.)
	public void translate(double dx, double dy) {
		this.xc += dx;
		this.yc += dy;
	}

	/**
	 * a method for rotating the shape about its center by an angle of dt (in
	 * radians)
	 * 
	 * @param dt the angle rotated about the its center in radians
	 */
	// (i.e., dt should be added to theta.)
	public void rotate(double dt) {
		this.theta += dt;
	}

	/**
	 * a method for retrieving the x-coordinates of the vertices (in counter
	 * clock-wise order) of the shape in the screen coordinate system.
	 * 
	 * @return the x-coordinates of the vertices (in counter clock-wise order) of
	 *         the shape in the screen coordinate system.
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
	 * a method for retrieving the y-coordinates of the vertices (in counter
	 * clock-wise order) of the shape in the screen coordinate system.
	 * 
	 * @return the y-coordinates of the vertices (in counter clock-wise order) of
	 *         the shape in the screen coordinate system.
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

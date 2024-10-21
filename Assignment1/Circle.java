
/**
 * The Circle class is used to model circles. Like the Square class and the
 * Triangle class, it is a subclass of the Shape class and it inherits all the
 * instance variables and methods of the Shape class
 * 
 * @author Winnie Chun
 *
 */
public class Circle extends Shape {

	/**
	 * A method for setting the local coordinates of the upper left and lower right
	 * vertices of an axis-aligned bounding box of a standard circle.
	 * 
	 * @param d specifies the radius of the circle.
	 */
	@Override
	public void setVertices(double d) {
		this.xLocal = new double[] { -d, d };
		this.yLocal = new double[] { -d, d };
	}

	/**
	 * A method for retrieving the x-coordinates of the upper left and lower right
	 * vertices of an axis-aligned bounding box of the circle in the screen
	 * coordinate system (rounded to nearest integers).
	 */
	@Override
	public int[] getX() {
		int[] xScreen = new int[] { (int) Math.round(this.xLocal[0] + this.xc),
				(int) Math.round(this.xLocal[1] + this.xc) };
		return xScreen;
	}

	/**
	 * A method for retrieving the y-coordinates of the upper left and lower right
	 * vertices of an axis-aligned bounding box of the circle in the screen
	 * coordinate system (rounded to nearest integers).
	 */
	@Override
	public int[] getY() {
		int[] yScreen = new int[] { (int) Math.round(this.yLocal[0] + this.yc),
				(int) Math.round(this.yLocal[1] + this.yc) };
		return yScreen;
	}
}

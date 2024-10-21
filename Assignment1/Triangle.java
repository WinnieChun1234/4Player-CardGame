
/**
 * The Triangle class is used to model triangles. Like the Square class, it is a
 * subclass of the Shape class and it inherits all the instance variables and
 * methods of the Shape class. The Triangle class overrides the setVertices()
 * method for setting the local coordinates of the 3 vertices of a standard
 * triangle. Below is a detailed description for the Triangle class.
 * 
 * @author Winnie Chun
 *
 */
public class Triangle extends Shape {

	/**
	 * A method for setting the local coordinates of the 3 vertices of a standard
	 * triangle
	 * 
	 * @param d specifies the distance from the center of the triangle to any of its
	 *          vertices
	 */
	@Override
	public void setVertices(double d) {
		this.xLocal = new double[] { d, -d * (Math.cos(Math.PI / 3)), -d * (Math.cos(Math.PI / 3)) };
		this.yLocal = new double[] { 0, -d * (Math.sin(Math.PI / 3)), d * (Math.sin(Math.PI / 3)) };
	}

}

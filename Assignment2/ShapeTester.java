import java.awt.Color;
import java.util.Arrays;

/**
 * This is a tester to verify the correctness of my implementation of
 * {@link Shape}
 * 
 * @author Winnie Chun
 *
 */
public class ShapeTester {

	/**
	 * To test the implementation of {@link Shape}
	 * 
	 * @param args Command line arguments are not used
	 */
	public static void main(String[] args) {

		System.out.println("Testing Shape:");
		testShape(new Shape());
		System.out.println("================================================================================");
		System.out.println("Testing RegularPolygon as a Shape:");
		testShape(new RegularPolygon());

	}

	/**
	 * Testing a shape.
	 * 
	 * @param s The shape to be tested
	 */
	public static void testShape(Shape s) {
		s.setColor(new Color(250, 0, 0));
		s.setFilled(true);
		s.setTheta(0);
		s.setXc(0);
		s.setYc(0);
		s.setXLocal(new double[] { 0, 1, 2, 3 });
		s.setYLocal(new double[] { 0, 1, 2, 3 });
		s.translate(100, 100);
		System.out.println("Original:");
		printShapeParams(s);

		System.out.println();
		System.out.println("Rotate it by 45deg:");
		s.rotate(Math.PI / 4);
		printShapeParams(s);

		System.out.println();
		System.out.println("Translate (100.1111, 200.2222):");
		s.translate(100.1111, 200.2222);
		printShapeParams(s);

	}

	/**
	 * Print out the parameter and screen coordinates of a shape.
	 * 
	 * @param s The shape that its information to be printed
	 */
	public static void printShapeParams(Shape s) {
		System.out.println("\tcolor  = " + s.getColor());
		System.out.println("\tfilled = " + s.getFilled());
		System.out.println("\ttheta  = " + s.getTheta());
		System.out.println("\txc     = " + s.getXc());
		System.out.println("\tyc     = " + s.getYc());
		System.out.println("\txLocal = " + Arrays.toString(s.getXLocal()));
		System.out.println("\tyLocal = " + Arrays.toString(s.getYLocal()));
		System.out.println("\tgetX() = " + Arrays.toString(s.getX()));
		System.out.println("\tgetY() = " + Arrays.toString(s.getY()));

	}
}

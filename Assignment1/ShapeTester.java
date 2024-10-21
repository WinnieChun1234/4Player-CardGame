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

	}

	/**
	 * Testing a shape.
	 * 
	 * @param s The shape to be tested
	 */
	public static void testShape(Shape s) {
		s.color = new Color(250, 0, 0);
		s.filled = true;
		s.theta = 0;
		s.xc = 0;
		s.yc = 0;
		s.xLocal = new double[] { 7, 11 };
		s.yLocal = new double[] { 6, 9 };
		s.translate(100, 100);
		s.setVertices(50);
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

		System.out.println();
		System.out.println("Set Vertics (123.45):");
		s.setVertices(123.45);
		printShapeParams(s);
	}

	/**
	 * Print out the parameter and screen coordinates of a shape.
	 * 
	 * @param s The shape that its information to be printed
	 */
	public static void printShapeParams(Shape s) {
		System.out.println("\tcolor  = " + s.color);
		System.out.println("\tfilled = " + s.filled);
		System.out.println("\ttheta  = " + s.theta);
		System.out.println("\txc     = " + s.xc);
		System.out.println("\tyc     = " + s.yc);
		System.out.println("\txLocal = " + Arrays.toString(s.xLocal));
		System.out.println("\tyLocal = " + Arrays.toString(s.yLocal));
		System.out.println("\tgetX() = " + Arrays.toString(s.getX()));
		System.out.println("\tgetY() = " + Arrays.toString(s.getY()));

	}
}
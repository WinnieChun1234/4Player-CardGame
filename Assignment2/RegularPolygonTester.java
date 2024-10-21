import java.util.Arrays;
import java.awt.Color;

/**
 * This is a tester to verify the correctness of my implementation of
 * {@link RegularPolygon}
 * 
 * @author Winnie Chun
 *
 */
public class RegularPolygonTester {

	/**
	 * To test the implementation of {@link RegularPolygon}
	 * 
	 * @param args Command line arguments are not used
	 */
	public static void main(String[] args) {

		System.out.println("Testing new RegularPolygon:");
		printPolygonParams(new RegularPolygon());
		System.out.println();
		System.out.println("Testing new RegularPolygon(5):");
		printPolygonParams(new RegularPolygon(5));
		System.out.println();
		System.out.println("Testing new RegularPolygon(1): (invalid n)");
		printPolygonParams(new RegularPolygon(1));
		System.out.println();
		System.out.println("Testing new RegularPolygon(6,7):");
		printPolygonParams(new RegularPolygon(6, 7));
		System.out.println();
		System.out.println("Testing new RegularPolygon(1,-9): (invalid n, r)");
		printPolygonParams(new RegularPolygon(1, -9));
		System.out.println();
		System.out.println("Testing new RegularPolygon(4,-9): (invalid r)");
		printPolygonParams(new RegularPolygon(4, -9));
		System.out.println();
		System.out.println("Testing new RegularPolygon(1, 7): (invalid n)");
		printPolygonParams(new RegularPolygon(1, 7));
		System.out.println("================================");

		System.out.println("p = new Polygon(3,10)");
		RegularPolygon p = new RegularPolygon(3, 10);
		printPolygonParams(p);
		System.out.println();
		System.out.println("p.setColor(RED):");
		p.setColor(Color.RED);
		printPolygonParams(p);
		System.out.println();
		System.out.println("p.setFilled(true)");
		p.setFilled(true);
		printPolygonParams(p);
		System.out.println();
		System.out.println("p.setNumOfSides(2): (invalid n)");
		p.setNumOfSides(2);
		printPolygonParams(p);
		System.out.println();
		System.out.println("p.setNumOfSides(4): (vertices should be updated)");
		p.setNumOfSides(4);
		printPolygonParams(p);
		System.out.println();
		System.out.println("p.setRadius(-6): (invalid r)");
		p.setRadius(-6);
		printPolygonParams(p);
		System.out.println();
		System.out.println("p.setRadius(5) (vertices should be updated)");
		p.setRadius(5);
		printPolygonParams(p);
		System.out.println();

		System.out.println("p.contains(0,0): " + p.contains(0, 0));
		System.out.println("p.contains(2,3): " + p.contains(2, 3));
		System.out.println("p.contains(4,4): " + p.contains(4, 4));
		System.out.println("p.contains(5,5): " + p.contains(5, 5));

		System.out.println("================================");

		System.out.println("Testing some Shape Method:");
		System.out.println();
		System.out.println("Rotate it by 45deg:");
		p.rotate(Math.PI / 4);
		printPolygonParams(p);
		System.out.println();

		System.out.println("Translate (100.1111, 200.2222):");
		p.translate(100.1111, 200.2222);
		printPolygonParams(p);

	}

	/**
	 * Print out the parameter and screen coordinates of a Regular Polygon
	 * 
	 * @param s The RegularPolygon that its information to be printed
	 */
	public static void printPolygonParams(RegularPolygon s) {
		System.out.println("\tnumOfSides  = " + s.getNumOfSides());
		System.out.println("\tradius      = " + s.getRadius());
		System.out.println("\tcolor       = " + s.getColor());
		System.out.println("\tfilled      = " + s.getFilled());
		System.out.println("\ttheta       = " + s.getTheta());
		System.out.println("\txc          = " + s.getXc());
		System.out.println("\tyc          = " + s.getYc());

		System.out.print("\txLocal      = [");
		for (int i = 0; i < s.getXLocal().length; i++) {
			if (i != 0)
				System.out.print(", ");
			System.out.printf("%1.3f", s.getXLocal()[i]);
		}
		System.out.println("]");

		System.out.print("\tyLocal      = [");
		for (int i = 0; i < s.getYLocal().length; i++) {
			if (i != 0)
				System.out.print(", ");
			System.out.printf("%1.3f", s.getYLocal()[i]);
		}
		System.out.println("]");

		System.out.println("\tgetX()      = " + Arrays.toString(s.getX()));
		System.out.println("\tgetY()      = " + Arrays.toString(s.getY()));

	}
}

package JavaLearnings;

import edu.duke.Shape;
import edu.duke.Point;
import edu.duke.FileResource;

public class PerimeterAssignmentRunner {

	public double getPerimeter(Shape s) {
		double currDist = 0;
		double totalPrim = 0;
		Point prevPoint = s.getLastPoint();

		for (Point currPoint : s.getPoints()) {

			currDist = currPoint.distance(prevPoint);
			totalPrim = totalPrim + currDist;
			prevPoint = currPoint;
		}
		return totalPrim;
	}

	public void testPerimeter() {
		FileResource fr = new FileResource();
		Shape s = new Shape(fr);
		double length = getPerimeter(s);
		System.out.println("perimeter = " + length);
	}

	public static void main(String[] args) {
		PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
		pr.testPerimeter();
	}

}

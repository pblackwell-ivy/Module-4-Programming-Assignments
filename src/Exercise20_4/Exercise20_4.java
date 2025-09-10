package Exercise20_4;

import java.awt.geom.Point2D;
import java.util.*;

public class Exercise20_4 {
    public static void main(String[] args) {
        // Create an array of 100 x, y points
        Point2D.Double[] points = new Point2D.Double[100];

        // Fill array with random x and y values (range 0 to 100)
        Random random = new Random();
        for (int i = 0; i < points.length; i++) {
            double x = random.nextDouble() * 100;
            double y = random.nextDouble() * 100;
            points[i] = new Point2D.Double(x, y);
        }

        // Sort by y-coordinates, then by x-coordinates
        Arrays.sort(points, new Point2DComparator());

        // Display the first five points
        System.out.println("The first five points, sorted by y, then by x:");
        for (int i = 0; i < 5; i++) {
            Point2D.Double p = points[i];
            System.out.printf("(%.2f, %.2f)%n", p.getX(), p.getY());
        }
    }
}

class Point2DComparator implements Comparator<Point2D.Double> {
    // declare a new class that implements the Comparator interface, specialized for
    // objects of type Point2D.Double

    @Override
    // take two objects p1 and p2 and return an int that indicates their order
    public int compare(Point2D.Double p1, Point2D.Double p2) {
        // compare y first
        // if y's are the same, compare x
        // if both are equal, return 0

        // If p1.y < p2.y, return -1 to signal p1 comes before p2
        if (p1.getY() < p2.getY()) return -1;

        // if p1.y > p2.y, return 1 to signal that p1 should come after p2
        else if (p1.getY() > p2.getY()) return 1;

        // if p1.y == p2.y, compare by x-coordinate
        // if p1.x < p2.x, p1 comes before p2
        else if (p1.getX() < p2.getX()) return -1;

        // if p1.x > p2.x, p2 comes before p1
        else if (p1.getX() > p2.getX()) return 1;

        // if both x and y are equal, return 0
        else return 0;
    }
}
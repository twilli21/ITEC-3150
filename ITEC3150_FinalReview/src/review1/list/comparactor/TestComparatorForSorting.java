package review1.list.comparactor;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TestComparatorForSorting {
	public static void main(String[] args) {
		GeometricObjectComparator comparator = new GeometricObjectComparator();
		GeometricObject g1 = new Rectangle(5, 5); //area 25
		GeometricObject g2 = new Circle(5); // area > 75
		GeometricObject g = max(g1, g2, comparator);
		System.out.println("The area of the larger object is " + 
				g.getArea());


		ArrayList<GeometricObject> list = new ArrayList<>();
		list.add(g1);
		list.add(g2);
		list.add(new Circle(1));
		list.add(new Circle(2));
		list.add(new Rectangle(1, 1));
		list.add(new Rectangle(2, 2));

		Collections.sort(list, comparator);
		System.out.println("\nSorted using comparactor based on areas=====");
		for (GeometricObject x: list) {
			if (x instanceof Circle) 
				System.out.println((Circle)x);
			else
				System.out.println((Rectangle)x);
		}
		
		
		Collections.sort(list, comparator.reversed());
		System.out.println("\nSorted using REVERSE comparactor based on areas=====");
		for (GeometricObject x: list) {
			if (x instanceof Circle) 
				System.out.println((Circle)x);
			else
				System.out.println((Rectangle)x);
		}

	}

	public static GeometricObject max(GeometricObject g1, 
			GeometricObject g2, Comparator<GeometricObject> c) {
		if (c.compare(g1, g2) > 0)
			return g1;
		else
			return g2;
	}
}
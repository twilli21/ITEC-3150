package review3.hashAndTreeSetMap;

import java.util.*;

import review2.list.comparactor.Circle;
import review2.list.comparactor.GeometricObject;
import review2.list.comparactor.GeometricObjectComparator;
import review2.list.comparactor.Rectangle;

public class TestTreeSetWithComparator
{
	public static void main(String[] args)
	{
		// Create a tree set for geometric objects using a comparator

		Set<GeometricObject> set = new TreeSet<>(new GeometricObjectComparator());
		set.add(new Rectangle(4, 5));
		set.add(new Circle(40));
		set.add(new Circle(40));
		set.add(new Rectangle(4, 1));

		// Display geometric objects in the tree set
		System.out.println("A sorted set of geometric objects: ====");
		for (GeometricObject element : set)
		{
			System.out.println("area = " + element.getArea());
		}

		Set<GeometricObject> set2 = new TreeSet<>((new GeometricObjectComparator()).reversed());
		set2.add(new Rectangle(4, 5));
		set2.add(new Circle(40));
		set2.add(new Circle(40));
		set2.add(new Rectangle(4, 1));

		// Display geometric objects in the tree set
		System.out.println("\nA REVERSELY sorted set of geometric objects:====");
		for (GeometricObject element : set2)
		{
			System.out.println("area = " + element.getArea());
		}
	}
}

package InClass1_Sort;

import java.util.ArrayList;
import java.util.Collections;

public class Shape
{
	public static void main(String[] args)
	{
		ArrayList<GeometricObject> shapes = new ArrayList<>();
		shapes.add(new Rectangle(5, 5));
		shapes.add(new Rectangle(10, 5));
		shapes.add(new Rectangle(2, 4));
		shapes.add(new Circle(5));
		shapes.add(new Circle(8));

		System.out.println("Before sorting: ");
		for (GeometricObject g : shapes)
		{
			System.out.println(g);
		}
		System.out.println();
		
		Collections.sort(shapes, new ObjectComparator());
		System.out.println("Increasing order: ");
		for (GeometricObject g : shapes)
		{
			System.out.println(g);
		}
		System.out.println();
		
		Collections.sort(shapes, new ObjectComparator().reversed());
		System.out.println("Decreasing order: ");
		for (int i = 0; i < shapes.size(); i++)
		{
			System.out.println(shapes.get(i));
		}
	}
}

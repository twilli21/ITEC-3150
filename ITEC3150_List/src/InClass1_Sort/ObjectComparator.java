package InClass1_Sort;

import java.util.Comparator;

public class ObjectComparator implements Comparator<GeometricObject>, java.io.Serializable
{
	public int compare(GeometricObject o1, GeometricObject o2)
	{
		double perimeter1 = o1.getPerimeter();
		double perimeter2 = o2.getPerimeter();

		if (perimeter1 < perimeter2)
	    {
	    	return -1;
	    }
	    else if (perimeter1 == perimeter2)
	    {
	    	return 0;
	    }
	    else
	    {
	    	return 1;
	    }
	}
}
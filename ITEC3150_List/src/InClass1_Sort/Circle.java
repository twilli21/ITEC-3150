package InClass1_Sort;

public class Circle extends GeometricObject
{
	private double radius;

	public Circle()
	{
		
	}

	public Circle(double radius)
	{
		this.radius = radius;
	}

	/** Return radius */
	public double getRadius()
	{
		return radius;
	}

	/** Set a new radius */
	public void setRadius(double radius)
	{
		this.radius = radius;
	}

	@Override /** Return area */
	public double getArea()
	{
		return radius * radius * Math.PI;
	}

	/** Return diameter */
	public double getDiameter()
	{
		return 2 * radius;
	}

	@Override /** Return perimeter */
	public double getPerimeter()
	{
		return 2 * radius * Math.PI;
	}

	/* Print the circle info */
	@Override
	public String toString()
	{
		return String.format("Circle [radius-%.2f: area-%.2f, perimeter-%.2f", radius, getArea(), getPerimeter());
	}
}

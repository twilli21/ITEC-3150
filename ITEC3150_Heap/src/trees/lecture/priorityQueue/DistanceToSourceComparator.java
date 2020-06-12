package trees.lecture.priorityQueue;

import java.util.Comparator;

public class DistanceToSourceComparator implements Comparator<Point> {
	Point source;
	
	public DistanceToSourceComparator(Point source) {
		this.source = source;
	}
	
	private static double distance(Point p1, Point p2) {
		return (p1.getX() - p2.getX()) * (p1.getX() - p2.getX()) + 
				(p1.getY() - p2.getY()) * (p1.getY() - p2.getY());
	}

	@Override
	public int compare(Point o1, Point o2) {
		if (distance(o1, source) < distance(o2, source)) return -1;
		if (distance(o1, source) > distance(o2, source)) return 1;
		return 0;
	}

}

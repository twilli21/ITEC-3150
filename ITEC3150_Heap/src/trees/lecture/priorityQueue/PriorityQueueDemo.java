package trees.lecture.priorityQueue;

import java.util.*;

public class PriorityQueueDemo {
	public static void main(String[] args) {
		PriorityQueue<String> queue1 = new PriorityQueue<>();
		queue1.offer("Oklahoma");
		queue1.offer("Indiana");
		queue1.offer("Georgia");
		queue1.offer("Texas");

		System.out.println("Priority queue using Comparable:");
		while (queue1.size() > 0) {
			System.out.print(queue1.remove() + " ");
		}
		System.out.println();

		PriorityQueue<String> queue2 = new PriorityQueue<>(
				4, Collections.reverseOrder());
		queue2.offer("Oklahoma");
		queue2.offer("Indiana");
		queue2.offer("Georgia");
		queue2.offer("Texas");

		System.out.println("\nPriority queue using Comparator:");
		while (queue2.size() > 0) {
			System.out.print(queue2.remove() + " ");
		}
		System.out.println();


		PriorityQueue<WorkOrder> queue3 = new PriorityQueue<>();
		queue3.offer(new WorkOrder(3, "Clean"));
		queue3.offer(new WorkOrder(2, "Build new structures"));
		queue3.offer(new WorkOrder(1, "Repair"));
		queue3.offer(new WorkOrder(4, "Preserve Energy"));


		System.out.println("\nWorkOrder Priority queue using Comparable:");
		while (queue3.size() > 0) {
			System.out.print(queue3.remove() + " ");
		}
		System.out.println();
	}
}

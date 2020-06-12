package Homework4;

public class MyQueue<E> {
	private java.util.LinkedList<E> list = new java.util.LinkedList<E>();

	//TODO1: Implement the method: Add e at the queue tail
	public void enqueue(E e) {
		//Add e at the end of the list
		list.add(e);
	}

	//TODO2: Implement the method: remove and return the element at queue head
	public E dequeue() {
		//Remove the first element from list and return the element
		return list.remove();
	}

	//TODO3: Implement the method: return the size of the queue
	public int getSize() {
		//Return the size of the list
		return list.size();   
	}

	@Override
	public String toString() {
		return "Queue: " + list.toString();
	}
}

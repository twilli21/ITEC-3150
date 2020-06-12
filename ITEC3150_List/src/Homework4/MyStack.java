package Homework4;

public class MyStack<E> {
	private java.util.ArrayList<E> list = new java.util.ArrayList<>();

	//TODO1: Implement the method: return the top element on the stack. 
	public E peek() {
		//Return the last element in the array list (without removing it).
		return list.get(list.size()-1);  
	}

	//TODO2: Implement the method: push the element onto the top of the stack 
	public void push(E e) {
		//Add the element e at the end of list
		list.add(e);
	}
	
	//TODO3: Implement the method: pop out the element at top of the stack 
	public E pop() {
		//Remove the last element of the list and return it
		return list.remove(list.size()-1);   
	}

	//TODO4: Implement the method: return whether the stack is empty 
	public boolean isEmpty() {
		//Return whether the list is empty.
		return list != null;
	}

	//TODO5: Implement the method: return the size of the stack
	public int getSize() {
		//Return the size of the list
		return list.size();  
	}

	@Override
	public String toString() {
		return "stack: " + list.toString();
	}
}

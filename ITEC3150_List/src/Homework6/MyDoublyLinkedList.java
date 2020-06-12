package Homework6;

public class MyDoublyLinkedList<E> extends MyAbstractList<E>
{
	private Node<E> head, tail;

	/** Create a default list */
	public MyDoublyLinkedList()
	{
	}

	/** Create a list from an array of objects */
	public MyDoublyLinkedList(E[] objects)
	{
		super(objects);
	}

	/** Return the head element in the list */
	public E getFirst()
	{
		if (size == 0)
		{
			return null;
		} else
		{
			return head.element;
		}
	}

	/** Return the last element in the list */
	public E getLast()
	{
		if (size == 0)
		{
			return null;
		} else
		{
			return tail.element;
		}
	}

	/** Add an element to the beginning of the list */
	public void addFirst(E e)
	{
		Node<E> newNode = new Node<E>(e); // Create a new node

		if (head == null)
			head = tail = newNode; // The new node is the only node in list
		else
		{
			// TODO 1: Make the newNode the head and update all necessary links:
			// a) The newNode's next field should point to (i.e. be assigned to) the
			// original head.
			// b) The original head's prev field should point to newNode.
			// c) Update the head to point to the newNode.
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}

		size++; // Increase list size
	}

	/** Add an element to the end of the list */
	public void addLast(E e)
	{
		Node<E> newNode = new Node<E>(e); // Create a new for element e

		if (tail == null)
		{
			head = tail = newNode; // The new node is the only node in list
		} else
		{
			// TODO 2: Make the newNode the tail and update all necessary links:
			// a) The original tail's next field should point to (i.e. be assigned to)
			// newNode.
			// b) The newNode's prev field should point to the original head.
			// c) Update the tail to point to the newNode.
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
			
		}

		size++; // Increase size
	}

	@Override /**
				 * Add a new element at the specified index in this list. The index of the head
				 * element is 0
				 */
	public void add(int index, E e)
	{
		if (index == 0)
		{
			addFirst(e);
		} else if (index >= size)
		{
			addLast(e);
		} else
		{
			// current will point to a node just before the indexed position.
			// the new node will be added after current
			Node<E> current = head;
			for (int i = 1; i < index; i++)
			{
				current = current.next;
			}
			Node<E> afterCurrent = current.next; // ADDED for Doubly

			Node<E> newNode = new Node<E>(e);

			// TODO 3: Add newNode between current and afterCurrent:
			// a) current' next field points to (i.e. is assigned to) newNode
			// b) newNode's prev field points to current
			// c) afterCurretn's prev field points to newNode
			// d) newNode's next field points to afterCurrent
			current.next = newNode;
			newNode.prev = current;
			afterCurrent.prev = newNode;
			newNode.next = afterCurrent;
			size++;
		}
	}

	/**
	 * Remove the head node and return the object that is contained in the removed
	 * node.
	 */
	public E removeFirst()
	{
		if (size == 0)
		{
			return null;
		} else if (size == 1)
		{
			Node<E> temp = head;
			head = tail = null;
			size = 0;
			return temp.element;
		} else
		{
			Node<E> temp = head;

			// TODO 4: Change head to its next node.
			// a) Move head to the next node.
			// b) Assign null to the head's prev field.
			// c) Reduce size by 1;
			head = head.next;
			head.prev = null;
			size--;
			return temp.element;
		}
	}

	/**
	 * Remove the last node and return the object that is contained in the removed
	 * node.
	 */
	public E removeLast()
	{
		if (size == 0)
		{
			return null;
		} else if (size == 1)
		{
			Node<E> temp = head;
			head = tail = null;
			size = 0;
			return temp.element;
		} else
		{
			Node<E> temp = tail;
			// TODO 5: Change tail to its prev node.
			// a) Move head to the prev node.
			// b) Assign null to the tail's next field.
			// c) Reduce size by 1;
			tail = tail.prev;
			tail.next = null;
			size--;
			return temp.element;
		}
	}

	@Override /**
				 * Remove the element at the specified position in this list. Return the element
				 * that was removed from the list.
				 */
	public E remove(int index)
	{
		if (index < 0 || index >= size)
		{
			return null;
		} else if (index == 0)
		{
			return removeFirst();
		} else if (index == size - 1)
		{
			return removeLast();
		} else
		{
			Node<E> previous = head;

			for (int i = 1; i < index; i++)
			{
				previous = previous.next;
			}

			Node<E> current = previous.next; // current is the node to remove

			// TODO 6: Remove the node at index (i.e. current)
			// a) previous's next points to the node following current (i.e. current's next,
			// let's call it temp)
			// b) temp's prev field should point to previous
			// c) size reduce by 1
			Node<E> temp = current.next;
			previous.next = temp;
			temp.prev = previous;
			size--;
			return current.element;
		}
	}

	@Override /** Override toString() to return elements in the list */
	public String toString()
	{
		StringBuilder result = new StringBuilder("[");

		Node<E> current = head;
		for (int i = 0; i < size; i++)
		{
			result.append(current.element);
			current = current.next;
			if (current != null)
			{
				result.append(", "); // Separate two elements with a comma
			} else
			{
				result.append("]"); // Insert the closing ] in the string
			}
		}

		return result.toString();
	}

	public String toStringReverse()
	{
		StringBuilder result = new StringBuilder("[");

		Node<E> current = tail;
		for (int i = 0; i < size; i++)
		{
			result.append(current.element);
			current = current.prev;
			if (current != null)
			{
				result.append(", "); // Separate two elements with a comma
			} else
			{
				result.append("]"); // Insert the closing ] in the string
			}
		}

		return result.toString();
	}

	@Override /** Clear the list */
	public void clear()
	{
		size = 0;
		head = tail = null;
	}

	@Override /** Return true if this list contains the element e */
	public boolean contains(E e)
	{
		Node<E> current = head;
		for (int i = 0; i < size; i++)
		{
			if (current.element.equals(e))
			{
				return true;
			}
		}
		return false;
	}

	@Override /** Return the element at the specified index */
	public E get(int index)
	{
		if (index < 0 || index >= size)
		{
			return null;
		} else
		{
			Node<E> current = head;

			for (int i = 1; i <= index; i++)
			{
				current = current.next;
			}
			return current.element;
		}
	}

	@Override /**
				 * Return the index of the head matching element in this list. Return -1 if no
				 * match.
				 */
	public int indexOf(E e)
	{
		Node<E> current = head;
		for (int i = 0; i < size; i++)
		{
			if (current.element.equals(e))
			{
				return i;
			}
		}
		return -1;
	}

	@Override /**
				 * Return the index of the last matching element in this list. Return -1 if no
				 * match.
				 */
	public int lastIndexOf(E e)
	{
		Node<E> current = tail;
		for (int i = size - 1; i >= 0; i--)
		{
			if (current.element.equals(e))
			{
				return i;
			}
		}
		return -1;
	}

	@Override /**
				 * Replace the element at the specified position in this list with the specified
				 * element.
				 */
	public E set(int index, E e)
	{
		if (index < 0 || index >= size)
		{
			return null;
		} else
		{
			Node<E> current = head;

			for (int i = 1; i <= index; i++)
			{
				current = current.next;
			}
			E temp = current.element;
			current.element = e;
			return temp;
		}
	}

	@Override /* Override iterator() defined in Iterable */
	public java.util.Iterator<E> iterator()
	{
		return new LinkedListIterator();
	}

	private void checkIndex(int index)
	{
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
	}

	private class LinkedListIterator implements java.util.Iterator<E>
	{
		private Node<E> current = head; // Current index

		@Override
		public boolean hasNext()
		{
			// TODO 7: replace the following statement:
			// return weather current is not null (i.e. not done traversing the list)

			return current != null;
		}

		@Override
		public E next()
		{
			// TODO 8: replace the following statement.
			// return the element at the current node and move current to the next node
			// a) Store the element at current node in a temp variable
			// b) Move current to its next node
			// c) Return the element stored in the temp variable
			Node<E> temp = current;
			current = current.next;
			return temp.element;
		}

		@Override
		public void remove()
		{
			// TODO 9: Remove the current node and move current to its next node.
			// a) Remember the current's previous node in a variable previous.
			// b) Move current to its next.
			// c) Set current's prev to previous.
			// d) Set previous'next tp current.
			// e) Reduce the size by 1.
			Node<E> previous = current.prev;
			current = current.next;
			current.prev = previous;
			previous.next = current;
			size--;
		}
	}

	private static class Node<E>
	{
		E element;
		Node<E> prev; // ADDED for Doubly
		Node<E> next;

		public Node(E element)
		{
			this.element = element;
		}
	}
}
import java.util.LinkedList;
import java.util.List;

public class SimpleBSTMap
{

	private SimpleBSTMapNode root;

	/**
	 * Constructs a new BST.
	 *
	 * This constructor initializes an empty BST.
	 *
	 */
	public SimpleBSTMap()
	{

	}

	/**
	 * Given a key, return the associated value (as an Integer object) for the key.
	 * 
	 * Traverse the tree to find the appropriate location. If the key is already in
	 * the tree, return the associated value. Otherwise return null.
	 * 
	 * @param key the key of the entry to add or update
	 */
	public Integer get(int key)
	{
		SimpleBSTMapNode node = getHelper(root, key);
		if (node == null)
			return null;
		else
			return node.getValue();
	}

	/**
	 * Recursive helper method for get()
	 * 
	 * Given the key, search for in the subtree rooted at a given node and return
	 * the node that contains the key. If the key is not in the subtree, return
	 * null.
	 * 
	 * @param node the root of the subtree to search for the key
	 * @param key  the key of the data to search
	 * @return the node that contains the key or null if no such a node exists.
	 **/
	private SimpleBSTMapNode getHelper(SimpleBSTMapNode node, int key)
	{
		// TODO 1: replace the following return statement with the actual implementation of this method
		//if node is null, return null
		//compare key with node.getKey().
		//If ==, find it
		//If <, search in the left tree rooted at node.getLeft()
		//Else, search in the right tree rooted at node.getRight()
		
		if (node == null)
		{
			return null;
		}
		else
		{
			if (node.getKey() == key)
			{
				return node;
			}
			else if (node.getKey() > key)
			{
				return getHelper(node.getLeft(), key);
			}
			else
			{
				return getHelper(node.getRight(), key);
			}
		}
	}

	/**
	 * Adds a new entry to the tree or updates the value of an existing key in the
	 * tree
	 * 
	 * Traverse the tree to find the appropriate location. If the key is already in
	 * the tree, then update its value to the new value. Otherwise create a new node
	 * consisting the new (key, value) pair and add it to the tree. The new node
	 * becomes a leaf. Then go back up the tree from the new leaf to the root. Upon
	 * seeing an imbalanced node, balance it with proper rotations.
	 * 
	 * @param key   the key of the entry to add or update
	 * @param value the value associated with the key
	 */
	public void put(int key, int value)
	{
		root = putHelper(root, key, value);
	}

	/**
	 * Recursive helper method for put()
	 * 
	 * Add the given (key, value) pair to the subtree rooted at a given node if the
	 * key was not in the subtree, or update its associated value to the new value.
	 * When a new node is added to the tree, upon seeing an imbalanced node on the
	 * path up the tree from the new leaf, balance it with proper rotations.
	 * 
	 * @param node  the root of the subtree to add the new data to or update the
	 *              value in
	 * @param key   the key of the data to add or update
	 * @param value the new value associated with key
	 * @return the new root of the subtree after the data is added or updated
	 */
	private SimpleBSTMapNode putHelper(SimpleBSTMapNode node, int key, int value)
	{
		if (node == null)
		{
			return new SimpleBSTMapNode(key, value);
		}

		else if (key == node.getKey())
		{
			node.setValue(value);
			return node;
		}
		else if (key < node.getKey())
		{
			SimpleBSTMapNode leftRoot = putHelper(node.getLeft(), key, value);
			node.setLeft(leftRoot);
		}
		else
		{
			// TODO 2: Complete this branch
			SimpleBSTMapNode rightRoot = putHelper(node.getRight(), key, value);
			node.setRight(rightRoot);
		}

		SimpleBSTMapNode newRoot = balance(node);
		return newRoot;
	}

	/**
	 * Returns the height of a node in the tree
	 * 
	 * @param node the node to return the height for
	 * @return the height of node if it's valid, -1 if it's null
	 */
	private int height(SimpleBSTMapNode node)
	{
		if (node == null)
		{
			return -1;
		} else
		{
			return node.getHeight();
		}
	}

	/**
	 * Updates the height and balance factor of a node
	 * 
	 * @param node the node to update the height and balance factor for
	 */
	private void update(SimpleBSTMapNode node)
	{
		int leftHeight = height(node.getLeft());
		int rightHeight = height(node.getRight());
		node.setHeight(1 + Math.max(leftHeight, rightHeight));
		node.setBalanceFactor(leftHeight - rightHeight);
	}

	/**
	 * Performs a right rotation on a node
	 * 
	 * @param node the node to rotate
	 * @return the left child which is the new root of the subtree after rotation
	 */
	private SimpleBSTMapNode rotateRight(SimpleBSTMapNode node)
	{
		SimpleBSTMapNode left = node.getLeft();
		node.setLeft(left.getRight());
		left.setRight(node);
		update(node);
		update(left);
		return left;
	}

	/**
	 * Performs a left rotation on a node
	 * 
	 * @param node the node to rotate
	 * @return the right child which is the new root of the subtree after rotation
	 */
	private SimpleBSTMapNode rotateLeft(SimpleBSTMapNode node)
	{
		// TODO 3: Replace the following return statement with the actual implementation
		// of the method.
		SimpleBSTMapNode right = node.getRight();
		node.setRight(right.getLeft());
		right.setLeft(node);
		update(node);
		update(right);
		return right;
	}

	/**
	 * Balances an imbalanced node by left and right rotations
	 * 
	 * @param node the node to balance
	 * @return the new root of the subtree after balance
	 */
	private SimpleBSTMapNode balance(SimpleBSTMapNode node)
	{
		update(node);
		if (Math.abs(node.getBalanceFactor()) <= 1)
		{
			return node;
		}

		if (node.getBalanceFactor() > 1)
		{
			if (node.getLeft().getBalanceFactor() >= 0)
			{
				return rotateRight(node);
			} else
			{
				node.setLeft(rotateLeft(node.getLeft()));
				return rotateRight(node);
			}
		} else
		{
			if (node.getRight().getBalanceFactor() <= 0)
			{
				return rotateLeft(node);
			} else
			{
				node.setRight(rotateRight(node.getRight()));
				return rotateLeft(node);
			}
		}
	}

	/**
	 * Traverses the tree by an in-order traversal Sorts data by key
	 * 
	 * @return a list consisting of all keys in the tree in the ascending order
	 */
	public List<Integer> inOrder()
	{
		LinkedList<Integer> order = new LinkedList<>();
		inOrderHelper(root, order);
		return order;
	}

	/**
	 * Recursive helper method for inOrder()
	 * 
	 * @param node  the node to recurse on
	 * @param order the list that will eventually contain all keys in the tree in
	 *              the ascending order
	 */
	private void inOrderHelper(SimpleBSTMapNode node, LinkedList<Integer> order)
	{
		if (node == null)
		{
			return;
		}

		inOrderHelper(node.getLeft(), order);
		order.add(node.getKey());
		inOrderHelper(node.getRight(), order);
	}

	/**
	 * Returns the root of the tree
	 * 
	 * @return root
	 */
	public SimpleBSTMapNode getRoot()
	{
		return root;
	}
}

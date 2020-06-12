package Homework7;

import java.util.LinkedList;

/**
 * Your implementation of the BST class
 *
 * @author Taylor Williams
 *
 * Collaborators: LIST ALL COLLABORATORS YOU WORKED WITH HERE
 *
 * Resources: LIST ALL NON-COURSE RESOURCES YOU CONSULTED HERE
 */

import java.util.List;

public class BSTMap<K extends Comparable<? super K>, V> {
	private BSTMapNode<K, V> root;
	
	/**
     * This constructor initializes an empty BST.
     *
     * There is no need to do anything for the constructor.
     */
    public BSTMap() {
        // DO NOT IMPLEMENT THIS CONSTRUCTOR!
    }
    
    /**
     * Returns the value associated with a given key.
     * 
     * Traverse the tree to find the appropriate location. If the key is
     * in the tree, then return its value. Otherwise return null.
     * 
     * Time Complexity: O(log n)
     * 
     * @param key  the key to search for
     * @return     the value associated with key if key is in the tree, null otherwise
     * @throws     java.lang.IllegalArgumentException if key is null
     */
	public V get(K key)
	{
		if (key == null)
		{
			throw new IllegalArgumentException();
		}
		else
		{
			BSTMapNode<K, V> node = getHelper(root, key);
			if (node == null)
			{	
				return null;
			}
			else
			{
				return node.getValue();
			}
		}
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
	private BSTMapNode<K, V> getHelper(BSTMapNode<K, V> node, K key)
	{		
		if (node == null)
		{
			return null;
		}
		else
		{
			int compare = node.getKey().compareTo(key);
			if (compare == 0)
			{
				return node;
			}
			else if (compare > 0)
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
     * Adds a new entry to the tree or updates the value of an existing key in the tree
     * 
     * Traverse the tree to find the appropriate location. If the key is
     * already in the tree, then update its value to the new value. Otherwise
     * create a new node consisting the new (key, value) pair and add it to the tree.
     * The new node becomes a leaf. Then go back up the tree from the new leaf to the root. 
     * Upon seeing an imbalanced node on the path, balance it with proper rotations. 
     * Update the height, balance factor and the new size instance variable of every affected node.
     * 
     * This method is essentially the same as its counterpart in SimpleBST. Therefore
     * you can use the code for put(), its helper method putHelper() and the helper's helpers - 
     * balance(), rotateLeft(), rotateRight(), update() and height(), from the SimpleBST class.
     * The only new items you need to incorporate are the following:
     * 		1. Modify the code properly to handle the generic types K and V for the key and value.
     * 		2. Provide the code for rotateLeft() which mirrors rotateRight(). You can get 
     * 		   lots of help from Slide 33 for the BST lectures when completing this method.
     * 		3. In update(), update the size instance variable of a BST node in addition to 
     *         height and balance factor. You need to think of the relation between the size of a node 
     *         and the sizes of its left and right children, and how to define the size of a null node.
     *      4. Handle the exceptions properly.
     * 
     * Time Complexity: O(log n)
     * 
     * @param key    the key of the entry to add or update
     * @param value  the value associated with key
     * @throws       java.lang.IllegalArgumentException if key or value is null
     */
	public void put(K key, V value)
	{
		if (key == null || value == null)
		{
			throw new IllegalArgumentException();
		}
		else
		{
			root = putHelper(root, key, value);
		}
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
	private BSTMapNode<K, V> putHelper(BSTMapNode<K, V> node, K key, V value)
	{
		if (node == null)
		{
			return new BSTMapNode<K, V>(key, value);
		}

		else if (key == node.getKey())
		{
			node.setValue(value);
			return node;
		}
		else
		{
			int compare = node.getKey().compareTo(key);
			if (compare == 0)
			{
				return node;
			}
			else if (compare > 0)
			{
				BSTMapNode<K, V> leftRoot = putHelper(node.getLeft(), key, value);
				node.setLeft(leftRoot);
			}
			else
			{
				BSTMapNode<K, V> rightRoot = putHelper(node.getRight(), key, value);
				node.setRight(rightRoot);
			}
		}
		BSTMapNode<K, V> newRoot = balance(node);
		return newRoot;
	}

	/**
	 * Returns the height of a node in the tree
	 * 
	 * @param node the node to return the height for
	 * @return the height of node if it's valid, -1 if it's null
	 */
	private int height(BSTMapNode<K, V> node)
	{
		if (node == null)
		{
			return -1;
		}
		else
		{
			return node.getHeight();
		}
	}

	/**
	 * Updates the size, height, and balance factor of a node
	 * 
	 * @param node the node to update the size, the height, and balance factor for
	 */
	private void update(BSTMapNode<K, V> node)
	{
		int leftHeight = height(node.getLeft());
		int rightHeight = height(node.getRight());
		node.setHeight(1 + Math.max(leftHeight, rightHeight));
		node.setBalanceFactor(leftHeight - rightHeight);
		node.setSize(size(node));
	}
	
	private int size(BSTMapNode<K, V> node) {
		if (node == null)
	    {
	    	return 0;
	    }
	    int left = size(node.getLeft());
	    int right = size(node.getRight());
	    return left + right + 1;
	}

	/**
	 * Performs a right rotation on a node
	 * 
	 * @param node the node to rotate
	 * @return the left child which is the new root of the subtree after rotation
	 */
	private BSTMapNode<K, V> rotateRight(BSTMapNode<K, V> node)
	{
		BSTMapNode<K, V> left = node.getLeft();
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
	private BSTMapNode<K, V> rotateLeft(BSTMapNode<K, V> node)
	{
		BSTMapNode<K, V> right = node.getRight();
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
	private BSTMapNode<K, V> balance(BSTMapNode<K, V> node)
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
     * Traverses the tree by an in-order traversal
     * Sorts data by key
     * 
     * Time Complexity: O(n)
     * 
     * @return  a list consisting of all keys in the tree in the ascending order
     */
	public List<K> inOrder()
	{
		LinkedList<K> order = new LinkedList<>();
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
	private void inOrderHelper(BSTMapNode<K, V> node, LinkedList<K> order)
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
     * Finds and returns all keys in the tree in descending order
     * 
     * Time Complexity: O(n)
     * 
     * Note: You would NOT receive credit if you perform an in-order traversal of the tree and 
     * then reverse the returned list, as this is unnecessary. Instead your method should 
     * directly obtain the list of all keys in descending order. 
     * 
     * Hint: Modify in-order traversal by changing the order in which the nodes are visited.
     * 
     * @return  the list of all keys in the tree in descending order
     */
	public List<K> reverseOrder()
	{
		LinkedList<K> order = new LinkedList<>();
		reverseOrderHelper(root, order);
		return order;
	}
    
	/**
	 * Recursive helper method for reverseOrder()
	 * 
	 * @param node  the node to recurse on
	 * @param order the list that will eventually contain all keys in the tree in
	 *              the descending order
	 */
    private void reverseOrderHelper(BSTMapNode<K, V> node, LinkedList<K> order)
	{
		if (node == null)
		{
			return;
		}
		reverseOrderHelper(node.getRight(), order);
		order.add(node.getKey());
		reverseOrderHelper(node.getLeft(), order);
	}
    
    /**
     * Finds and returns the k smallest keys in ascending order
     * 
     * Ex:
     * For the following BST
     * 
     *                50
     *              /    \
     *            25      75
     *           /  \     / \
     *          12   37  70  80
     *         /  \    \      \
     *        10  15    40    85
     *           /
     *          13
     *          
     * kSmallest(0) should return the list []
     * kSmallest(5) should return the list [10, 12, 13, 15, 25]
     * kSmallest(3) should return the list [10, 12, 13]
     * kSmallest(20) should cause java.lang.IllegalArgumentException to be thrown
     * 
     * Time Complexity: O(log n + k)
     * 
     * Note: The required time complexity does NOT allow you to perform an in-order traversal
     * on the entire tree and then return the k smallest keys. Instead you should only traverse the 
     * branches of the tree necessary to get the data you need.
     * 
     * @param k  the number of smallest keys to find
     * @return   the list of k smallest keys in ascending order
     * @throws   java.lang.IllegalArgumentException if k < 0 or k > the size of the tree
     */
	public List<K> kSmallest(int k)
	{
		if (k < 0 || k > root.getSize())
		{
			throw new IllegalArgumentException();
		}
		else
		{
			LinkedList<K> smallest = new LinkedList<>();
			kSmallestHelper(root, smallest, k);
			return smallest;
		}
	} 
    
    private void kSmallestHelper(BSTMapNode<K, V> node, LinkedList<K> smallest, int k)
	{
		if (k == 0 || node == null)
		{
			return;
		}
		else
		{
			kSmallestHelper(node.getLeft(), smallest, k);
			if (smallest.size() < k)
			{
				smallest.add(node.getKey());
			}
			if (smallest.size() == k)
			{
				return;
			}
			kSmallestHelper(node.getRight(), smallest, k);
		}
	}
    
    /**
     * Returns the root of the tree.
     *
     * For grading purposes only. 
     *
     * @return the root of the tree
     */
    public BSTMapNode<K, V> getRoot() {
        // DO NOT MODIFY THIS METHOD!
        return root;
    }

}

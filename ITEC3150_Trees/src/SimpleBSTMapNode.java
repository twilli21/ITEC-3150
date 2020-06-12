/**
 * Node class used for implementing the SimpleBST class.
 */
public class SimpleBSTMapNode
{

	private int key;
	private int value;
	private SimpleBSTMapNode left;
	private SimpleBSTMapNode right;
	private int height;
	private int balanceFactor;

	/**
	 * Constructs a SimpleBSTNode with the given key and value.
	 *
	 * @param key   the key stored in the new node
	 * @param value the value associated with the key
	 */
	SimpleBSTMapNode(int key, int value)
	{
		this.key = key;
		this.value = value;
	}

	/**
	 * Gets the key.
	 *
	 * @return the key
	 */
	int getKey()
	{
		return key;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	int getValue()
	{
		return value;
	}

	/**
	 * Gets the left child.
	 *
	 * @return the left child
	 */
	SimpleBSTMapNode getLeft()
	{
		return left;
	}

	/**
	 * Gets the right child.
	 *
	 * @return the right child
	 */
	SimpleBSTMapNode getRight()
	{
		return right;
	}

	/**
	 * Sets the value.
	 *
	 * @param value the new value
	 */
	void setValue(int value)
	{
		this.value = value;
	}

	/**
	 * Sets the left child.
	 *
	 * @param left the new left child
	 */
	void setLeft(SimpleBSTMapNode left)
	{
		this.left = left;
	}

	/**
	 * Sets the right child.
	 *
	 * @param right the new right child
	 */
	void setRight(SimpleBSTMapNode right)
	{
		this.right = right;
	}

	/**
	 * Gets the height.
	 *
	 * @return the height
	 */
	public int getHeight()
	{
		return height;
	}

	/**
	 * Gets the balance factor.
	 *
	 * @return the balance factor
	 */
	public int getBalanceFactor()
	{
		return balanceFactor;
	}

	/**
	 * Sets the height.
	 *
	 * @param height the new height
	 */
	public void setHeight(int height)
	{
		this.height = height;
	}

	/**
	 * Sets the balance factor.
	 *
	 * @param balanceFactor the new balance factor
	 */
	public void setBalanceFactor(int balanceFactor)
	{
		this.balanceFactor = balanceFactor;
	}

	@Override
	public String toString()
	{
		String str = String.format("Node containing: (%d, %d)", key, value);
		return str;
	}
}

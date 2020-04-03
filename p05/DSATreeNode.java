
/**
 *
 * @author Caio Marteli
 */

private class DSATreeNode 
{	

    private int key;
    private Object value;
	private DSATree leftChild;
	private DSATree rightChild;


	/**
     *  Constructor: sets key and value only
     */
	public DSAListNode(int inKey, Object inValue)
	{
		if(inKey == null)
		{
			throw new IllegalArgumentException("Key cannot be null");
		}
		key = inKey;
		value = inValue;
		leftChild = null;
		rightChild = null;		
	}


	//Accessors

	public int getKey()
	{
		return key;
	}

	public Object getValue()
	{
		return value;
	}

	public DSATree getLeftChild()
	{
		return leftChild;
	}

	public DSATree getRightChild()
	{
		return rightChild;
	}

	//Mutators

	public void setLeft(DSATree newLeft)
	{
		leftChild = newLeft;
	}

	public void setRight(DSATree newRight)
	{
		rightChild = newRight;
	}

}


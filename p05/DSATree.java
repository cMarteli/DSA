import java.util.*;
/**
 *
 * @author Caio Marteli
 */
public class DSATree {

	
	private class DSATreeNode {	

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

		public DSATree getLeft()
		{
			return leftChild;
		}

		public DSATree getRight()
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

	}//end of DSATreeNode class

	
	private DSATreeNode root;
	
	public DSATree() 
	{
	root = null; // Start with an empty tree    
	} 
	
	//wrapper methods, will call private recursive implementations	
	public Object find(String key) 
	{ 
		return findRec(key, root);
	}

	private Object findRec(String key, DSATreeNode currNode) 
	{ 
		Object value = null;
		
		if(currNode == null) // Base case: not found
		{
			throw new NoSuchElementException("Key " + key + " not found");
		}
		else if (key.equals(currNode.getKey())) // Base case: found
		{
			value = currNode.getValue();
		}
		else if (key.compareTo(currNode.getKey()) < 0) // Go left (recursive)
		{
			value = findRec(key, currNode.getLeft());
		}
		else // Go right (recursive)
		{
			value = findRec(key, currNode.getRight());
		}

		return value;
	} 

	public Object insert(String key, Object value) 
	{ 
		//wrapper
		return insertRec(key, value, root);
	}

	private void insertRec(String key, Object value, DSATreeNode currNode)
	{
		DSATreeNode updateNode = currNode;
		if(currNode == null)
		{
			//DSATreeNode newNode = new DSATreeNode(key, value);
			//updateNode = newNode;
			updateNode = new DSATreeNode(key, value);
		}
		else if(key.equals(currNode.getKey()))
		{
			throw new Exception("Data already exists in the tree.");
		}
		else if(key.compareTo(currNode.getKey) < 0)
		{
			currNode.setLeft(insertRec(key, data, currNode.getLeft())); //recurse left
		}
		else()
		{
			currNode.setRight(insertRec(key, data, currNode.getRight())); //recurse right
		}

		return updateNode;
	} 

	public void delete(String key) 
	{ 
	//...
		System.out.print("STUB METHOD");
	}

	public void display() 
	{ 
	//...
		System.out.print("STUB METHOD");
	}

	public int height() 
	{
	//...
		System.out.print("STUB METHOD");
		return 0;
	} 

}



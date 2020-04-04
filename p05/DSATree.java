import java.util.*;
/**
 *
 * @author Caio Marteli
 */
public class DSATree {

	
	private class DSATreeNode 
	{	

	    private String key;
	    private Object value;
		private DSATreeNode leftChild;
		private DSATreeNode rightChild;


		/**
	     *  Constructor: sets key and value only
	     */

		public DSATreeNode(String inKey, Object inValue)
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

		public String getKey()
		{
			return key;
		}

		public Object getValue()
		{
			return value;
		}

		public DSATreeNode getLeft()
		{
			return leftChild;
		}

		public DSATreeNode getRight()
		{
			return rightChild;
		}

		//Mutators

		public void setLeft(DSATreeNode newLeft)
		{
			leftChild = newLeft;
		}

		public void setRight(DSATreeNode newRight)
		{
			rightChild = newRight;
		}

	}//end of DSATreeNode class

	
	private DSATreeNode root;
	
	public DSATree() 
	{
		root = null; // Start with an empty tree    
	} 
	
	//wrapper method, will call private recursive implementations	
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

	public void insert(String key, Object value) 
	{ 
		//wrapper
		insertRec(key, value, root);
	}

	private DSATreeNode insertRec(String key, Object value, DSATreeNode currNode)
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
			throw new IllegalArgumentException("Data already exists in the tree.");
		}
		else if(key.compareTo(currNode.getKey()) < 0)
		{
			currNode.setLeft(insertRec(key, value, currNode.getLeft())); //recurse left
		}
		else
		{
			currNode.setRight(insertRec(key, value, currNode.getRight())); //recurse right
		}

		return updateNode;
	} 

	private DSATreeNode deleteRec(String key, DSATreeNode currNode)
	{
		DSATreeNode updateNode = currNode;
		if(currNode == null)
		{
			throw new IllegalArgumentException("Data does not exist in tree."); //not in the tree
		}
		else if(key.equals(currNode.getKey()))
		{
			updateNode = deleteNode(key, currNode); //base case - found
		}
		else if(key.compareTo(currNode.getKey()) < 0)
		{
			currNode.setLeft(deleteRec(key, currNode.getLeft())); //recurse left
		}
		else
		{
			currNode.setRight(deleteRec(key, currNode.getRight())); //recurse right
		}

		return updateNode;
	}

	public DSATreeNode deleteNode(String key, DSATreeNode delNode) 
	{
		DSATreeNode updateNode = null;

		if(delNode.getLeft() == null && delNode.getRight() == null)
		{
			updateNode = null; //no children

		}
		else if(delNode.getLeft() != null && delNode.getRight() == null)
		{
			updateNode = delNode.getLeft(); //one child left
		}
		else if(delNode.getLeft() == null && delNode.getRight() != null)
		{
			updateNode = delNode.getRight(); //one child right
		}
		else
		{
			updateNode = promoteSuccessor(delNode.getRight()); //two children
			if(updateNode != delNode.getRight()) //no cycles
			{
				updateNode.setRight(delNode.getRight()); //update right
			}
			updateNode.setLeft(delNode.getLeft()); //and left
		}

		return updateNode;
	}

	public DSATreeNode promoteSuccessor(DSATreeNode currNode)
	{
		DSATreeNode successor = currNode;

		if(currNode.getLeft() != null)
		{
			successor = promoteSuccessor(currNode.getLeft());
			if(successor == currNode.getLeft()) //parent of successor
			{
				currNode.setLeft(successor.getRight()); //needs to adopt right child
			}
		}
		return successor;
	}

	public void display() 
	{ 
	//...
		System.out.print("STUB METHOD");
	}

	public int height() //wrapper
	{		
		return heightRec(root);
	}

	private int heightRec(DSATreeNode currNode)
	{
		int htSoFar, iLeftHt, iRightHt;

		if(currNode == null)
		{
			htSoFar = -1; // Base case – no more along this branch
		}
		else  
		{
			iLeftHt = heightRec(currNode.getLeft()); // Calc left height from here
			iRightHt = heightRec(currNode.getRight()); // Calc right height from here

			// Get highest of left vs right branches
			if(iLeftHt > iRightHt)
			{
				htSoFar = iLeftHt + 1;
			}
			else 
			{
				htSoFar = iRightHt + 1;
			}			
		}
		
		return htSoFar;

	}

}



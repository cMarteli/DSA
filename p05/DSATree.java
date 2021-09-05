import java.io.Serializable;
import java.io.*;
/**
 *
 * @author Caio Marteli
 */
public class DSATree implements Serializable{
	
	private DSATreeNode root;
	/************************************************************
    Default Constructor:
    IMPORT: none
    EXPORT: address of new DSALinkedList object
    ASSERTION: root = null is the default states
    ************************************************************/
	public DSATree()
	{
		root = null; //Start with an empty tree    
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
		if(root == null)
		{
			updateNode = new DSATreeNode(key, value);
			root = updateNode; //could be wrong?

		}
		else if(updateNode == null)
		{
			updateNode = new DSATreeNode(key, value);
		}
		else if(key.equals(updateNode.getKey()))
		{
			throw new IllegalArgumentException("Data already exists in the tree.");
		}
		else if(key.compareTo(updateNode.getKey()) < 0)
		{ 
			updateNode.setLeft(insertRec(key, value, updateNode.getLeft())); //recurse left
		}
		else
		{
			updateNode.setRight(insertRec(key, value, updateNode.getRight())); //recurse right
		}
		//System.out.println(updateNode.getValue());//DEBUG
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

	public void printInOrder(DSATreeNode currNode) 
	{ 
	//...
		DSATreeNode printNode = currNode;
		if (printNode.getLeft() != null)
		{
			printInOrder(printNode.getLeft());
		}
		System.out.println(printNode.getValue());
		if(printNode.getRight() != null)
		{
			printInOrder(printNode.getRight());
		}
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

	public DSATreeNode getRoot()
	{
		return root;
	}

	public void printRoot()
		{
			if(root != null)
			{
				System.out.println(root.getValue());
			}
			else
			{
				System.out.println("Root is empty");
			}
		}

	/************************************************************
    DSATreeNode Class
    Private inner Cass
    ************************************************************/
	private class DSATreeNode 
	{	

	    private String key;
	    private Object value;
		private DSATreeNode leftChild;
		private DSATreeNode rightChild;


	    /************************************************************
	    Default Constructor:
	    IMPORT: none
	    EXPORT: address of new DSATreeNode object
	    ASSERTION: sets key and value only
	    ************************************************************/ 
		public DSATreeNode(String inKey, Object inValue)
		{
			if(inKey == null)
			{
				throw new IllegalArgumentException("Key cannot be null");
			}
			else
			{
				key = inKey;
				value = inValue;
				leftChild = null;
				rightChild = null;
			}

		}

		/************************************************************
		*** ACCESSORS ***
	    ************************************************************/

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

		/************************************************************
		*** MUTATORS ***
	    ************************************************************/

		public void setLeft(DSATreeNode newLeft)
		{
			leftChild = newLeft;
		}

		public void setRight(DSATreeNode newRight)
		{
			rightChild = newRight;
		}

	}//End of DSATreeNode class	

}



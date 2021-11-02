import java.io.Serializable;
import java.util.NoSuchElementException;
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
    ASSERTION: root = null is the default state
    ************************************************************/
	public DSATree()
	{
		root = null; //Start with an empty tree
	}

	/************************************************************
    IMPORT: key(String)
    EXPORT: Object
    ASSERTION: wrapper method, will call private recursive implementations
    ************************************************************/
	public Object find(String key)
	{
		return findRec(key, root);
	}

	/************************************************************
    IMPORT: key(String), currNode(DSATreeNode)
    EXPORT: Object
    ASSERTION: find by key method, returns value in node associated to given key
    ************************************************************/
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

	/************************************************************
    IMPORT: key(String), value(Object)
    EXPORT: none
    ASSERTION: wrapper method, inserts value in node associated to given key
    ************************************************************/
	public void insert(String key, Object value)
	{
		root = insertRec(key, value, root);
	}

	/************************************************************
    IMPORT: key(String), value(Object), currNode(DSATreeNode)
    EXPORT: DSATreeNode
    ASSERTION: inserts value in node associated to given key
    ************************************************************/
	private DSATreeNode insertRec(String inKey, Object value, DSATreeNode currNode)
	{
		DSATreeNode updateNode = currNode;

		if(currNode == null) //base case empty node found
		{
			updateNode = new DSATreeNode(inKey, value); //insertion point
		}
		else if(inKey.equals(currNode.getKey())) //collision data already the tree
		{
			throw new IllegalArgumentException("Data already exists in the tree.");
		}
		else if((inKey.compareTo(currNode.getKey())) < 0)
		{
			currNode.setLeft(insertRec(inKey, value, currNode.getLeft())); //recurse left
		}
		else
		{
			currNode.setRight(insertRec(inKey, value, currNode.getRight())); //recurse right
		}
		return updateNode;
	}

	/************************************************************
    IMPORT: key(String), root(DSATreeNode)
    EXPORT: none
    ASSERTION: wrapper method, deletes value in node associated to given key
    ************************************************************/
	public void delete(String key, DSATreeNode delNode)
	{
		deleteRec(key, delNode);
	}

	/************************************************************
    IMPORT: key(String), cuurNode(DSATreeNode)
    EXPORT: DSATreeNode
    ASSERTION: wrapper method, deletes value in node associated to given key
    ************************************************************/
	private DSATreeNode deleteRec(String key, DSATreeNode currNode)
	{
		DSATreeNode updateNode = currNode;
		if(currNode == null)
		{
			throw new IllegalArgumentException("Data does not exist in tree."); //not in the tree
		}
		else if(key.equals(currNode.getKey()))
		{
			updateNode = deleteNode(currNode); //base case - found
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

	/************************************************************
    IMPORT: key(String), delNode(DSATreeNode)
    EXPORT: DSATreeNode
    ASSERTION: Helper method to delete; deletes value in node associated to given key
    ************************************************************/
	private DSATreeNode deleteNode(DSATreeNode delNode)
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

	/************************************************************
    IMPORT: nont
    EXPORT: none
    ASSERTION: Wrapper method; uses root for traversal
    ************************************************************/
	public void inOrderTraverseTree()
	{
		inOrderRec(root);
	}

	/************************************************************
    IMPORT: currNode(DSATreeNode)
    EXPORT: none
    ASSERTION: in-order traversal of tree - Recursive
    ************************************************************/
	private void inOrderRec(DSATreeNode currNode)
	{
		if(currNode != null)
		{
			inOrderRec(currNode.getLeft());
			//do infix stuff
			System.out.println(currNode.toString());
			inOrderRec(currNode.getRight());
		}
	}

	/************************************************************
    IMPORT: none
    EXPORT: none
    ASSERTION: Wrapper method; uses root for traversal
    ************************************************************/
	public void postOrderTraverseTree()
	{
		postOrderRec(root);
	}

	/************************************************************
    IMPORT: currNode(DSATreeNode)
    EXPORT: none
    ASSERTION: post-order traversal of tree - Recursive
    ************************************************************/
	private void postOrderRec(DSATreeNode currNode)
	{
		if(currNode != null)
		{
			postOrderRec(currNode.getLeft());
			postOrderRec(currNode.getRight());
			//do postfix stuff
			System.out.println(currNode.toString());
		}
	}

	/************************************************************
    IMPORT: none
    EXPORT: none
    ASSERTION: Wrapper method; uses root for traversal
    ************************************************************/
	public void preorderTraverseTree()
	{
		preorderTraverseRec(root);
	}

	/************************************************************
    IMPORT: currNode(DSATreeNode)
    EXPORT: none
    ASSERTION: pre-order traversal of tree - Recursive
    ************************************************************/
	private void preorderTraverseRec(DSATreeNode currNode)
	{
		if(currNode != null)
		{
			//do prefix stuff
			System.out.println(currNode.toString());
			preorderTraverseRec(currNode.getLeft());
			preorderTraverseRec(currNode.getRight());
		}
	}


	/************************************************************
    IMPORT: none
    EXPORT: none
    ASSERTION: TODO: STUB method; balances tree
    ************************************************************/
	public void balance()
	{
		int lh = height(root.leftChild);
		int rh = height(root.rightChild);
		balanceRec(lh,rh);
	}
	/************************************************************
    IMPORT: none
    EXPORT: none
    ASSERTION: TODO: STUB method; balances tree
    ************************************************************/
	private void balanceRec(int low, int high)
	{
		if(low == high)
        return;

		int midpoint = (low + high)/2;

		insert(values[midpoint]);
		insertItem(insert);

		balanceRec(midpoint+1, high);
		balanceRec(low, midpoint);

	}

	/************************************************************
    IMPORT: currNode(DSATreeNode)
    EXPORT: int
    ASSERTION: Wrapper method; Returns height of tree as int
    ************************************************************/
	public int height(DSATreeNode n)
	{
		return heightRec(n);
	}

	/************************************************************
    IMPORT: currNode(DSATreeNode)
    EXPORT: int
    ASSERTION: recursive method; Returns height of tree as int
    ************************************************************/
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

	/************************************************************
	*** ACCESSORS ***
	************************************************************/

	public DSATreeNode getRoot()
	{
		return root;
	}

	/************************************************************
    IMPORT: currNode(DSATreeNode)
    EXPORT: minKey(String)
    ASSERTION: returns left most key
    ************************************************************/
	public String min(DSATreeNode currNode)
	{
		String minKey = " ";
		while (currNode.getLeft() != null) // keep going left
		{
			currNode = currNode.getLeft();
		}
		minKey = currNode.getKey();
		return minKey;
	}

	/************************************************************
    IMPORT: currNode(DSATreeNode)
    EXPORT: minKey(String)
    ASSERTION: returns right most key
    ************************************************************/
	public String max(DSATreeNode currNode)
	{
		String maxKey = " ";
		while (currNode.getRight() != null) // keep going right
		{
			currNode = currNode.getRight();
		}
		maxKey = currNode.getKey();
		return maxKey;
	}

 //DEBUG ONLY
	public void printRoot()
		{
			if(root != null)
			{

				System.out.println("Current root node: " + root.getValue());
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
	private class DSATreeNode implements Serializable
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
		@Override
		public String toString()
		{
			return "Key: |"+ key + "| Value: |" + value.toString();
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



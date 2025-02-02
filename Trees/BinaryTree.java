/*

The BinaryTree Class

@author Autumn C. Spaulding <a href="mailto:autumn@max.cs.kzoo.edu">email</a>
Creation Date: 24 July 2000

Modifications:
    Modifier: Alyce Brady
    Modification Date: November 11, 2002
    Modifications Made: Modifications to documentation (e.g., to remove
        empty preconditions); added levelOrderTraversal;
        also modified to use NodeAction interface.

Modifications:
    Modifier: studentName
    Modification Date: currentDate
    Modifications Made:

Description:
    This file contains some of the implementation of a BinaryTree class. 
    It is intended as an outline and starting point for the "Binary Trees"
    lab in the Data Structures course.  The implementation is based on the 
    recursive definition of a tree rather than on the graph theory definition
    of a tree (compare to Bailey, 190).
    
    A binary tree is either:
        1.  An empty tree; or
        2.  a node, called a root (the node contains the data), and two 
            children, left and right, each of which are themselves binary trees.
                (Berman, "Data Structures via C++: Objects by Evolution", 1997.)
    
    In this implementation, an empty tree is represented by a node with null
    data and null references for the children.  A leaf node is represented by
    a node with a data value and two references to empty trees (NOT a data
    value and two null references!).  We could represent this as an object
    invariant: data, left, right are either all null (representing an empty
    tree) or none of them are null (a non-empty tree).

*/

import javax.xml.soap.Node;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class BinaryTree
{
    //data:
    protected Object data;
    protected BinaryTree left;
    protected BinaryTree right;
        
    /*tested*/
    /** Creates an empty binary tree with no data and no children. */
    public BinaryTree()
    {
        //this is the contructor for the BinaryTree object
        data = null;
        left = null;
        right = null;
    }
     
    /*tested*/
    /** Tests whether this is an empty tree.
            @return true if the tree is empty; false otherwise
    */
    public boolean isEmpty()
    {
        return data == null;
    }
   
    /*tested*/
    /** Gets the data associated with the root node of this particular tree
        (recall recursive definition of trees).
            @return value associated with tree's root node; 
                          null if tree is empty
    */
    public Object getElement()
    {
        return data;
    }

    /*tested*/
    /** Gets the left child of the current tree.
            @return the left child (a tree)
    */
    public BinaryTree leftTree()
    {
        return left;
    }

    /*tested*/
    /** Gets the right child of the current tree.
            @return the right child (a tree)
    */
    public BinaryTree rightTree()
    {
        return right;
    }

    /** Adds elements to a binary tree.  This implementation adds the
        elements in breadth-first (top-down, left-to-right) order.
            @param value the value to be added to the tree.
            @return true when the value has been added; should never return false
    */
    public boolean add(Object value)
    {
        LLQueue queue = new LLQueue();
        queue.enqueue(this);
        while( ! queue.isEmpty() )
        {
            BinaryTree tree = (BinaryTree)queue.dequeue();

            //if the current position is null, then we know we can place a
            //value here.
            //place the value in that position in the tree, and create new 
            //BinaryTrees for its children, which will both initially be null.
            if (tree.isEmpty())
            {
                tree.data = value;
                tree.left = new BinaryTree();
                tree.right = new BinaryTree();
                return true;
            }
            //otherwise, if the position is not null (that is, we can't place
            //it at the current position), then we add the left and right children
            //to the queue (if we can) and go back to the beginning of the loop.
            queue.enqueue(tree.left);
            queue.enqueue(tree.right);
        }
        return false;    //this statement should never be executed.
    }

	/** Traverses the tree in breadth-first order.
	        @param action an object that will act on all the nodes in the tree
	*/
	public void breadthFirstTraversal(NodeVisitor action)
	{
		LLQueue queue = new LLQueue();
		queue.enqueue(this);
		while( ! queue.isEmpty() )
		{
			BinaryTree tree = (BinaryTree)queue.dequeue();
			if ( ! tree.isEmpty() )
            {
    			action.visit(tree.getElement());
    			queue.enqueue(tree.leftTree());
    			queue.enqueue(tree.rightTree());
            }
		}
	}
	public void preOrderDepthFirstTraversal(NodeVisitor action) {
        LLQueue queue = new LLQueue();
        queue.enqueue(this);
        while (!queue.isEmpty()) {
            BinaryTree tree = (BinaryTree) queue.dequeue();
            if (!tree.isEmpty()) {
//                visit root node
                action.visit(tree.getElement());
//                recursively traverse Left tree
                leftTree().preOrderDepthFirstTraversal(action);
//                recursively traverse Right tree
                rightTree().preOrderDepthFirstTraversal(action);
            }
        }
    }
    public void inOrderDepthFirstTraversal(NodeVisitor action) {
        LLQueue queue = new LLQueue();
        queue.enqueue(this);
        while (!queue.isEmpty()) {
            BinaryTree tree = (BinaryTree) queue.dequeue();
            if (!tree.isEmpty()) {
//                recursively traverse Left tree
                leftTree().preOrderDepthFirstTraversal(action);
                //                visit root node
                action.visit(tree.getElement());
//                recursively traverse Right tree
                rightTree().preOrderDepthFirstTraversal(action);
            }
        }
    }
    public void postOrderDepthFirstTraversal(NodeVisitor action) {
        LLQueue queue = new LLQueue();
        queue.enqueue(this);
        while (!queue.isEmpty()) {
            BinaryTree tree = (BinaryTree) queue.dequeue();
            if (!tree.isEmpty()) {
//                recursively traverse Left tree
                leftTree().preOrderDepthFirstTraversal(action);
//                recursively traverse Right tree
                rightTree().preOrderDepthFirstTraversal(action);
                //                visit root node
                action.visit(tree.getElement());
            }
        }
    }
    public boolean isLeaf(NodeVisitor action) {
        LLQueue queue = new LLQueue();
        queue.enqueue(this);
        while (!queue.isEmpty()) {
            BinaryTree tree = (BinaryTree) queue.dequeue();
            if (tree.isEmpty()) {
                if(tree.right==null && tree.left==null)
                return true;
                else return false;
            }else {
                //                visit root node
                action.visit(tree.getElement());
//                recursively call method for Left tree
                    leftTree().isLeaf(action);
//                recursively call method for Right tree
                    rightTree().isLeaf(action);

                }
            }return false;
        }
    public int numLeaves(NodeVisitor action) {
        LLQueue queue = new LLQueue();
        queue.enqueue(this);
        int count = 0;
        while (!queue.isEmpty()) {
            BinaryTree tree = (BinaryTree) queue.dequeue();
            if (tree.isEmpty()) {
                if(tree.right==null && tree.left==null)
                    count++;
            }else {
                //                visit root node
                action.visit(tree.getElement());
//                recursively call method for Left tree
                leftTree().isLeaf(action);
//                recursively call method for Right tree
                rightTree().isLeaf(action);

            }
        }return count;
    }
    public int numNodes(NodeVisitor action)
    {
        LLQueue queue = new LLQueue();
        queue.enqueue(this);
        int count = 0;
        while( ! queue.isEmpty() )
        {
            BinaryTree tree = (BinaryTree)queue.dequeue();
            if ( ! tree.isEmpty() )
            {
                action.visit(tree.getElement());
                queue.enqueue(tree.leftTree());
                count++;
                queue.enqueue(tree.rightTree());
                count++;
            }
        }return count;
    }
    public int depth(NodeVisitor action)
    {
        LLQueue queue = new LLQueue();
        queue.enqueue(this);
        int count = 0;
        while( ! queue.isEmpty() )
        {
            BinaryTree tree = (BinaryTree)queue.dequeue();
            if ( ! tree.isEmpty() )
            {
                action.visit(tree.getElement());
                count++;
                queue.enqueue(tree.leftTree());
                queue.enqueue(tree.rightTree());
            }
        }return count;
    }
    public boolean contains(Object O) {
        LLQueue queue = new LLQueue();
        queue.enqueue(this);
        while (!queue.isEmpty()) {
            BinaryTree tree = (BinaryTree) queue.dequeue();
            if (!tree.isEmpty()) {
                if (tree.getElement() == O)
                    return true;
            }
        }
        return false;
    }
    public int numOccurences(Object O) {
        LLQueue queue = new LLQueue();
        queue.enqueue(this);
        int count = 0;
        while (!queue.isEmpty()) {
            BinaryTree tree = (BinaryTree) queue.dequeue();
            if (!tree.isEmpty()) {
                if (tree.getElement() == O)
                    count++;
            }
        }
        return count;
    }




    } //end class BinaryTree

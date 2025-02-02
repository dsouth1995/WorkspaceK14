/*
	Main file for Binary Tree Lab
	@author Autumn C. Spaulding
	Creation Date: 24 July 2000
	
	More thorough documentation may be found within the BinaryTree class file.
*/

public class BinaryTreeLab
{

	public static void main(String args[])
	{
		// Debug.turnOn();
		Debug.turnOff();


		//construct an empty binary tree here.
		BinaryTree binaryTree = new BinaryTree();
		
		//insert elements in level order here.

		binaryTree.add(12);
		binaryTree.add(7);
		binaryTree.add(3);
		binaryTree.add(4);
		binaryTree.add(8);
		binaryTree.add(25);
		binaryTree.add(0);
		binaryTree.add(142);
		binaryTree.add(17);
		binaryTree.add(26);

		//traverse the tree in breadth-first order to see what you have done.
        NodeVisitor printer = new PrintAction();
        //NodeVisitor sumVisitor = new SumVisitor();
        binaryTree.preOrderDepthFirstTraversal(printer);
        System.out.println("******Traversing Tree: breadth-first order******");
        binaryTree.breadthFirstTraversal(printer);
        //System.out.println("sum: "+sumVisitor.sum());

			
	}

}	//end class BinaryTreeLab

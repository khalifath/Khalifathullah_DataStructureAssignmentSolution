package com.assessment.bsttorightskewed;

public class BstToRightSkewed
{
	static BstToRightSkewedHandler bst	= new BstToRightSkewedHandler();

	public static void main (String[] args)
	{
		
		bst.setNode(new NewNode(50));
		bst.getNode().left = new NewNode(30);
		bst.getNode().left.left = new NewNode(10);
		//bst.getNode().left.left.left = new NewNode(3);
		//bst.getNode().left.left.left.right = new NewNode(7);
		bst.getNode().right = new NewNode(60);
		//bst.getNode().right.right = new NewNode(80);
		bst.getNode().right.left=new NewNode(55);
		
		bst.bstToRightSkewed(bst.getNode());
		bst.traverseRightSkewed(bst.getRootNode());
	}
}

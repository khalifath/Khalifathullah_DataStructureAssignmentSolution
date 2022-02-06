package com.assessment.bsttorightskewed;

class NewNode {
	int data;
	NewNode left, right;
	
	NewNode(int item){
		data = item;
		left = right = null;
	}
}

class BstToRightSkewedHandler {
	private NewNode node;
	private NewNode prevNode = null;
	private NewNode RootNode = null;

	public NewNode getNode() {
		return node;
	}

	public void setNode(NewNode node) {
		this.node = node;
	}

	public NewNode getRootNode() {
		return RootNode;
	}

	public void setRootNode(NewNode rootNode) {
		RootNode = rootNode;
	}

	void bstToRightSkewed(NewNode root)
	{

		if(root == null){
			return;
		}

		bstToRightSkewed(root.left);
		NewNode rightNode = root.right;

		if(RootNode == null){
			RootNode = root;
			root.left = null;
			prevNode = root;
		}
		else{
			prevNode.right = root;
			root.left = null;
			prevNode = root;
		}

		bstToRightSkewed(rightNode);
	}

	void traverseRightSkewed(NewNode root)
	{
		if(root == null)
			return;

		System.out.print(root.data + " ");
		traverseRightSkewed(root.right);	
	}
}
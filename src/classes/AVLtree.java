package classes;

import java.util.Comparator;

public class AVLtree<T> extends BinarySearchTree<T>{

	public AVLtree(Comparator<T> comparator) {
		this.setComparator(comparator);
	}

	private int balanceFactor(TreeNode<T> node) {
		if (node == null) {return 0;}
		else {
			int leftHeight = getHeight(node.getLeftChild());
			int rightHeight  = getHeight(node.getRightChild());
			return leftHeight - rightHeight;
		}
	}

	private void balanceNode(TreeNode<T> node) {
		int parentBF = balanceFactor(node);
		// if (parentBF >= -1 || parentBF <= 1) {return;}
		if (parentBF == 2) {		//if left heavy
			int leftChildBF = balanceFactor(node.getLeftChild());
			if (leftChildBF == 1) {
				leftRotate(node);
			}
			if (leftChildBF == -1) {
				leftRightRotate(node);
			}
		}
		if (parentBF == -2) {		//if right heavy
			int rightChildBF = balanceFactor(node.getRightChild());
			if (rightChildBF == -1) {
				rightRotate(node);
			}
			if (rightChildBF == 1) {
				rightLeftRotate(node);
			}
		}
	}

	private void leftRotate(TreeNode<T> unbalancedNode) {
		TreeNode<T> leftChild = unbalancedNode.getLeftChild();			//save leftchild
		if(leftChild.hasRightChild()) {									//if leftchild has a rightchild
			TreeNode<T> leftsRightChild = leftChild.getRightChild();
			leftsRightChild.setParent(unbalancedNode);					//left childs right child's new parent is unbalanced node
			unbalancedNode.setLeftChild(leftsRightChild);				//unbalanced node's new left child is old left nodes right child
		}
		else {unbalancedNode.setLeftChild(null);}			//unbalanced node new left child is null
		leftChild.setRightChild(unbalancedNode);	//leftchilds new rright child is the unbalanced node
		if (unbalancedNode == this.getRoot()) {		//if unbalanced node was the root
			leftChild.setParent(null);		//make leftchild the new root
			this.setRoot(leftChild);
		}
		else if (unbalancedNode == unbalancedNode.getParent().getLeftChild()) {		// if unbalanced node was right child
			leftChild.setParent(unbalancedNode.getParent());						// make leftchild the new rightchild
			unbalancedNode.getParent().setLeftChild(leftChild);
		}
		else if (unbalancedNode == unbalancedNode.getParent().getRightChild()) {	//if unbalannce node was left left
			leftChild.setParent(unbalancedNode.getParent());						//make leftchild the old parents left child
			unbalancedNode.getParent().setRightChild(leftChild);
		}
		unbalancedNode.setParent(leftChild);
	}
	private void rightRotate(TreeNode<T> unbalancedNode) {
		TreeNode<T> rightChild = unbalancedNode.getRightChild();	//save rightchild
		if(rightChild.hasLeftChild()) {									//if rightchild has a leftchild
			TreeNode<T> rightsLeftChild = rightChild.getLeftChild();	//give it to rightchilds parent
			rightsLeftChild.setParent(unbalancedNode);
			unbalancedNode.setRightChild(rightsLeftChild);
		}
		else {unbalancedNode.setRightChild(null);}			//else set unbalanced node rightChild to null
		rightChild.setLeftChild(unbalancedNode);		//rightchilds left node is now old unbalanced
		if (unbalancedNode == this.getRoot()) {
			rightChild.setParent(null);
			this.setRoot(rightChild);
		}
		else if (unbalancedNode == unbalancedNode.getParent().getRightChild()) {
			rightChild.setParent(unbalancedNode.getParent());
			unbalancedNode.getParent().setRightChild(rightChild);
		}
		else if (unbalancedNode == unbalancedNode.getParent().getLeftChild()) {
			rightChild.setParent(unbalancedNode.getParent());
			unbalancedNode.getParent().setLeftChild(rightChild);
		}
		unbalancedNode.setParent(rightChild);
	}
	private void rightLeftRotate(TreeNode<T> unbalancedNode) {
		TreeNode<T> rightChild = unbalancedNode.getRightChild();
		TreeNode<T> rightsLeftChild = rightChild.getLeftChild();
		if (rightsLeftChild.hasRightChild()) {
			TreeNode<T> rightsLeftRightChild = rightsLeftChild.getRightChild();
			rightsLeftRightChild.setParent(rightChild);
			rightChild.setLeftChild(rightsLeftRightChild);
		}
		else {rightChild.setLeftChild(null);}
		unbalancedNode.setRightChild(rightsLeftChild);
		rightsLeftChild.setParent(unbalancedNode);
		rightsLeftChild.setLeftChild(rightChild);
		rightChild.setParent(rightsLeftChild);
		rightRotate(unbalancedNode);
	}
	public void leftRightRotate(TreeNode<T> unbalancedNode) {
		TreeNode<T> leftChild = unbalancedNode.getLeftChild();
		TreeNode<T> leftsRightChild = leftChild.getRightChild();
		if (leftsRightChild.hasLeftChild()) {
			TreeNode<T> leftsRightLeftChild = leftsRightChild.getLeftChild();
			leftsRightLeftChild.setParent(leftChild);
			leftChild.setRightChild(leftsRightLeftChild);
		}
		else {leftChild.setRightChild(null);}
		unbalancedNode.setLeftChild(leftsRightChild);
		leftsRightChild.setParent(unbalancedNode);
		leftsRightChild.setLeftChild(leftChild);
		leftChild.setParent(leftsRightChild);
		leftRotate(unbalancedNode);
	}

	public void insertValueAVL(T value) {
		if (this.contains(value)) {return;}
		TreeNode<T> newNode = new TreeNode<T>(value);
		insertTreeNodeAVL(newNode);
	}
	public void insertTreeNodeAVL(TreeNode<T> newNode) {
		if (newNode.getValue() == null) {return;}
		if (this.getRoot() == null) {
			this.setRoot(newNode);
			return;
		}
		TreeNode<T> iterNode = this.getRoot();
		while (iterNode != null) {
			if (this.cmp.compare(newNode.getValue(), iterNode.getValue()) < 0) {
				if(!iterNode.hasLeftChild()) {
					iterNode.setLeftChild(newNode);
					newNode.setParent(iterNode);
					iterNode = null;
				}
				else {iterNode = iterNode.getLeftChild();}
			}
			else if (this.cmp.compare(newNode.getValue(), iterNode.getValue()) > 0) {
				if (!iterNode.hasRightChild()) {
					iterNode.setRightChild(newNode);
					newNode.setParent(iterNode);
					iterNode = null;
				}
				else {iterNode = iterNode.getRightChild();}
			}
		}
		iterNode = newNode.getParent();
		while (iterNode != null) {
			balanceNode(iterNode);
			iterNode = iterNode.getParent();
		}
	}

	public void AVLdelete(T value) {
		TreeNode<T> node = findNodeOf(value);
		if (node == null) {return;}
		this.BSTdelete(value);
		TreeNode<T> iterNode = node.getParent();
		while (iterNode != null) {
			balanceNode(iterNode);
			iterNode.getParent();
		}
	}
}
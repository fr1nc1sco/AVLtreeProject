package classes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree<T>{
	//attributes
	private TreeNode<T> root;

	public BinaryTree() {
		this.root = null;
	}
	public BinaryTree(TreeNode<T> root) {this.root = root;}

	//getter and setter for root
	public TreeNode<T> getRoot() {return this.root;}
	public void setRoot(TreeNode<T> newRoot) {this.root = newRoot;}

	//toString
	public String toString() {
		List<T> result = breadthFirstTraversal(root);
		return result.toString();
	}

	//preorder
	public void printPreorder() {System.out.println(this.recursivePreorderTraversal());}
	public List<T> recursivePreorderTraversal() {
		List<T> result = new ArrayList<T>();
		recursivePreorderTraversal(this.root, result);
		return result;
	}
	public void recursivePreorderTraversal(TreeNode<T> current, List<T> list) {
		// 1. process the current node
		list.add(current.getValue());
		// 2. recursively call method on the current's left
		if (current.hasLeftChild()) {
			recursivePreorderTraversal(current.getLeftChild(), list);
		}
		// 3. recursively call method on the current's right
		if (current.hasRightChild()) {
			recursivePreorderTraversal(current.getRightChild(), list);
		}
	}
	//inorder
	public void printInorder() {System.out.println(this.recursiveInorderTraversal());}
	public List<T> recursiveInorderTraversal() {
		List<T> result = new ArrayList<>();
		recursiveInorderTraversal(this.root, result);
		return result;
	}
	public void recursiveInorderTraversal(TreeNode<T> current, List<T> list) {
		//1. recursively call method on left child
		if (current == null) {return;}
		if (current.hasLeftChild()) {
			recursiveInorderTraversal(current.getLeftChild(), list);
		}
		//2. process current node
		list.add(current.getValue());
		//3. recursively call method on right child
		if (current.hasRightChild()) {
			recursiveInorderTraversal(current.getRightChild(), list);
		}
	}
	//postorder
	public void printPostorder() {System.out.println(this.recursivePostorderTraversal());}
	public List<T> recursivePostorderTraversal() {
		List<T> result = new ArrayList<>();
		recursivePostorderTraversal(this.root, result);
		return result;
	}
	public void recursivePostorderTraversal(TreeNode<T> current, List<T> list) {
		if (current == null) {return;}
		//recusively call method on left child
		if (current.hasLeftChild()) {
			recursivePostorderTraversal(current.getLeftChild(), list);
		}
		//recusively call method on right child
		if (current.hasRightChild()) {
			recursivePostorderTraversal(current.getRightChild(), list);
		}
		//process current node
		list.add(current.getValue());
	}

	public void printBFS() {System.out.println(breadthFirstTraversal(this.root));}
	public List<T> breadthFirstTraversal(TreeNode<T> root) {
		List<T> valueList = new ArrayList<>();
		if (root == null) {return valueList;}
		Queue<TreeNode<T>> nodeQueue = new LinkedList<>();
		nodeQueue.add(root);
		while(!nodeQueue.isEmpty()) {
			TreeNode<T> iterNode = nodeQueue.poll();
			valueList.add(iterNode.getValue());
			if (iterNode.hasLeftChild()) {
				nodeQueue.add(iterNode.getLeftChild());
			}
			if (iterNode.hasRightChild()) {
				nodeQueue.add(iterNode.getRightChild());
			}
		}
		return valueList;
	}
/*
	recursive BFS
	public List<T> breadthFirstSearch(TreeNode<T> root) {
		List<T> result = new ArrayList<T>();
		int treeHeight = getHeight(root);
		for (int i = 1; i <= treeHeight; i++) {
			addLevel(root, i, result);
		}
		return result;
	}
	public void addLevel(TreeNode<T> root, int level, List<T> list) {
		if (root == null) {return;}
		if (level == 1) {
			list.add(root.getValue());
		}
		else if (level > 1) {
			addLevel(root.getLeftChild(), level-1, list);
			addLevel(root.getRightChild(), level-1, list);
		}
	}
*/


}

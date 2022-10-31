package classes;
import java.util.Comparator;


//import Algorithms.TreeNode;
public class BinarySearchTree<T> extends BinaryTree<T> {
	//attributes
	protected Comparator<T> cmp;
	
	//constructors
	public BinarySearchTree() {
		this.setRoot(null);
		this.cmp = null;
	}
	public BinarySearchTree(Comparator<T> cmp) {
		this.cmp = cmp;
		this.setRoot(null);
	}
	
	//comparator setter
	public void setComparator(Comparator<T> cmp) {
		this.cmp = cmp;
	}
	//retrieves height of given Node
	public int getHeight(TreeNode<T> node) {
		if (node == null) {return 0;}
		else {
			int leftHeight = getHeight(node.getLeftChild());
			int rightHeight = getHeight(node.getRightChild());
			if (leftHeight >= rightHeight) {return 1 + leftHeight;}
			return 1 + rightHeight;
		}
	}

	//retrieves size of BST using root
	public int getSize() {return getSize(this.getRoot());}
	//retrieves size of a tree given the root of it
	public int getSize(TreeNode<T> node) {
		if (node == null) {return 0;}
		else {
			return 1 + getSize(node.getLeftChild()) + getSize(node.getRightChild());
		}
	}

	//checks if a value is contained
	public boolean contains(T value) {
		TreeNode<T> iterNode = this.getRoot();				//creates iter node
		while (iterNode != null) {
			if (this.cmp.compare(value, iterNode.getValue()) == 0) {
				return true;							//returns true value is found
			} else if (this.cmp.compare(value, iterNode.getValue()) < 0) {
				iterNode = iterNode.getLeftChild();		//goes to left child if value is less than iterNode value
			} else if (this.cmp.compare(value, iterNode.getValue()) > 0) {
				iterNode = iterNode.getRightChild();	//goes to right child if value is greater than iterNode value
			}
		}
		return false;		//returns false if value is not found
	}

	//returns parent node of a node with the given value
	public TreeNode<T> getParentOfValue(T needle) {
		TreeNode<T> pre = null;
		TreeNode<T> current = this.getRoot();
		while (current != null) {
			if (this.cmp.compare(needle, current.getValue()) == 0) {
				return null;
			} else if (this.cmp.compare(needle, current.getValue()) < 0) {
				pre = current;
				current = current.getLeftChild();
			} else if (this.cmp.compare(needle, current.getValue()) > 0) {
				pre = current;
				current = current.getRightChild();
			}
		}
		return pre;
	}

	public void insertValueBST(T value) {
		// First we need a new node to put value in
		TreeNode<T> newNode = new TreeNode<T>(value);
		insertTreeNodeBST(newNode);
	}
	public void insertTreeNodeBST(TreeNode<T> newNode) {
		if (this.getRoot() == null) {
			this.setRoot(newNode);
			return;
		}
		// If not in the tree, I have to search for the parent of the new node
		TreeNode<T> parent = getParentOfValue(newNode.getValue());
		if (newNode.getValue() == null) {
			// If already there, no need to insert
			return;
		}
		newNode.setParent(parent);
		if (this.cmp.compare(parent.getValue(), newNode.getValue()) < 0) {
			parent.setRightChild(newNode);
		} 
		else {
			parent.setLeftChild(newNode);
		}
		// we return true. Inserting a node had an effect on the tree
		return;
	}

	public TreeNode<T> findNodeOf(T value) {
		TreeNode<T> iterNode = new TreeNode<T>();
		iterNode = this.getRoot();
		while (iterNode != null) {
			if (this.cmp.compare(value, iterNode.getValue()) == 0) {
				return iterNode;
			}
			else if (this.cmp.compare(value, iterNode.getValue()) < 0) {
				iterNode = iterNode.getLeftChild();
			}
			else if (this.cmp.compare(value, iterNode.getValue()) > 0){
				iterNode = iterNode.getRightChild();
			}
		}
		return null;
	}
	private TreeNode<T> rightMostNodeOf(TreeNode<T> node) {
		if (!node.hasRightChild()) {return node;}
		return rightMostNodeOf(node.getRightChild());
	}
	public void BSTdelete(T value) {
		// First we need to find the node
		TreeNode<T> node = findNodeOf(value);
		if (node == null) {return;}				//if node with value dne end function
		if (!node.hasLeftChild() && !node.hasRightChild()) {			//if node is a leaf
			if (node == this.getRoot()) {this.setRoot(null);}	// if node was root then make root null
			else if (node.getParent().getLeftChild() == node) {
				node.getParent().setLeftChild(null);			// if oldnode was left child, newnode is left child
			}
			else {node.getParent().setRightChild(null);}	// if oldnode was right child, newnode is right child
		} 
		else if ((node.hasLeftChild() && !node.hasRightChild())) {	// if node only has a left child
			TreeNode<T> parent = node.getParent();
			TreeNode<T> left = node.getLeftChild();
			if (node == this.getRoot()) {
				this.setRoot(left);
				left.setParent(null);
			}
			else if (node == parent.getLeftChild()) {
				parent.setLeftChild(left);
				left.setParent(parent);
			} else {
				parent.setRightChild(left);
				left.setParent(parent);
			}
		} 
		else if ((!node.hasLeftChild() && node.hasRightChild())) {
			TreeNode<T> parent = node.getParent();
			TreeNode<T> right = node.getRightChild();
			if (node == this.getRoot()) {
				this.setRoot(right);
				right.setParent(null);
			}
			else if (node == parent.getLeftChild()) {
				parent.setLeftChild(right);
				right.setParent(parent);
			} else {
				parent.setRightChild(right);
				right.setParent(parent);
			}
		} 
		else if (node.hasLeftChild() && node.hasRightChild()){
			TreeNode<T> parent = node.getParent();			//retrieves parent of node to be deleted
			TreeNode<T> successorNode = rightMostNodeOf(node.getLeftChild());		//finds node to replace deleted
			TreeNode<T> leftChild = node.getLeftChild();
			TreeNode<T> rightChild = node.getRightChild();
			//successorNode.setRelations(node.getParent(), node.getLeftChild(), node.getRightChild()); //gives new node parents and children
			if (node == this.getRoot()) {
				if (successorNode == leftChild) {
					leftChild.setParent(null);
					if (node.hasRightChild()) {
						rightChild.setParent(leftChild);
						leftChild.setRightChild(rightChild);
					}
					this.setRoot(leftChild);
				}
				else {
					if (successorNode.hasLeftChild()) {
						successorNode.getParent().setRightChild(successorNode.getLeftChild());
						successorNode.getLeftChild().setParent(successorNode.getParent());
					}
					else {successorNode.getParent().setRightChild(null);}
					leftChild.setParent(successorNode);
					rightChild.setParent(successorNode);
					successorNode.setRelations(null, leftChild, rightChild);
					this.setRoot(successorNode);
				}
			}
			else {
				if (node == leftChild) {
					if (successorNode.hasLeftChild()) {
						successorNode.getParent().setRightChild(successorNode.getLeftChild());
						successorNode.getLeftChild().setParent(successorNode.getParent());
					}
					else {successorNode.getParent().setRightChild(null);}
					node.getLeftChild().setParent(successorNode);
					node.getRightChild().setParent(successorNode);
					successorNode.setRelations(parent, node.getLeftChild(), node.getRightChild());
					parent.setLeftChild(successorNode);
				}
				else if (node == parent.getRightChild()) {
					if (successorNode.hasLeftChild()) {
						successorNode.getLeftChild().setParent(successorNode.getParent());
						successorNode.getParent().setRightChild(successorNode.getLeftChild());
					}
					else {successorNode.getParent().setRightChild(null);}
					node.getLeftChild().setParent(successorNode);
					node.getRightChild().setParent(successorNode);
					successorNode.setRelations(parent, node.getLeftChild(), node.getRightChild());
					parent.setRightChild(successorNode);
				}
			}
		}
	}
}
package classes;

public class TreeNode<T> {
    private T value;
    private TreeNode<T> parent;
    private TreeNode<T> leftChild;
    private TreeNode<T> rightChild;
    public TreeNode() {
        this.value = null;
        this.setRelations(null, null, null);
    }
    public TreeNode(T value) {
        this.value = value;
        this.setRelations(null, null, null);
    }
    public TreeNode(T value, TreeNode<T> parent, TreeNode<T> leftChild, TreeNode<T> rightChild) {
        this.value = value;
        this.setRelations(parent, leftChild, rightChild);
    }
    public void setRelations(TreeNode<T> parent, TreeNode<T> leftChild, TreeNode<T> rightChild) {
        this.setParent(parent);
        this.setLeftChild(leftChild);
        this.setRightChild(rightChild);
    }
    //getter for value
    public T getValue() {return this.value;}
    //getter, setter, and hasser for parents
    public TreeNode<T> getParent() {return this.parent;}
    public void setParent(TreeNode<T> parent) {this.parent = parent;}
    public boolean hasParent() {return this.parent != null;}
    //getter , setter and hasser for left child
    public TreeNode<T> getLeftChild() {return this.leftChild;}
    public void setLeftChild(TreeNode<T> leftChild) {this.leftChild = leftChild;}
    public boolean hasLeftChild() {return this.leftChild != null;}
    //getter, setter, hasser for right child
    public TreeNode<T> getRightChild() {return this.rightChild;}
    public void setRightChild(TreeNode<T> rightChild) {
        this.rightChild = rightChild;
    }
    public boolean hasRightChild() {return this.rightChild != null;}
    //misc
    public boolean isLeaf() {return (!this.hasLeftChild() && !this.hasRightChild());}
    @Override
    public String toString() {return "(" + this.value + ")";}
}
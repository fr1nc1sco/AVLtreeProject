package main;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


import classes.*;

public class App {

    public static void main(String args[]) {
        BinaryTree<String> newBinaryTree = new BinaryTree<>();
        Map<String, TreeNode<String>> map = new HashMap<>();
        for (Character c = 'a'; c <= 'g'; c++) {
            map.put(c.toString(), new TreeNode<>(c.toString()));
        }
        newBinaryTree.setRoot(map.get("a"));
        // a init
        map.get("a").setParent(null);
        map.get("a").setLeftChild(map.get("b"));
        map.get("a").setRightChild(map.get("c"));
        // b init
        map.get("b").setParent(map.get("a"));
        map.get("b").setLeftChild(map.get("d"));
        map.get("b").setRightChild(map.get("e"));
        // c init
        map.get("c").setParent(map.get("a"));
        map.get("c").setLeftChild(map.get("f"));
        map.get("c").setRightChild(map.get("g"));
        // leafs init
        map.get("d").setParent(map.get("b"));
        map.get("e").setParent(map.get("b"));
        map.get("f").setParent(map.get("c"));
        map.get("g").setParent(map.get("c"));
        // preorder: [a, b, d, g, l, map, r, h, n, e, i, o, c, f, j, p, q, k]
        // inorder: [l, g, r, map, d, h, n, b, e, o, i, a, c, p, j, q, f, k]
        // post order: [l, r, map, g, n, h, d, o, i, e, b, p, q, j, k, f, c, a]
        // BFS: alphabetic!
        newBinaryTree.printPreorder();
        newBinaryTree.printInorder();
        newBinaryTree.printPostorder();
        newBinaryTree.printBFS();


        BinarySearchTree<Integer> t;
        t = new BinarySearchTree<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer int1, Integer int2) {
                return int1.compareTo(int2);
            }
        });
        
        TreeNode<Integer> n50 = new TreeNode<>(50);
        TreeNode<Integer> n40 = new TreeNode<>(40);
        TreeNode<Integer> n60 = new TreeNode<>(60);
        TreeNode<Integer> n20 = new TreeNode<>(20);
        TreeNode<Integer> n45 = new TreeNode<>(45);
        TreeNode<Integer> n90 = new TreeNode<>(90);
        TreeNode<Integer> n10 = new TreeNode<>(10);
        TreeNode<Integer> n24 = new TreeNode<>(24);
        TreeNode<Integer> n49 = new TreeNode<>(49);
        TreeNode<Integer> n80 = new TreeNode<>(80);
        TreeNode<Integer> n95 = new TreeNode<>(95);
        TreeNode<Integer> n02 = new TreeNode<>(02);
        TreeNode<Integer> n15 = new TreeNode<>(15);
        TreeNode<Integer> n28 = new TreeNode<>(28);
        TreeNode<Integer> n48 = new TreeNode<>(48);
        TreeNode<Integer> n75 = new TreeNode<>(75);
        TreeNode<Integer> n85 = new TreeNode<>(85);
        TreeNode<Integer> n12 = new TreeNode<>(12);
        
        n50.setRelations(null, n40, n60);
        // n50.setParent(null).setLeftChild(n40).setRightChild(n60);
        n40.setRelations(n50, n20, n45);
        // n40.setParent(n50).setLeftChild(n20).setRightChild(n45);
        n60.setRelations(n50, null, n90);
        // n60.setParent(n50).setLeftChild(null).setRightChild(n90);
        n20.setRelations(n40, n10, n24);
        // n20.setParent(n40).setLeftChild(n10).setRightChild(n24);
        n45.setRelations(n40, null, n49);
        // n45.setParent(n40).setLeftChild(null).setRightChild(n49);
        n90.setRelations(n60, n80, n95);
        // n90.setParent(n60).setLeftChild(n80).setRightChild(n95);
        n10.setRelations(n20, n02, n15);
        // n10.setParent(n20).setLeftChild(n02).setRightChild(n15);
        n24.setRelations(n20, null, n28);
        // n24.setParent(n20).setLeftChild(null).setRightChild(n28);
        n49.setRelations(n45, n48, null);
        // n49.setParent(n45).setLeftChild(n48).setRightChild(null);
        n80.setRelations(n90, n75, n85);
        // n80.setParent(n90).setLeftChild(n75).setRightChild(n85);
        n95.setRelations(n90, null, null);
        // n95.setParent(n90).setLeftChild(null).setRightChild(null);
        n02.setRelations(n10, null, null);
        // n02.setParent(n10).setLeftChild(null).setRightChild(null);
        n15.setRelations(n10, n12, null);
        // n15.setParent(n10).setLeftChild(n12).setRightChild(null);
        n28.setRelations(n24, null, null);
        // n28.setParent(n24).setLeftChild(null).setRightChild(null);
        n48.setRelations(n49, null, null);
        // n48.setParent(n49).setLeftChild(null).setRightChild(null);
        n75.setRelations(n80, null, null);
        // n75.setParent(n80).setLeftChild(null).setRightChild(null);
        n85.setRelations(n80, null, null);
        // n85.setParent(n80).setLeftChild(null).setRightChild(null);
        n12.setRelations(n15, null, null);
        // n12.setParent(n15).setLeftChild(null).setRightChild(null);
        t.setRoot(n50);

        t.getHeight(t.findNodeOf(50));

        t.printInorder();
        t.printBFS();

        t.insertValueBST(30);

        t.printInorder();

        while(t.getRoot() != null) {
            t.BSTdelete(t.getRoot().getValue());
            t.printInorder();
        }

        Random random = new Random();
        AVLtree<Integer> avlTree = new AVLtree<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer int1, Integer int2) {
                return int1.compareTo(int2);
            }
        });

        
        for (int i = 1; i <= 10;i++) {
            int randomInt = random.nextInt(99) + 1;
            avlTree.insertValueAVL(randomInt);
            avlTree.printBFS();
        }

        while (avlTree.getRoot() != null) {
            avlTree.AVLdelete(avlTree.getRoot().getValue());
            avlTree.printBFS();
        }
    }
}

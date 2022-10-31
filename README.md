# AVL Tree Project

> Self-balancing binary search tree. Implemented in Java.

## Table of Contents

* [General Info](#general-info)
* [Technologies Used](#technologies-used)
* [Set Up](#set-up)
* [How to Run](#how-to-run)

## General Info

Project is split into 2 packages:  
&nbsp;&nbsp;&nbsp;&nbsp;Package 'main' consists of: 'main.java'.  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;File 'main.java' is responsible for running the main funciton in the application.  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;It runs a program which prompts the user for user input and calls the correct funstions accordingly.  
&nbsp;&nbsp;&nbsp;&nbsp;Package 'classes' consists of: 'TreeNode.java', 'BinaryTree.java', 'BinarySearchTree.java', and 'AVLtree.java'.  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;File 'TreeNode.java' contains the class definition of a tree node.  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;A tree node consists of a generic data type, a left and right child, and a parent.  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;File 'BinaryTree.java' contains the class definition of a binary tree.  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;A binary tree consists of a single tree node (root).  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;File contains methods for traversal: inorder, preorder, postorder, and level order.  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;File 'BinarySearchTree.java' contains the class definition of a binary search tree. It is a child class of BinartyTree.  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;A binary search tree is made up of a Comparator to distinguish between data values.  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;File also contains methods for: retieving the height and size of a tree (given a TreeNode), inserting, and deleting.  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;File 'AVLtree.java' contains the class definition of an AVL tree. It is a child class of Binary Tree and Binary Search Tree.  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;File contains methods for: inserting and deleteing (which automatically call to other methods to balance the tree if needed).

## Technologies Used

* Java
* Visual Studio Code
* Extension Pack for Java
* Git

## Set Up

1. Dowload all files onto a stand alone directory.

## How to Run

1. Run program from the console of said directory, or preffered IDE.

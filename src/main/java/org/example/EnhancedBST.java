package org.example;

import java.util.Scanner;

public class EnhancedBST extends BinarySearchTree {


    @Override
    public void print() {
        System.out.println();
        System.out.print("Inorder: ");
        super.print();
        System.out.print("Preorder: ");
        preorder(root);
        System.out.println();
        System.out.print("Postorder: ");
        postorder(root);
    }

    public void preorder(Node node) {
        if (node == null) {
            return;
        }
        //current node
        System.out.print(node.data + " ");

        // Recursively traverse the left subtree
        preorder(node.left);
        // Recursively traverse the right subtree
        preorder(node.right);
    }

    public void postorder(Node node) {
        if (node == null) {
            return;
        }
        // Recursively traverse the left subtree
        postorder(node.left);

        // Recursively traverse the right subtree
        postorder(node.right);

        //current node
        System.out.print(node.data + " ");

    }

    public int treeHeight(Node node) {
        if (node == null) {
            return 0;
        } else {
            //compute the depth of the subtree
            int leftDepth = treeHeight(node.left);
            int rightDepth = treeHeight(node.right);

            //use the larger one
            if (leftDepth > rightDepth)
                return (leftDepth + 1);
            else
                return (rightDepth + 1);
        }
    }


    public void internalPathLength() {


    }


    public void printLeafCount() {

        System.out.println("There are " + leafsInTree(root) + " leaves in this tree");
    }

    private int leafsInTree(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }

        return leafsInTree(node.left) + leafsInTree(node.right);
    }

    public void printSum() {

        System.out.println("The sum is " + sumEqualToUser(root));
    }

    public int sumEqualToUser(Node node) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("What is the path sum on either the left or right side of the tree?");
//        int userSum = scanner.nextInt();

        if (node == null) { l.;
            return 0;
        }``````
        if (node.left == null) {
            return 1;
        }
        if (node.right == null) {
            return 1;
        }

        return sumEqualToUser(node.left) + sumEqualToUser(node.right);

    }
}
//
//    public void rebuildTree () {
//
//    }
//
//    }









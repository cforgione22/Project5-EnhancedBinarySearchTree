package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        Scanner scanner = new Scanner(System.in);
        System.out.print("What your a path sum guess? ");
        int userSum = scanner.nextInt();
        List<Integer> pathSums = sumEqualToUser(root);

        boolean correct = false;
        for (int i = 0; i < pathSums.size(); i++) {
            if (userSum == pathSums.get(i)) {
                correct = true;
                break;
            }
        }

        if (correct) {
            System.out.println(" Your guess is true.");
        } else {
            System.out.println("Your guess is false.");
        }

        System.out.println("There are 3 paths, here are the sums " + Arrays.toString(pathSums.toArray()));
    }

    public List<Integer> sumEqualToUser(Node node) {
        if (node == null) {
            return null;
        }

        if (node.left == null && node.right == null) {
            int nodeValue = Integer.valueOf(node.data.toString());
            List<Integer> nodeList = new ArrayList<>();
            nodeList.add(nodeValue);
            return nodeList;
        }

        List<Integer> leftList = sumEqualToUser(node.left); // [0]
        List<Integer> rightList = sumEqualToUser(node.right); // [80]

        if (leftList == null) {
            leftList = new ArrayList<>();
        }

        if (leftList != null & rightList != null) {
            leftList.addAll(rightList);
        }

        for (int i = 0; i < leftList.size(); i++) { // could have used - for (int num: leftList)
            int num = leftList.get(i);
            int nodeValue = Integer.valueOf(node.data.toString());
            int sum = num + nodeValue;
            leftList.set(i, sum);
        }

        return leftList; // [80, 130]
    }
}

//    public void rebuildTree () {
//
//    }
//
//    }









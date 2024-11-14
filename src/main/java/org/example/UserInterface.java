/**
 * The UserInterface class should control all the input/output. Display a menu with the
 * following options:
 */

package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class UserInterface {

    public void go() {
    }


    public void menu() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        int option = -1;

        EnhancedBST intTree = new EnhancedBST();

        System.out.println("Welcome to Enhanced BST Tester.");
        do {
            System.out.println("\n\nHere's the menu of choices - ");
            System.out.println("0) Quit");
            System.out.println("1) Build BST from a text file");
            System.out.println("2) Print the tree");
            System.out.println("3) Add data");
            System.out.println("4) Remove data");
            System.out.println("5) Show tree height");
            System.out.println("6) Show internal path length");
            System.out.println("7) Count absent children");
            System.out.println("8) Find a path sum");
            System.out.println("9) Export a BST to a text file");
            System.out.print("Enter your choice: ");
            option = scanner.nextInt();
            System.out.println();
            switch (option) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    firstOption(intTree);
                    break;
                case 2:
                    intTree.print();
                    break;
                case 3:
                    addNumber(intTree);
                    break;
                case 4:
                    removeNumber(intTree);
                    break;
                case 5:
                    System.out.println("The height of the tree is: " +  intTree.treeHeight(intTree.root));
                    break;
                case 6:

                    break;
                case 7:
                    intTree.printLeafCount();
                    break;
                case 8:
                    intTree.printSum();
                case 9:
                    break;
                default:

            }
        }  while(option < 11);
    }

    /**
     * asks user for input/gets user input/gets file
     * @throws FileNotFoundException
     */
    public void firstOption(EnhancedBST intTree) throws FileNotFoundException {
        System.out.print("Please insert a text file name that contains integers. ");
        Scanner keyboard = new Scanner(System.in);
        //try catch - so there isn't an error if user types in wrong file name
        //file could be null
        File file = null;
        try {
            while (file == null || !file.exists()) {
                String filename = keyboard.nextLine();
                file = new File(filename);
                if (file != null && file.exists()) { // reads input from file
                    Scanner inputFile = new Scanner(file);
                    while (inputFile.hasNext()) {
                        int num = inputFile.nextInt();

                        intTree.add(num);
                    }
                }
                if (file == null || !file.exists()) {
                    System.out.println("No file with that name exists.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); // prints error to console;
        }
    }

    public void addNumber(EnhancedBST intTree)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type a number that you would like added to the Binary Search Tree: ");
        int newNum = scanner.nextInt();
        intTree.add(newNum);
        intTree.print();
    }

    public void removeNumber(EnhancedBST intTree)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type a number that you would like removed from the Binary Search Tree: ");
        int oldNum = scanner.nextInt();
        intTree.remove(oldNum);
        intTree.print();
    }

}

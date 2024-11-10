/**
 * The UserInterface class should control all the input/output. Display a menu with the
 * following options:
 */

package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UserInterface {

    public void go() {}

    public int menu() {
        Scanner scanner = new Scanner(System.in);
//        int option = -1;
        System.out.println("Welcome to Enhanced BST Tester.\n");
        System.out.println("Here's the menu of choices - ");
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
        System.out.println("Enter your choice: ");
        int option = scanner.nextInt();
        switch (option) {
            case 0:
                System.exit(0);
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            default:
        }
        return option;
    }


    /**
     * asks user for input/gets user input/gets file
     * @throws FileNotFoundException
     */

    public void firstOption() throws FileNotFoundException {
        EnhancedBST intTree = new EnhancedBST();

        System.out.println("Please insert a text file name that contains integers.");
        Scanner keyboard = new Scanner(System.in);
        //try catch - so there isn't an error of user types in wrong file name
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
                    intTree.print();
                }
                if (file == null || !file.exists()) {
                    System.out.println("No file with that name exists.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); // prints error to console;
        }
    }

}


//Option 1:
//and add them to the tree.
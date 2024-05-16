
// Name: Chidera Anamege


import java.util.Scanner;


public class dsassignment4part1 {

    private int[] arr; // array to store elements
    private int topStackA;
    private int topStackB;
    private final int maxSize; // maximum size of the stacks

    // constructor
    public dsassignment4part1(int size) {
        this.maxSize = size;
        arr = new int[size]; // create an array with the specified size
        topStackA = -1; // initialize the top of Stack A to -1
        topStackB = size; // initialize the top of Stack B to the index after the last element of the array
    }

    // method to push elements onto Stack A
    public void pushA(int data) {
        if (isFullA()) { // check if Stack A is full
            System.out.println("stack A is full!");
            return;
        }
        arr[++topStackA] = data; // increment topStackA and assign the data to the array
    }

    // method to pop elements from Stack A
    public int popA() {
        if (isEmptyA()) { // check if Stack A is empty
            System.out.println("stack A is empty!");
            return -1; // return -1 indicating failure
        }
        return arr[topStackA--]; // return the element and decrement topStackA
    }

    // method to pop elements from Stack B
    public int popB() {
        if (isEmptyB()) { // check if Stack B is empty
            System.out.println("stack B is empty!");
            return -1; // return -1 indicating failure
        }
        return arr[topStackB++]; // return the element and increment topStackB
    }

    // method to push elements onto Stack B
    public void pushB(int data) {
        if (isFullB()) { // check if Stack B is full
            System.out.println("stack B is full!"); // display a message
            return; // exit the method
        }
        arr[--topStackB] = data; // decrement topStackB and assign the data to the array
    }

    // method to check if Stack A is full
    public boolean isFullA() {
        return topStackA + 1 == topStackB; // return true if topStackA + 1 equals topStackB
    }

    // method to check if Stack B is full
    public boolean isFullB() {
        return topStackB == 0; // return true if topStackB equals 0
    }

    // method to check if Stack A is empty
    public boolean isEmptyA() {
        return topStackA == -1; // return true if topStackA equals -1
    }

    // method to check if Stack B is empty
    public boolean isEmptyB() {
        return topStackB == maxSize; // return true if topStackB equals maxSize
    }

    // main method where the program starts execution
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // create a Scanner object for user input

        System.out.print("enter the size of stack A: ");

        int size = scanner.nextInt();

        dsassignment4part1 stackPair = new dsassignment4part1(size); // create an instance of the dsassignment4part1 class with the specified size

        System.out.println("\nenter values for stack A: ");
        for (int i = 0; i < size; i++) { // iterate over the size of Stack A
            System.out.print("enter value for position " + (i + 1) + ": ");
            int value = scanner.nextInt();
            stackPair.pushA(value); // push the value onto Stack A
        }

        System.out.println("\nenter values for stack B: ");
        for (int i = 0; i < size; i++) { // iterate over the size of Stack B
            System.out.print("enter value for position " + (i + 1) + ": ");
            int value = scanner.nextInt();
            stackPair.pushB(value); // push the value onto Stack B
        }

        System.out.println("\nvalues popped from stack A: "); // display a message indicating values popped from Stack A
        while (!stackPair.isEmptyA()) { // loop until Stack A is empty
            System.out.print(stackPair.popA() + " "); // pop and print the value from Stack A
        }

        System.out.println("\nvalues popped from stack B: "); // display a message indicating values popped from Stack B
        while (!stackPair.isEmptyB()) { // loop until Stack B is empty
            System.out.print(stackPair.popB() + " "); // pop and print the value from Stack B
        }

    }
}

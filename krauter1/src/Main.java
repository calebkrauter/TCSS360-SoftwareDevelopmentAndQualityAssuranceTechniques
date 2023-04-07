import java.math.BigDecimal;

import static java.lang.String.*;

public class Main {

    // SHOULD all this be static?
    private static int rows = 10;
    private static int cols = 10;
    private static int thePercentInput = 50;
    private static int adjacencyCounter = 0;
    private static String[] A = new String[cols*rows];
    // bucket should be just big enough to fit all safe spaces.
    private static int[] bucket = new int[cols*rows];
    private static boolean leftEdge = false;
    private static boolean rightEdge = false;
    public static void main(String[] args) {
        fillBucketWithZeros();
        generateInput();
        System.out.println();
        generateOutput();

    }

    private static void generateOutput() {
        // TODO fix outputColCounter is 2, prob should be 1?
        int outputColCounter = 2;
        System.out.println();

        for (int i = 0; i < A.length; i++) {
            if (A[i] == ".") {
//                A[i] = String.valueOf(bucket[i]);
//                System.out.print(A[i]);
                findFirstAdjacent(i);
            } else {
                System.out.print(A[i]);
            }


            if ((outputColCounter - 1) % cols == 0) {
                System.out.println();
            }
            outputColCounter++;
        }
    }
    private static void findFirstAdjacent(int theCurrentIndex) {
        int locOfFirstAdjacent = (theCurrentIndex - rows - 1);
        int locOfSecondAdjacent = (theCurrentIndex - rows);
        int locOfThirdAdjacent = (theCurrentIndex - rows + 1);
        int locOfLeftAdjacent = (theCurrentIndex - 1);
        int locOfRightAdjacent = (theCurrentIndex + 1);
        int locOfSixthAdjacent = (theCurrentIndex + rows - 1);
        int locOfSeventhAdjacent = (theCurrentIndex + rows);
        int locOfEighthAdjacent = (theCurrentIndex + rows + 1);

        // Make sure the star is not on the left edge and update the correct adjacent space.
//        if (!onLeftEdge(theCurrentIndex)) {
//            // Make sure that it is actually updating the value in a given index from 0 to an incremental value.
//            bucket[locOfFirstAdjacent]+= 1;
//            A[locOfFirstAdjacent] = valueOf(bucket[locOfFirstAdjacent]);
//        } else {
//            A[locOfFirstAdjacent] = valueOf(bucket[locOfFirstAdjacent]);
//            setLeftEdge(false);
//        }
//
//        // Make sure the star is not on the right edge and update the correct adjacent space.
//        if (!onRightEdge(theCurrentIndex)) {
//            bucket[locOfSecondAdjacent] += 1;
//            A[locOfSecondAdjacent] = valueOf(bucket[locOfSecondAdjacent]);
//        } else {
//            A[locOfSecondAdjacent] = valueOf(bucket[locOfSecondAdjacent]);
//            setRightEdge(false);
//        }

        // TODO - Implement the following edge cases
        /*
        1. the star is on the left edge - the adjacent safe space may not include space 1, 4 or 6
        2. the star is on the right edge - the adjacent safe space may not include space 3, 5 or 8
        3. update a space directly above the star a total of -row spaces away [-1 in y direction for a 2D array]
        4. update a space directly below the star a total of row spaces away [+1 in y direction for a 2D array]
        5. update space 1 exactly -row - 1 spaces away [-1 in y direction and -1 in x for a 2D array]
        6. update space 3 exactly -row + 1 spaces away [-1 in y direction and +1 in x for a 2D array]
        7. update space 6 exactly row - 1 spaces away [+1 in y direction and -1 in x for a 2D array]
        8. update space 8 exactly row + 1 spaces away [+1 in y direction and +1 in x for a 2D array]
        9. update space 4 exactly - 1 space away
        10. update space 5 exactly 1 space away


        1 2 3
        4 * 5
        6 7 8
         */

//        System.out.print(A[theCurrentIndex]);
        System.out.print(A[locOfSecondAdjacent]);
    }


    private static boolean onLeftEdge(int theCurrentIndex) {
        if (theCurrentIndex % rows == 0) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean onRightEdge(int theCurrentIndex) {
        if (theCurrentIndex % rows == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void setLeftEdge(boolean theBoolean) {
        leftEdge = theBoolean;
    }
    public static void setRightEdge(boolean theBoolean) {
        rightEdge = theBoolean;
    }

    private static void fillBucketWithZeros() {
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = adjacencyCounter;
        }
    }
    // Should this be static?
    public static void generateInput() {
        // Input generator
        // Takes in user input of Dimensions n and m
        // Takes input of percentage/amount of mines



        int numOfMinesToPlace = (((BigDecimal.valueOf(cols).multiply(BigDecimal.valueOf(rows)).divide(BigDecimal.valueOf(100)))).multiply(BigDecimal.valueOf(thePercentInput))).intValue();

        int numOfSafeSpaces = (cols*rows - numOfMinesToPlace);
        int colCounter = 1;
        int amountOfMines = numOfMinesToPlace;
        for (int n = 0; n <= rows; n++) {
            for (int i = 0; i <= amountOfMines; i++) {

                if (numOfMinesToPlace > 0) {
                    if ((colCounter - 1) % cols == 0) {
                        System.out.println();
                    }
                    colCounter++;
                    A[i] = "*";
//                    System.out.print(i);
                    System.out.print(A[i]);
                    numOfMinesToPlace--;

                }
            }
        }
        for (int i = amountOfMines; i < numOfSafeSpaces*2; i++) {
            if ((colCounter - 1) % cols == 0) {
                System.out.println();
            }
            colCounter++;
            A[i] = ".";
//            System.out.print(i);
            System.out.print(A[i]);
        }
    }
}
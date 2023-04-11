import java.math.BigDecimal;

public class GenerateOutput {

    private int myRows = 10;
    private int myCols = 10;
    private int myVal = 0;
    private int thePercentInput = 50;
    private boolean isSafeSpace = false;
    private String[] A = new String[myCols*myRows];
    String[][] inArray = new String[myCols + 1][myRows + 1];


    // TODO - createHint method to consolidate test cases
    // TODO - idea to create a buffer around the mine field to keep test cases lower
    // Example of a mine and its adjacent safe spaces
    /*
     1 2 3
     4 * 5
     6 7 8
      */

    public GenerateOutput() {
        generateInput();
        System.out.println();
        buildArray();
        printArray();
    }

    private void buildArray() {
        int i = 0;
        for (int x = 0; x < myCols; x++) {
            for (int y = 0; y < myRows; y++) {
                inArray[x][y] = A[i];

                // Print mines
//                if (inArray[x][y] == "*") {
//                    System.out.print(inArray[x][y].toString());
//                }
                i++;
            }
        }
    }

    private void printArray() {

        for (int x = 0; x < myCols; x++) {
            System.out.println();
            for (int y = 0; y < myRows; y++) {
                if (x > 0 && y > 0 && x < myCols && y < myRows) {

                    if (isSafeSpace(x, y) && inArray[x][y-1] == "*") {
                        myVal++;
                        System.out.print(myVal);
                    }
                    myVal = 0;

                }
            }
        }
    }

    private void findAdjacentSpaces(int theX, int theY) {

        /*
        Test cases
            0 1 2 3
        0   * * * *
        1   . . . .
        2   . . . .
        3   . . . .

         */


//        if (theX > 0 && theX < myCols && theY > 0 && theY < myRows) {
            if (!isSafeSpace(theX, theY) && inArray[theX][theY] == "*") {
                myVal++;
                System.out.print(myVal);
            }
            myVal = 0;
//        }
    }

    private boolean isSafeSpace(int theX, int theY) {
        if (inArray[theX][theY] == ".") {
            setSafeSpace(true);
            return isSafeSpace;
        }
        return isSafeSpace;
    }

    private void setSafeSpace(boolean theValue) {
        isSafeSpace = theValue;
    }


//    public void generateOutput() {
//
//        int outputColCounter = 1;
//        System.out.println();
//
//        for (int i = 0; i < A.length; i++) {
//
//            // Formulas for adjacent mines
//            int locOfFirstAdjacent = (i - myRows - 1);
//            int locOfSecondAdjacent = (i - myRows);
//            int locOfThirdAdjacent = (i - myRows + 1);
//            int locOfLeftAdjacent = (i - 1);
//            int locOfRightAdjacent = (i + 1);
//            int locOfSixthAdjacent = (i + myRows - 1);
//            int locOfSeventhAdjacent = (i + myRows);
//            int locOfEighthAdjacent = (i + myRows + 1);
//
//            // Safe spaces test cases
//            if (A[i] == ".") {
//
//                if (A[locOfFirstAdjacent] == "*" && i % myCols != 0) {
//                    myVal++;
//                }
//                if (A[locOfSecondAdjacent] == "*") {
//                    myVal++;
//                }
//                if (A[locOfThirdAdjacent] == "*") { // do i need to use i % myCols != 0?
//                    myVal++;
//                }
//                if (A[locOfLeftAdjacent] == "*" && i % myCols != 0 && i % myCols != 1) {
//                    myVal++;
//                }
//                if (A[locOfRightAdjacent] == "*") {
//                    myVal++;
//                }
//                if (A[locOfSixthAdjacent] == "*") {
//                    myVal++;
//                }
//                if (A[locOfSeventhAdjacent] == "*") {
//                    myVal++;
//                }
//                if (A[locOfEighthAdjacent] == "*") {
//                    myVal++;
//                }
//
//                A[i] = String.valueOf(myVal);
//                System.out.print(A[i]);
////                findFirstAdjacent(i);
//            } else { // output mines
//                System.out.print(A[i]);
//            }
//            myVal = 0;
//
//            // Produce line after end of row
//            if ((outputColCounter) % myCols == 0) {
//                System.out.println();
//            }
//            outputColCounter++;
//        }
//    }

    public void generateInput() {
        // Input generator
        // Takes in user input of Dimensions n and m
        // Takes input of percentage/amount of mines

        int numOfMinesToPlace = (((BigDecimal.valueOf(myCols).multiply(BigDecimal.valueOf(myRows)).divide(BigDecimal.valueOf(100)))).multiply(BigDecimal.valueOf(thePercentInput))).intValue();
        int numOfSafeSpaces = (myCols*myRows - numOfMinesToPlace);
        int colCounter = 1;
        int amountOfMines = numOfMinesToPlace;

        for (int n = 0; n <= myRows; n++) {
            for (int i = 0; i <= amountOfMines; i++) {

                if (numOfMinesToPlace > 0) {
                    if ((colCounter - 1) % myCols == 0) {
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
            if ((colCounter - 1) % myCols == 0) {
                System.out.println();
            }
            colCounter++;
            A[i] = ".";
//            System.out.print(i);
            System.out.print(A[i]);
        }
    }
}

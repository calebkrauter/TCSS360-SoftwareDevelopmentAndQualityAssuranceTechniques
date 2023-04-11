import java.math.BigDecimal;
import java.util.Random;

public class GenerateOutput {

    private int myRows = 100;
    private int myCols = 100;
    private int myVal = 0;
    private int thePercentInput = 75;
    private boolean isSafeSpace = false;

    private String[] A = new String[myCols*myRows+1];
    String[][] inArray = new String[myCols+2][myRows+2];


    // TODO - createHint method to consolidate test cases
    // TODO - idea to create a buffer around the mine field to keep test cases lower


    public GenerateOutput() {
        generateInput();
        System.out.println();
        buildArray();
        printArray();
    }

    private void buildArray() {
        int i = 1;
        for (int y = 1; y < myCols+1; y++) {
            System.out.println();
            for (int x = 1; x < myRows+1; x++) {

                inArray[y][x] = A[i];
                System.out.print(inArray[y][x]);
//                System.out.println(inArray[x]);
                // Print mines
//                if (inArray[x][y] == "*") {
//                    System.out.print(inArray[x][y].toString());
//                }
                i++;
            }
        }
    }

    private void printArray() {
System.out.println();
        for (int y = 1; y < myCols+2; y++) {
            System.out.println();
            for (int x = 1; x < myRows+2; x++) {
                if (x > 0 && y > 0 && x < myCols+1 && y < myRows+1) {
                if (inArray[y][x] == ".") {
                    findAdjacentSpaces(y, x);
                } else if(inArray[y][x] == "*") {
                    System.out.print(inArray[y][x]);
                }

                }
            }
        }
    }

    private void findAdjacentSpaces(int theY, int theX) {

        /*
        Test cases
            0 1 2 3
        0   * * * *
        1   . . . .
        2   . . . .
        3   . . . .

         */

        // Example of a mine and its adjacent safe spaces
    /*
     1 2 3
     4 * 5
     6 7 8
      */
//        if (theY - 1 > 0 && theX - 1 > 0) // Might need to include bounds for bottom and far right.
        // Adjacent 1
        if (theY - 1 > 0 && theX - 1 > 0 && inArray[theY][theX] == "." && inArray[theY-1][theX-1] == "*") {
            myVal++;

        }

        // Adjacent 2
        if (theY - 1 > 0 && inArray[theY][theX] == "." && inArray[theY-1][theX] == "*") {
            myVal++;
        }

        // Adjacent 3
        if (theY - 1 > 0 && theX + 1 < myCols + 1 && inArray[theY][theX] == "." && inArray[theY-1][theX+1] == "*") {
            myVal++;
        }

        // Adjacent 4
        if (theX - 1 > 0 && inArray[theY][theX] == "." && inArray[theY][theX-1] == "*") {
            myVal++;
        }

        // Adjacent 5
        if (theX + 1 < myCols + 1 && inArray[theY][theX] == "." && inArray[theY][theX+1] == "*") {
            myVal++;
        }

        // Adjacent 6
        if (theY + 1 < myRows + 1 && theX - 1 > 0 && inArray[theY][theX] == "." && inArray[theY+1][theX-1] == "*") {
            myVal++;
        }

        // Adjacent 7
        if (theY + 1 < myRows + 1 && inArray[theY][theX] == "." && inArray[theY+1][theX] == "*") {
            myVal++;
        }

        // Adjacent 8
        if (theY + 1 < myRows + 1 && theX + 1 < myCols + 1 && inArray[theY][theX] == "." && inArray[theY+1][theX+1] == "*") {
            myVal++;
        }

        if (inArray[theY][theX] == ".") {
            inArray[theY][theX] = String.valueOf(myVal);
            System.out.print(inArray[theY][theX]);
        }
        myVal = 0;
    }

    public void generateInput() {
        // Input generator
        // Takes in user input of Dimensions n and m
        // Takes input of percentage/amount of mines
        A[0] = "0";
        int numOfMinesToPlace = (((BigDecimal.valueOf(myCols).multiply(BigDecimal.valueOf(myRows)).divide(BigDecimal.valueOf(100)))).multiply(BigDecimal.valueOf(thePercentInput))).intValue();
        if (thePercentInput == 0) {
            numOfMinesToPlace = 0;
        } else {
            numOfMinesToPlace = numOfMinesToPlace + 1;
        }
        int numOfSafeSpaces = (myCols*myRows - numOfMinesToPlace);
        int colCounter = 1;
        int amountOfMines = numOfMinesToPlace;
        Random randomIndex = new Random();

        // Place Mines
        for (int i = 1; i < amountOfMines; i++) {
            int currentRandomVal = randomIndex.nextInt(1, A.length);

            while (A[currentRandomVal] == "*") {
                // If mine in space recalculate index
                currentRandomVal = randomIndex.nextInt(1, A.length);
            }
            if (A[currentRandomVal] != "*") {
                A[currentRandomVal] = "*";
            }
        }
        // Place safe spaces
        for (int k = 1; k < A.length; k++) {
            if (A[k] == null) {
                A[k] = ".";
            }
        }
        // Print out array
        for (int j = 1; j < A.length; j++) {
            if ((colCounter - 1) % myCols == 0) {
                System.out.println();
            }
            colCounter++;
            System.out.print(A[j]);

        }

    }
}

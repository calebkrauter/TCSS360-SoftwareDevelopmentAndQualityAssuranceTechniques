import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Random;
import java.util.Scanner;

public class ProduceInputFields {
    // TODO support input of 1x1
    private int myRows = 1;
    private int myCols = 1;
    private int myVal = 0;
    private int myPercentInput = 5;
    private String[] A;

    public ProduceInputFields() throws IOException {
        readInput();
        while (getRows() != 0 && getCols() != 0) {
            A = new String[getCols()*getRows()+1];
            generateInputField();
            System.out.println();
            readInput();

        }




    }
    private void generateInputField() throws IOException {
        // Input generator
        // Takes in user input of Dimensions n and m
        // Takes input of percentage/amount of mines
        A[0] = "0";
        int numOfMinesToPlace = (((BigDecimal.valueOf(getCols()).multiply(BigDecimal.valueOf(getRows())).divide(BigDecimal.valueOf(100)))).multiply(BigDecimal.valueOf(getPercentOfMines()))).intValue();
        if (getPercentOfMines() == 0) {
            numOfMinesToPlace = 0;
        } else {
            numOfMinesToPlace = numOfMinesToPlace + 1;
        }
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
            if (colCounter > 0 && (colCounter - 1) % getCols() == 0) {
                System.out.println();
                outputToTestFile("\n");
            }
            colCounter++;
            System.out.print(A[j]);
            outputToTestFile(A[j]);

        }
    }

    private void outputToTestFile(String theString) throws IOException {
        File testFile = new File("minesweeper_input.txt.");

        PrintWriter printWriter = new PrintWriter(new FileWriter(testFile, true));
        printWriter.append(theString);
        printWriter.close();
    }

    private void readInput() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter rows and columns and percent of mines, " +
                "like 5 5 50, 0 0 to exit.");
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int minePercentage = scanner.nextInt();

        setRows(rows);
        setCols(cols);
        setPercentOfMines(minePercentage);

        outputToTestFile("\n");
        outputToTestFile(String.valueOf(getRows()));
        outputToTestFile(" ");
        outputToTestFile(String.valueOf(getCols()));

        if (rows == 0 && cols == 0) {
            System.exit(0);
        }
    }

    private void setRows(int theRows) {
        myRows = theRows;
    }
    private void setCols(int theCols) {
        myCols = theCols;
    }

    private void setPercentOfMines(int thePercentInput) {
        myPercentInput = thePercentInput;
    }

    private int getRows() {
        return myRows;
    }

    private int getCols() {
        return myCols;
    }

    private int getPercentOfMines() {
        return myPercentInput;
    }
}

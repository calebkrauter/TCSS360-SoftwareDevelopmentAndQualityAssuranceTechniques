import java.util.Scanner;

public class GenerateOutput {
    private int myRows = 10;
    private int myCols = 10;
    private int myVal = 0;
    private char[][] inArray;

    public GenerateOutput() {
        getSomeInput();
    }

    private void getSomeInput() {
        Scanner scanner = new Scanner(System.in);
        int countFields = 0;
        setRows(scanner.nextInt());
        setCols(scanner.nextInt());

        while (getRows() != 0 && getCols() != 0) {
            scanner.nextLine();

            inArray = new char[getCols()+2][getRows()+2];

            for (int y = 1; y < getRows()+1; y++) {
                String value = scanner.nextLine();
                for (int x = 1; x < getCols()+1; x++) {
                    inArray[y][x] = value.charAt(x-1);

                }
            }
            countFields++;
            System.out.println("My Field #" + countFields + ":");
            printArray();

            if (scanner.hasNextInt()) {
                setRows(scanner.nextInt());
                setCols(scanner.nextInt());
            }
        }
    }

    private void setRows(int theRows) {
        myRows = theRows;
    }
    private void setCols(int theCols) {
        myCols = theCols;
    }
    private int getRows() {
        return myRows;
    }
    private int getCols() {
        return myCols;
    }

    private void printArray() {
        for (int y = 1; y < getCols()+1; y++) {
            for (int x = 1; x < getRows()+1; x++) {
                if (x > 0 && y > 0 && x < getCols()+1 && y < getRows()+1) {
                if (inArray[y][x] == '.') {
                    findAdjacentSpaces(y, x);
                } else if(inArray[y][x] == '*') {
                    System.out.print(inArray[y][x]);
                }

                }
            }
            System.out.println();
        }
    }

    private void findAdjacentSpaces(int theY, int theX) {

        // Adjacent 1
        if (theY - 1 > 0 && theX - 1 > 0 && inArray[theY][theX] == '.' && inArray[theY-1][theX-1] == '*') {
            myVal++;
        }
        // Adjacent 2
        if (theY - 1 > 0 && inArray[theY][theX] == '.' && inArray[theY-1][theX] == '*') {
            myVal++;
        }

        // Adjacent 3
        if (theY - 1 > 0 && theX + 1 < myCols + 1 && inArray[theY][theX] == '.' && inArray[theY-1][theX+1] == '*') {
            myVal++;
        }

        // Adjacent 4
        if (theX - 1 > 0 && inArray[theY][theX] == '.' && inArray[theY][theX-1] == '*') {
            myVal++;
        }

        // Adjacent 5
        if (theX + 1 < myCols + 1 && inArray[theY][theX] == '.' && inArray[theY][theX+1] == '*') {
            myVal++;
        }

        // Adjacent 6
        if (theY + 1 < myRows + 1 && theX - 1 > 0 && inArray[theY][theX] == '.' && inArray[theY+1][theX-1] == '*') {
            myVal++;
        }

        // Adjacent 7
        if (theY + 1 < myRows + 1 && inArray[theY][theX] == '.' && inArray[theY+1][theX] == '*') {
            myVal++;
        }

        // Adjacent 8
        if (theY + 1 < myRows + 1 && theX + 1 < myCols + 1 && inArray[theY][theX] == '.' && inArray[theY+1][theX+1] == '*') {
            myVal++;
        }

        if (inArray[theY][theX] == '.') {
            inArray[theY][theX] = (char) (myVal + 48);
            System.out.print(inArray[theY][theX]);
        }
        myVal = 0;
    }
}

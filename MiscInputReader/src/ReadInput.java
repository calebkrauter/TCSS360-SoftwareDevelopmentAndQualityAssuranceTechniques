import java.util.Scanner;

public class ReadInput {
    private int myRows = 1;
    private int myCols = 1;
    public ReadInput() {
        setRows(1);
        setCols(1);
//        while (getRows() != 0 && getCols() != 0) {
            getSomeInput();
//        }

        while (getRows() != 0 && getCols() != 0) {
            getSomeInput();

        }
        getSomeInput();
        output();
    }
    private void output() {
        for (String val : A) {
            System.out.println(val);
        }
    }
    String[] A = new String[9];
    char[] characterArray;

    private void getSomeInput() {
        Scanner scanner = new Scanner(System.in);
        int rows = 1;
        int cols = 1;
        if (scanner.hasNextLine() && scanner.hasNextInt()) {
            rows = scanner.nextInt();
            cols = scanner.nextInt();
        }

        setRows(rows);
        setCols(cols);
        if (rows == 0 && cols == 0) {
            System.exit(0);
        }
        String currentString;
        while (scanner.hasNext()) {
            currentString = scanner.next();

            characterArray = currentString.toString().toCharArray();
            int i = 1;
            for (char character: characterArray) {
                A[i] = String.valueOf(character);
//                System.out.println(A[i]);
                i++;

            }
        }

        for (String val : A) {
            System.out.println(val);
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
}

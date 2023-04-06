import java.awt.*;
import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {
    private static int rows = 5;
    private static int cols = 5;
    public static void main(String[] args) {


        // Input generator
        // Takes in user input of Dimensions n and m
        // Takes input of percentage/amount of mines

        int thePercentInput = 75;

        int amountOfMines = (((BigDecimal.valueOf(cols).multiply(BigDecimal.valueOf(rows)).divide(BigDecimal.valueOf(100)))).multiply(BigDecimal.valueOf(thePercentInput))).intValue();
        System.out.println(amountOfMines);

        int numOfSafeSpaces = (cols*rows - amountOfMines);
        int colCounter = 1;

        for (int n = 0; n <= rows; n++) {
            for (int i = amountOfMines; i >= 0; i--) {

                while (amountOfMines > 0) {
                    if ((colCounter - 1) % cols == 0) {
                        System.out.println();
                    }
                    colCounter++;
                    System.out.print('*');
                    amountOfMines--;
                }
            }
        }
        for (int i = numOfSafeSpaces; i > 0; i--) {
            if ((colCounter - 1) % cols == 0) {
                System.out.println();
            }
            colCounter++;
            System.out.print('.');
        }

    }
}
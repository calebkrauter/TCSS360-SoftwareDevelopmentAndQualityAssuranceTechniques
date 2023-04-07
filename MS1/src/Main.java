import java.awt.*;
import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {


        // Input generator
        // Takes in user input of Dimensions n and m
        // Takes input of percentage/amount of mines
        int val = 2;
        int[] bucket = new int[]{1,2,3,4};
        String[] A = new String[]{".", ".", ".", ".", ".",};

        bucket[1] += 1;
        A[1] = String.valueOf(bucket[1]);
        System.out.println(A[0] + " " + A[1]);

//        int rows = 5;
//        int cols = 5;
//        int thePercentInput = 75;
//
//        int amountOfMines = (((BigDecimal.valueOf(cols).multiply(BigDecimal.valueOf(rows)).divide(BigDecimal.valueOf(100)))).multiply(BigDecimal.valueOf(thePercentInput))).intValue();
//        System.out.println(amountOfMines);
//
//        int numOfSafeSpaces = (cols*rows - amountOfMines);
//        int colCounter = 1;
//
//        for (int n = 0; n <= rows; n++) {
//            for (int i = amountOfMines; i >= 0; i--) {
//
//                while (amountOfMines > 0) {
//                    if ((colCounter - 1) % cols == 0) {
//                        System.out.println();
//                    }
//                    colCounter++;
//                    System.out.print('*');
//                    amountOfMines--;
//                }
//            }
//        }
//        for (int i = numOfSafeSpaces; i > 0; i--) {
//            if ((colCounter - 1) % cols == 0) {
//                System.out.println();
//            }
//            colCounter++;
//            System.out.print('.');
//        }

    }
}
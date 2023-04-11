import java.util.Random;

public class FB {

    public void doFB() {
        String[] inArray = new String[]{".", ".", ".", ".", ".", ".", ".", ".", ".", ".",};

        Random randomIndex = new Random();
        int numOfMines = 5;

        // Place Mines
        for (int i = 0; i < numOfMines; i++) {
            int currentRandomVal = randomIndex.nextInt(0, inArray.length - 1);

            while (inArray[currentRandomVal] == "*") {
                // If mine in space recalculate index
                currentRandomVal = randomIndex.nextInt(0, inArray.length - 1);
            }
            if (inArray[currentRandomVal] != "*") {
                inArray[currentRandomVal] = "*";
            }
        }
        // Place safe spaces
        for (int k = numOfMines; k < inArray.length; k++) {
            if (inArray[k] != "*") {
                inArray[k] = ".";
            }
        }
        // Print out array
        for (int j = 0; j < inArray.length; j++) {
            System.out.print(inArray[j]);

        }
    }

}

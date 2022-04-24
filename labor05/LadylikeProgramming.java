/**
 * @name LadylikeProgramming
 * @package labor05
 * @file LadylikeProgramming.java
 * @version 1.0
 * @authors Veronica Zylla, Sören Zacharias, Alexander Nachtigal
 * @email veronica.zylla@student.fh-kiel.de, soeren.zacharias@student.fh-kiel.de, alexander.nachtigal@student.fh-kiel.de
 * @description draws a 8x8 board filled with cards for a lady (short 'D') or spaces.
 */

package labor05;
public class LadylikeProgramming {

    /**
     * The start of the programm where an array is initialized and given to the next method.
     * @param args The command line arguments, which are not needed for this program.
     */
    public static void main(final String[] args) {
        /*
         * the array "drawBoardArr" will be used by all other methods for creating a draw board.
         */
        final int[] drawBoardArr = {0, 0, 0, 0, 0, 0, 0, 0};
        givenDrawBoardArr(drawBoardArr, 0);
    }

    /**
     * Fills the array drawBoardArr with numbers and returns true or false depending on the index.
     * <p>
     * The method is logically divided into 2 parts.
     * <p>
     * In the first part, the method checks, if the given param is 8.
     * If it is, the program jumps to the void method drawBoard in line 99.
     * and leaves the method that is in place by returning true.
     * <p>
     * In the second part, a for loop is run through.
     * For every iteration, the index of the drawBoardArr gets the value of the counting variable i assigned.
     * After that, the boolean method drawBoardArr with the params drawBoardArr and index is called.
     * If the called boolean method returns true, the for loop jumps to the next iteration.
     * If the called boolean method returns false, the method in place calls itself
     * with an incremented index.
     * @param drawBoardArr the referenced array from the main method.
     * @param index this variable is essential for the loop in the method. It is responsible for how often the method is run.
     * @return false as long as index is not 8, true if index is 8.
     */
    public static boolean givenDrawBoardArr(final int[] drawBoardArr, final int index) {
        if (index == 8) {
            drawBoard(drawBoardArr); // this method call goes to line 99.
            return true; // leaves the method givenDrawBoardArr completely.
        }
        for (int i = 0; i < 8; i++) {
            drawBoardArr[index] = i; // at the end of the loop, drawBoardArr[7] = { 0, 4, 7, 5, 2, 6, 1, 3}
            if (drawBoard(drawBoardArr, index)) { // jumps to line 70,  if true is returned, the next line will be executed.
                continue;
            }
            final boolean loop = givenDrawBoardArr(drawBoardArr, index + 1); // returns to line 45 but increments the index.
            if (loop) { // loop continues as long as the index is smaller than 8.
                return true;
            }
        }
        return false;
    }

    /**
     * boolean method which goes through various for loops
     * <p>
     * @param drawBoardArr the manipulated array that was handed overhanging by above method  in line 47.
     * @param index handed over by line 47.
     * @return true, if the element of an array fulfills at least one condition in the for loops. else false.
     */
    public static boolean drawBoard(final int[] drawBoardArr, final int index) {
        for (int i = 0; i < index; i++) {
            if (drawBoardArr[i] == drawBoardArr[index]) {
                return true; // returns true to the line 47.
            }
        }
        for (int j = index - 1, b = drawBoardArr[index] - 1; j >= 0; j--, b--) {
            if (drawBoardArr[j] == b) {
                return true; // returns true to the line 47.
            }
        }
        for (int k = index - 1, a = drawBoardArr[index] + 1; k >= 0; k--, a++) {
            if (drawBoardArr[k] == a) {
                return true; // returns true to the line 47.
            }
        }
        return false; // if nothing of the above is true, false will be returned to the line 47.
    }

    /**
     * This is the method that actually creates the draw board for the ladylike game.
     * <p>
     * It contains a nested for loop with 64 iterations.
     * <p>
     * The first for loop executes the second for loop AND prints a new line starting with a "|"
     * The second for loop compares the element from the array drawBoardArr with the counting variable i.
     * If they are the same a "d" becomes printed. Else a space.
     * @param drawBoardArr // final manipulated array for the final method :)
     */
    public static void drawBoard(final int[] drawBoardArr) {
        for (int i = 0; i < 8; i++) { // 64 iterations
            for (int j = 0; j < 8; j++) {
                System.out.print("|" + ((i == drawBoardArr[j]) ? 'D' : ' '));
                // checks if i is the same number as in the element of the array. if it is, a "D" is printed.  else a space.
                // also prints 8 times "|" in a row.
            }
            System.out.println("|"); // creates 8 rows for the draw board
        }
    }
}

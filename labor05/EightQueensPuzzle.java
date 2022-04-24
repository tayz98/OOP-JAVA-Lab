/**
 * @name EightQueensPuzzle
 * @package labor05
 * @file EightQueensPuzzle.java
 * @version 1.0
 * @authors Veronica Zylla, Sören Zacharias, Alexander Nachtigal
 * @email veronica.zylla@student.fh-kiel.de, soeren.zacharias@student.fh-kiel.de, alexander.nachtigal@student.fh-kiel.de
 * @description program that generates the first solution for putting n (in this case 8) queens on a n*n chess field (8x8 here), so that no two queens threaten each other.
 */

package labor05;
public class EightQueensPuzzle {

    /**
     * The start of the program where an array is initialized and given to the next method.
     * @param args The command line arguments, which are not needed for this program.
     */
    public static void main(final String[] args) {
        /**
         * position of queens for every row (for each row there can only be one queen) - not calculated.
         * in this case, we will calculate the first solution for n=8 queens. Works for different n as well.
         */
        final int[] queensArr = {0, 0, 0, 0, 0, 0, 0, 0};
        calculatePosition(queensArr, 0);
    }

    /**
     * This method calculates the correct position for every queen in every row on the chess field.
     * <p>
     * This method walks through all lines (by calling itself recursive) of the field and calculates the correct position for every queen in every row so that no two queens threaten each other.
     * It calculates the "correct" path through the field until it reaches the end (length of the array).
     * If the method doesn't find a solution for the next row, it takes a step back and increases the position of the row before.
     * @param queensArr the recent array with the positions of the queens
     * @param row the recent row that we are calculating the position for
     * @return true if the end has reached, otherwise it returns false
     */
    public static boolean calculatePosition(final int[] queensArr, final int row) {
        if (row == queensArr.length) { // prints the board if the end has reached and all positions are calculated
            drawBoard(queensArr);
            return true;
        }
        // this loop calculates the position for the recent row.
        for (int i = 0; i < queensArr.length; i++) {
            queensArr[row] = i;
            if (isInvalidPosition(queensArr, row)) { // check if the actual position is invalid
                continue; // if the position is invalid, move on with the next position in the for-loop
            }
            if (calculatePosition(queensArr, row + 1)) { // calculates the position for the next row
                return true;
            }
        }
        return false;
    }

    /**
     * this method checks if a new queen gets threaten by another placed queen
     * <p>
     * @param queensArr the calculated array for the queens positions
     * @param row the recent row that we are calculating the position for
     * @return true, if the position is not a valid position for placing a new queen. Otherwise false.
     */
    public static boolean isInvalidPosition(final int[] queensArr, final int row) {
        for (int i = 0; i < row; i++) {
            if (queensArr[i] == queensArr[row]) { // check if the recent queen would be placed at the same column as one before
                return true;
            }
        }
        // these loops check if a placed queen gets threaten by another queen diagonally
        for (int j = row - 1, a = queensArr[row] - 1; j >= 0; j--, a--) {
            if (queensArr[j] == a) {
                return true;
            }
        }
        for (int k = row - 1, a = queensArr[row] + 1; k >= 0; k--, a++) {
            if (queensArr[k] == a) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method draws the n*n chess board with the placed queens.
     * <p>
     * This method prints every row and column of the chess board on the console (with borders "|").
     * If a queen is positioned on a certain index, the method will print a 'D'
     * @param queensArr calculated array for the positions of the queens
     */
    public static void drawBoard(final int[] queensArr) {
        for (int i = 0; i < queensArr.length; i++) {
            for (int j = 0; j < queensArr.length; j++) {
                System.out.print("|" + ((i == queensArr[j]) ? 'D' : ' '));
                // checks if i is the same number as the value of the element of the array at position i. If it is, a "D" is printed, otherwise a space.
                // also prints "|" n times in a row.
            }
            System.out.println("|"); // creates the n+1th "|" in each row
        }
    }
}

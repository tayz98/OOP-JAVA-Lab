package labor05;


public class X {
    public static void main(final String[] args) {
        final int[] drawBoardArr = {0, 0, 0, 0, 0, 0, 0, 0};
        givenDrawBoardArr(drawBoardArr, 0);
    }
    public static boolean givenDrawBoardArr(final int[] drawBoardArr, final int index) {
        if (index == 8) {
            drawBoard(drawBoardArr); // this method call goes to line 44
            return true; // leaves the method givenDrawBoardArr completely.
        }
        for (int i = 0; i < 8; i++) {
            drawBoardArr[index] = i; // at the end of the loop, drawBoardArr[7] = { 0, 4, 7, 5, 2, 6, 1, 3}
            if (drawBoard(drawBoardArr, index)) { // line 26,  if true is returned, the next line will be executed.
                continue;
            }
            final boolean loop = givenDrawBoardArr(drawBoardArr, index + 1); // returns to line 9 but increases the index by one.
            if (loop) { // loop continues as long as the index is smaller than 8.
                return true;
            }
        }
        return false;
    }
    public static boolean drawBoard(final int[] drawBoardArr, final int index) {
        for (int i = 0; i < index; i++) {
            if (drawBoardArr[i] == drawBoardArr[index]) {
                return true; // returns true to the line 16
            }
        }
        for (int j = index - 1, b = drawBoardArr[index] - 1; j >= 0; j--, b--) {
            if (drawBoardArr[j] == b) {
                return true; // returns true to the line 16
            }
        }
        for (int k = index - 1, a = drawBoardArr[index] + 1; k >= 0; k--, a++) {
            if (drawBoardArr[k] == a) {
                return true; // returns true to the line 16
            }
        }
        return false; // if nothing of the above is true, false will be returned to the line 16.
    }
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

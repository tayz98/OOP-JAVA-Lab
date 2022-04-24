package labor05;

public class X {
    public static boolean drawBoard(final int[] drawBoardArr, final int givenInteger) {
        for (int i = 0; i < givenInteger; i++) {
          if (drawBoardArr[i] == drawBoardArr[givenInteger]) {
            return true;
          }
        }
        for (int j = givenInteger - 1, b = drawBoardArr[givenInteger] - 1; j >= 0; j--, b--) {
          if (drawBoardArr[j] == b) {
            return true;
          }
        }
        for (int k = givenInteger - 1, a = drawBoardArr[givenInteger] + 1; k >= 0; k--, a++) {
          if (drawBoardArr[k] == a) {
            return true;
          }
        }
        return false;
    }

    public static boolean givenDrawBoardArr(final int[] drawBoardArr, final int givenInteger) {
        if (givenInteger == 8) {
            drawBoard(drawBoardArr);
            return true;
        }
        for (int i = 0; i < 8; i++) {
            drawBoardArr[givenInteger] = i;
            if (drawBoard(drawBoardArr, givenInteger)) {
              continue;
          }
            final boolean loop = givenDrawBoardArr(drawBoardArr, givenInteger + 1);
            if (loop) {
              return true;
            }
        }
        return false;
    }

    public static void drawBoard(final int[] drawBoardArr) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
              System.out.print("|" + ((i == drawBoardArr[j]) ? 'D' : ' '));
            }
            System.out.println("|");
        }
    }

    public static void main(final String[] args) {
        final int[] drawBoardArr = {0, 0, 0, 0, 0, 0, 0, 0};
        givenDrawBoardArr(drawBoardArr, 0);
    }
}

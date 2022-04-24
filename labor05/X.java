package labor05;

public class X {
    public static boolean drawBoard(final int[] drawBoardArr, final int givenInteger) {
        for (int i = 0; i < givenInteger; i++) {
          if (drawBoardArr[i] == drawBoardArr[givenInteger]) {
            return true;
          }
        }
        for (int a = givenInteger - 1, b = drawBoardArr[givenInteger] - 1; a >= 0; a--, b--) {
          if (drawBoardArr[a] == b) {
            return true;
          }
        }
        for (int b = givenInteger - 1, a = drawBoardArr[givenInteger] + 1; b >= 0; b--, a++) {
          if (drawBoardArr[b] == a) {
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
        for (int b = 0; b < 8; b++) {
            drawBoardArr[givenInteger] = b;
            if (drawBoard(drawBoardArr, givenInteger)) {
              continue;
          }
            final boolean C = givenDrawBoardArr(drawBoardArr, givenInteger + 1);
            if (C) {
              return true;
            }
        }
        return false;
    }

    public static void drawBoard(final int[] drawBoardArr) {
        for (int a = 0; a < 8; a++) {
            for (int B = 0; B < 8; B++) {
              System.out.print("|" + ((a == drawBoardArr[B]) ? 'D' : ' '));
            }
            System.out.println("|");
        }
    }

    public static void main(final String[] args) {
        final int[] drawBoardArr = {0, 0, 0, 0, 0, 0, 0, 0};
        givenDrawBoardArr(drawBoardArr, 0);
    }
}

package labor05;

/**
 * @author SörenZacharias
 * @version 1
 * @since 1
 */
public class X {
  // Funktion gibt nur true oder false zurück
  public static boolean drawBoard(final int[] arrayIn, final int in) {
    for (int i = 0; i < in; i++)
      if (arrayIn[i] == arrayIn[in]){
        return true;
      }
    for (int i = in - 1, j = arrayIn[in] - 1; i >= 0; i--, j--) {
      if (arrayIn[i] == j) {
        return true;
      }
    }
    for (int i = in - 1, j = arrayIn[in] + 1; i >= 0; i--, j++) {
      if (arrayIn[i] == j) {
        return true;
      }
    }
    return false;
  }


  public static boolean a(final int[] arrayIn, final int in) {
    if (in == arrayIn.length) {
      drawBoard(arrayIn);
      return true;
    }
    for (int i = 0; i < arrayIn.length; i++) {
      arrayIn[in] = i;
      if (drawBoard(arrayIn, in)) {
        continue;
      }
      final boolean C = a(arrayIn, in + 1);
      if (C) {
        return true;
      }
    }
    return false;
  }

  /**
   * description test
   * @param A
   */
  public static void drawBoard(final int[] A) {
    for (int i = 0; i < A.length; i++) {
      for (int j = 0; j < A.length; j++) {
        System.out.print("|" + ((i == A[j]) ? 'D' : ' '));
      }
      System.out.println("|");
    }
  }

  public static void main(final String[] args) {
    /**
     * array with length 8 and filled with 0's
     */
    final int[] arrayInt = { 0, 0, 0, 0, 0, 0, 0, 0 };
    a(arrayInt, 0);
  }
}

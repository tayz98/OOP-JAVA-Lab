public class X {
  public static boolean drawBoard(final int[] A, final int B) {
    for (int i = 0; i < B; i++)
      if (A[i] == A[B])
        return true;
    for (int i = B - 1, j = A[B] - 1; i >= 0; i--, j--)
      if (A[i] == j)
        return true;
    for (int i = B - 1, j = A[B] + 1; i >= 0; i--, j++)
      if (A[i] == j)
        return true;
    return false;
  }

  public static boolean a(final int[] B, final int A) {
    if (A == 8) {
      drawBoard(B);
      return true;
    }
    for (int i = 0; i < 8; i++) {
      B[A] = i;
      if (drawBoard(B, A))
        continue;
      final boolean C = a(B, A + 1);
      if (C)
        return true;
    }
    return false;
  }

  public static void drawBoard(final int[] A) {
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++)
        System.out.print("|" + ((i == A[j]) ? 'D' : ' '));
      System.out.println("|");
    }
  }

  public static void main(final String[] args) {
    final int[] A = { 0, 0, 0, 0, 0, 0, 0, 0 };
    a(A, 0);
  }
}

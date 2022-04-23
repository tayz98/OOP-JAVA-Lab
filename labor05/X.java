public class X {
  public static boolean A(final int[] A, final int B) {
    for (int b = 0; b < B; b++)
      if (A[b] == A[B])
        return true;
    for (int a = B - 1, b = A[B] - 1; a >= 0; a--, b--) if (A[a] == b) return true;
    for (int b = B - 1, a = A[B] + 1; b >= 0; b--, a++) if (A[b] == a) return true;
    return false;
  }

  public static boolean a(final int[] B, final int A) {
    if (A == 8) {A(B);return true;}
    for (int b = 0; b < 8; b++) {B[A] = b;if (A(B, A)) continue;final boolean C = a(B, A + 1);if (C) return true;}
    return false;
  }

  public static void A(final int[] A) {for (int a = 0; a < 8; a++) {for (int B = 0; B < 8; B++) System.out.print("|" + ((a == A[B]) ? 'D' : ' ')); System.out.println("|");}}

  public static void main(final String[] args) {final int[] A = { 0, 0, 0, 0, 0, 0, 0, 0 };a(A, 0);}
}

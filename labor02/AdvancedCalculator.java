package labor02;


public class AdvancedCalculator {

    public static void main(String[] args) {
        // Converting the strings into integer variables
        // the programm terminates, if the given input is not valid.
        try {
            int n1 = Integer.parseInt(args[0]);
            int n2 = Integer.parseInt(args[2]);
        } catch (NumberFormatException exception2) {
            System.err.println("The input you have given was either no number or a too large number ");
            System.out.println("Please restart the program with correct arguments.");
            int n1 = 0, n2 = 0;                              // still need to re-initialize variables n1 and n2 for avoiding compiler err. maybe we find a better solution later on.
            System.exit(42); // random exit code
        }


        // check for arithmetic exceptions

                                                            /* the following switch case is duplicated code from the Calculator.java file. Maybe use a method to shorten the code?
                                                               for example "calculator.method(n1, n2)
                                                               the problem is, the method will be unknown to the terminal if you only run the AdvancedCalculator.java file */

        int n1 = Integer.parseInt(args[0]);
        int n2 = Integer.parseInt(args[2]);
        // Calculation and its output.
        switch (args[1]) {
            case "+" -> System.out.println(n1 + n2);
            case "-" -> System.out.println(n1 - n2);
            case "/" -> {
                double result = ((double) n1) / n2;
                // if it is an even result, an int value is output
                if (result % 1 == 0) {
                    System.out.println((int) result);
                    // dividing by 0 is not allowed, therefore we need to check it.
                } else if (n2 == 0) {
                    System.err.println("You can't divide by 0");
                }
                // otherwise, a double result with decimal place is output
                else {
                    System.out.println(result);
                }
            }
            case "*" -> System.out.println(n1 * n2);
            default -> System.out.println(0);
        }
    }
}
/* Task:
Könnt ihr euer Programm für die folgenden Aufgaben erweitern?
    • Verhindert mögliche Fehler und gebt einen Hilfetext in Fehlerfall aus. -> use try and catch exceptions
    • Zusätzlich zu Integer-Zahlen sollen auch Fließkomma Zahlen (Double) eingegeben
      werden können.
    • Eine beliebige Anzahl von Parametern kann angeben werden. -> use arrays
        o Beachtet dabei mögliche Fehlerfälle. -> use try and catch exceptions
        o Beachtet die Punkt-vor-Strich Regel (bei mehreren Parametern).
        o Ergänzt Klammern als mögliche Eingabe.
*/
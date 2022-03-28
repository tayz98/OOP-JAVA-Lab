package labor02;


public class AdvancedCalculator {

    public static void main(String[] args) {
        // Converting the strings into integer variables
        int n1 = Integer.parseInt(args[0]);
        int n2 = Integer.parseInt(args[2]);

        // check for arithmetic exceptions
        try {
            // the following switch case is copied from the Calculator.java file. Maybe use a method to shorten the code?
            switch (args[1]) {
                case "+" -> System.out.println(n1 + n2);
                case "-" -> System.out.println(n1 - n2);
                case "/" -> {
                    double result = ((double) n1) / n2;
                    // if it is an even result, an int value is output
                    if (result % 1 == 0) {
                        System.out.println((int) result);
                    }
                    // otherwise, a double result with decimal place is output
                    else {
                        System.out.println(result);
                    }
                }
                case "*" -> System.out.println(n1 * n2);
                default -> System.out.println(0); // Calculation and output of the values
            }
        } catch (ArithmeticException exception) {
            System.out.println("You can't divide by 0"); // This line is never executed, explanation here: https://www.geeksforgeeks.org/g-fact-33-infinity-or-exception/
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
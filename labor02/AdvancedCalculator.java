package labor02;

import java.text.DecimalFormat;

public class AdvancedCalculator {

    // method for removing the ".0" from a double
    public static String fmt(double d) {                    // credits for this fantastic method go to this guy from stackoverflow: https://stackoverflow.com/a/25834067/10859572
        if (d == (int) d) {
            return String.format("%d", (int) d);
        } else {
            return String.format("%s", d);
        }
    }

    public static void main(String[] args) {

        double n1 = 0, n2 = 0; // needs to be initialized before the try catch block. otherwise, the compiler will output an error.


        // converts the entered arguments/strings to double variables.
        // the programm terminates, if the given input is invalid.
        try {
            n1 = Double.parseDouble(args[0]);
            n2 = Double.parseDouble(args[2]);
        } catch (NumberFormatException exception2) {
            System.err.println("The input you have given was either no number or a too large number ");
            System.out.println("Please restart the program with correct arguments.");
            System.exit(42); // random exit code
        }

        // Outputs the calculation.
        switch (args[1]) {
            case "+" -> System.out.println(fmt(n1 + n2));
            case "-" -> System.out.println(fmt(n1 - n2));
            case "/" -> {
                if (n2 == 0) {
                    System.err.println("You can't divide by 0");
                } else {
                    System.out.println(fmt(n1 / n2));
                }
            }
            case "*" -> System.out.println(fmt(n1 * n2));
            default -> System.out.println(0);
        }

        }
    }
// test
/* Task:
Könnt ihr euer Programm für die folgenden Aufgaben erweitern?
    • Verhindert mögliche Fehler und gebt einen Hilfetext in Fehlerfall aus. -> should be done [Alex]
    • Zusätzlich zu Integer-Zahlen sollen auch Fließkomma Zahlen (Double) eingegeben -> should be done [Alex]
      werden können.
    • Eine beliebige Anzahl von Parametern kann angeben werden. -> in progress
        o Beachtet dabei mögliche Fehlerfälle. -> use try and catch exceptions
        o Beachtet die Punkt-vor-Strich Regel (bei mehreren Parametern).
        o Ergänzt Klammern als mögliche Eingabe.
*/
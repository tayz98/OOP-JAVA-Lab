
package labor02;

public class AdvancedCalculator {

    public static String nextSign(String[] operators, int number) {
        int k = number;
        for (int i = k; i < operators.length; i++) {
            if (operators[k].contains("*") || operators[k].contains("/")) {
                return operators[k];
            }
        }

    }


    public static void main(String[] args) {
        double[] numbers = new double[args.length];
        String[] operators = new String[args.length];
        double result = 0;
        for (int i = 0; i < args.length; i++) {
            if (args[i].contains("+") || args[i].contains("-") || args[i].contains("*") || args[i].contains("/")) {
                operators[i] = args[i];
            } else {
                numbers[i] = Double.parseDouble(args[i]);
            }
        }

        for (int i = 0; i < operators.length; i++) {
            double multNumber = 0;
            if (operators[i].contains("*") && numbers[i - 1] != 0 && numbers[i + 1] != 0) {
                multNumber += (numbers[i - 1] * numbers[i + 1]);
                numbers[i - 1] = 0;
                numbers[i + 1] = 0;
                numbers[i - 1] = multNumber;
            } else if (operators[i].contains("*") && numbers[i - 1] == 0 && numbers[i + 1] != 0 && nextSign(operators, i)) {
                m
            }
        }
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] != 0) {
                if (i == 0) {
                    result += numbers[i];
                    numbers[i] = 0;
                } else if (operators[i - 1].contains("+")) {
                    result += numbers[i];
                    numbers[i] = 0;
                } else if (operators[i - 1].contains("-")) {
                    result -= numbers[i];
                    numbers[i] = 0;
                }
            }
        }
        System.out.println(result);
    }
}






/* test */
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



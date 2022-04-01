
package labor02;

public class AdvancedCalculator {

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

        for (int j = 0; j < operators.length; j++) {
            if (operators[j] != null && operators[j].contains("*")) {
                result += (numbers[j - 1] * numbers[j + 1]);
                numbers[j - 1] = 0;
                numbers[j + 1] = 0;
            } else if (operators[j] != null && operators[j].contains("/")) {
                result += (numbers[j - 1] / numbers[j + 1]);
                numbers[j - 1] = 0;
                numbers[j + 1] = 0;
            }
        }

        for (int k = 0; k < operators.length; k++) {
            if (operators[k] != null && operators[k].contains("+")) {
                for (int l = 0; ; l++) {
                    if (l != 0) {
                        result += numbers[l];
                        break;
                    }
                }
            } else if (operators[k] != null && operators[k].contains("-")) {
                for (int m = 0; ; m++) {
                    if (m != 0) {
                        result -= numbers[m];
                        break;
                    }
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



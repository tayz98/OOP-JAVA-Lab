
package labor02;

public class AdvancedCalculator {

    public static String sign(String[] operators, int number) {
        for (int j = number - 1; j >= 0; j--) {
            if (operators[j] != null && !(operators[j].contains("/") || operators[j].contains("*"))) {
                if (operators[j].contains("+")) {
                    String tempSign = "+";
                    operators[j] = null;
                    return tempSign;
                } else if (operators[j].contains("-")) {
                    String tempSign = "-";
                    operators[j] = null;
                    return tempSign;
                }
            }
        }
        return "+";
    }

    public static double nextNumber(double[] numbers, int number2) {
        for (int j = number2; j > numbers.length; j++) {
            if (numbers[j] != 0) {
                double temp = numbers[j];
                numbers[j] = 0;
                return temp;
            }
        }
        return 0;
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

        for (int j = 0; j < operators.length; j++) {
            if (operators[j] != null && operators[j].contains("*")) {
                String sign1 = sign(operators, j);
                if (sign1.contains("+")) {
                    result += (numbers[j - 1] * numbers[j + 1]);
                    numbers[j - 1] = 0;
                    numbers[j + 1] = 0;
                } else if (sign1.contains("-")) {
                    result -= (numbers[j - 1] * numbers[j + 1]);
                    numbers[j - 1] = 0;
                    numbers[j + 1] = 0;
                }

            } else if (operators[j] != null && operators[j].contains("/")) {
                String sign1 = sign(operators, j);
                if (sign1.contains("+")) {
                    result += (numbers[j - 1] / numbers[j + 1]);
                    numbers[j - 1] = 0;
                    numbers[j + 1] = 0;
                } else if (sign1.contains("-")) {
                    result -= (numbers[j - 1] / numbers[j + 1]);
                    numbers[j - 1] = 0;
                    numbers[j + 1] = 0;
                }
            }
        }

        for (int k = 0; k < operators.length; k++) {
            if (operators[k] != null && operators[k].contains("+")) {
                String sign1 = sign(operators, k);
                if (sign1.contains("+")) {
                    result += nextNumber(numbers, k);
                } else if (sign1.contains("-")) {
                    result -= nextNumber(numbers, k);
                }
            }
        }

        for (int k = 0; k < operators.length; k++) {
            if (operators[k] != null && operators[k].contains("-")) {
                String sign1 = sign(operators, k);
                if (sign1.contains("-")) {
                    result += nextNumber(numbers, k);
                } else if (sign1.contains("+")) {
                    result -= nextNumber(numbers, k);
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



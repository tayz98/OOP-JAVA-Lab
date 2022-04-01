
package labor02;

public class AdvancedCalculator {

    public static String sign(String[] operators) {
        for (int j = 0; j < operators.length; j++) {
            if (operators[j] != null) {
                if (operators[j].contains("+")) {
                    String tempSign = "+";
                    return tempSign;
                } else if (operators[j].contains("-")) {
                    String tempSign = "-";
                    return tempSign;
                }
            }
        }
        return null;
    }

    public static double nextNumber(double[] numbers) {
        for (int j = 0; j < numbers.length; j++) {
            if (numbers[j] != 0) {
                double temp = numbers[j];
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
            String sign1 = sign(operators);
            if (operators[j] != null && operators[j].contains("*")) {

                if (sign1.contains("+")) {
                    result += (numbers[j - 1] * numbers[j + 1]);
                }
                if (sign1.contains("-")) {
                    result -= (numbers[j - 1] * numbers[j + 1]);
                    numbers[j - 1] = 0;
                    numbers[j + 1] = 0;
                }

            } else if (operators[j] != null && operators[j].contains("/")) {
                if (sign1.contains("+")) {
                    result += (numbers[j - 1] / numbers[j + 1]);
                }
                if (sign1.contains("-")) {
                    result -= (numbers[j - 1] * numbers[j + 1]);
                    numbers[j - 1] = 0;
                    numbers[j + 1] = 0;
                }
            }
        }

        for (int k = 0; k < operators.length; k++) {
            if (operators[k] != null && operators[k].contains("-")) {
                String sign1 = sign(operators);
                if (sign1.contains("-")) {
                    result += nextNumber(numbers);
                } else if (sign1.contains("+")) {
                    result -= nextNumber(numbers);
                }
            }
        }

        for (int k = 0; k < operators.length; k++) {
            String sign1 = sign(operators);
            if (operators[k] != null && operators[k].contains("+")) {
                if (sign1.contains("+")) {
                    result += nextNumber(numbers);
                } else if (sign1.contains("-")) {
                    result -= nextNumber(numbers);
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



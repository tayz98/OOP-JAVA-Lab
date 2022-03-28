package labor02;


public class Calculator{

    public static void main(String[] args) {

        // Converting the strings into integer variables
        int n1 = Integer.parseInt(args[0]);
        int n2 = Integer.parseInt(args[2]);

        // Calculation and output of the values
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
            default -> System.out.println(0);
        }
    }
}

/* Task: 
Programmiert in Java einen einfachen Taschenrechner, der drei Parameter über die
Kommandozeile übergeben bekommt. Der erste und dritte Parameter soll eine (Integer) Zahl
sein, der zweite Parameter eine Grundrechenart (+, -, *, /). Das Programm soll dann das
Ergebnis dieser Rechnung ausgeben.

Bsp:
$java Calculator.java 3 + 5
8
$java Calculator.java 5 / 2
2.5
*/ 
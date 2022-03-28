package Labor02;


public class Calculator{

    public static void main(String[] args) {

        // Umwandlung der Strings in Integer-Variablen
        int n1 = Integer.parseInt(args[0]);
        int n2 = Integer.parseInt(args[2]);

        // Rechnung und Ausgabe der Werte
        switch (args[1]) {
            case "+" -> System.out.println(n1 + n2);
            case "-" -> System.out.println(n1 - n2);
            case "/" -> {
                double result = ((double) n1) / n2;
                // wenn es sich um ein gerades Ergebnis handelt, wird ein int-Wert ausgegeben
                if (result % 1 == 0) {
                    System.out.println((int) result);
                }
                // ansonsten wird ein double-Ergebnis mit Nachkommastelle ausgegeben
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
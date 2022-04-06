/**
 * @name AdvancedCalculator
 * @package labor02
 * @file AdvancedCalculatorFinal.java
 * @authors Veronica Zylla, Sören Zacharias, Alexander Nachtigal
 * @email veronica.zylla@student.fh-kiel.de, soeren.zacharias@student.fh-kiel.de, alexander.nachtigal@student.fh-kiel.de
 * @description Fortgeschrittener Profi-Rechner für +, -, *, /, () und (positive und negative) Fließkommazahlen
 */

package labor02;
import java.util.ArrayList;
import java.util.List;

public class AdvancedCalculatorFinal {

    /*
    Zum Aufrufen des Programmes bitte entweder:
    - die Eingabeaufforderung/CMD/command prompt nutzen und Term normal eingeben.
    [Bsp: ((9+9)+6)−3*4/3−2−2*1+(3−2)*3]
    - PowerShell nutzen und den Term mit "" umschließen.
    [Bsp: "((9+9)+6)−3*4/3−2−2*1+(3−2)*3"]

    Der Term kann sowohl ohne als auch mit Leerzeichen eingegeben werden.
     */

    public static void main(String[] args) {
        // Einlesen der Argumente und löschen von Leerzeichen
        String equation = deleteSpaces(args);
        // Umwandeln des Strings in eine Liste
        List<String> list = createList(equation);
        // Falls eine falsche Eingabe getätigt wurde, bricht das Programm hier ab
        if (list.isEmpty()) System.exit(0);
        // Berechnung des Terms
        System.out.println("Final result = " + deleteDecimal(Float.parseFloat(getResult(list))));
    }

    // Funktion zum Erstellen eines Strings des Eingabeterms ohne Leerzeichen, die bei der Eingabe gemacht werden können
    public static String deleteSpaces(String[] arr) {
        String returnStr = "";
        for (String s : arr) {
            returnStr += s;
        }
        return returnStr;
    }

    // Funktion bekommt einen String als Übergabe und gibt ein Ergebnis aus
    // wird rekursiv genutzt, damit Ausdrücke in Klammern ausgerechnet werden
    public static String getResult(List<String> list) {
        System.out.println("Following term will be calculated:");
        list.forEach(System.out::print);
        System.out.println();
        System.out.println("-----------------------------------");

        // Prüfen, ob Ausdruck noch Klammern enthält
        // dazu wird nach geöffneten Klammern und der dazugehörigen schließenden Klammer gesucht und der Ausdruck innerhalb der Klammer rekursiv aufgerufen
        if (list.contains("(") || list.contains(")")) {
            int numOpenBrackets = 0;
            int numClosingBrackets = 0;
            for (int i = 0; i < list.size(); i++) {
                String s = list.get(i);
                if (s.equals("(")) {
                    numOpenBrackets++;
                    for (int j = i + 1; j < list.size(); j++) {
                        if (list.get(j).equals("(")) {
                            numOpenBrackets++;
                        } else if (list.get(j).equals(")")) {
                            numClosingBrackets++;
                            if (numOpenBrackets == numClosingBrackets) {
                                list.set(i, getResult(createSublist(list, i + 1, j - 1)));
                                list.subList(i + 1, j + 1).clear();
                                numOpenBrackets = 0;
                                numClosingBrackets = 0;
                                break;
                            }
                        }
                    }
                    // Falls die Anzahl an öffnenden und schließenden Klammern nicht übereinstimmt, gibt er ein Fehler aus
                    if (numOpenBrackets != numClosingBrackets) {
                        System.out.println("Number of brackets doesn't match!");
                        return "0";
                    }
                }
            }
        }
        // 1. Schritt: alle Ausdrücke multiplizieren oder dividieren
        for (int i = 0; i < list.size(); i++) {
            if (isMultOrDivOperator(list.get(i))) {
                list.set(i - 1, Float.toString(divisionAndMult(list.subList(i - 1, i + 2))));
                list.subList(i, i + 2).clear();
                i--; // Durch das clear der Liste rutscht der Rest der Liste nach vorne und i hat einen neuen Inhalt, muss deswegen neu überprüft werden
            }
        }
        // 2. Schritt: alle Ausdrücke addieren oder subtrahieren
        for (int i = 0; i < list.size(); i++) {
            if (isAddOrSubOperator(list.get(i))) {
                list.set(i - 1, Float.toString(additionAndSubt(list.subList(i - 1, i + 2))));
                list.subList(i, i + 2).clear();
                i--; // Durch das clear der Liste rutscht der Rest der Liste nach vorne und i hat einen neuen Inhalt, muss deswegen neu überprüft werden
            }
        }
        if (list.size() == 1) return list.get(0);
        return "0";
    }

    // Multiplikation oder Division einer Liste (Beispielliste: {"3", "*", "4"})
    public static float divisionAndMult(List<String> list) {
        try {
            float result = 0;
            for (int i = 0; i < list.size(); i++) {
                if (isOperator(list.get(i))) {
                    if (list.get(i).equals("*"))
                        result = Float.parseFloat(list.get(i - 1)) * Float.parseFloat(list.get(i + 1));
                    if (list.get(i).equals("/")) {
                        if (list.get(i + 1).equals("0") || list.get(i + 1).equals("0.0")) {     // Falls durch 0 geteilt wird, soll eine Fehlermeldung ausgegeben werden.
                            System.out.println("Dividing by 0 is not allowed. Program ends here with exit code 42..");
                            System.exit(42);
                        }
                        result = Float.parseFloat(list.get(i - 1)) / Float.parseFloat(list.get(i + 1));
                    }
                }
            }
            return result;
        } catch (Exception e) {
            System.out.println("Something went wrong! Check the input again!");
        }
        return 0;
    }

    // Addition oder Subtraktion einer Liste (Beispielliste: {"3", "+", "4"})
    public static float additionAndSubt(List<String> list) {
        try {
            float result = 0;
            for (int i = 0; i < list.size(); i++) {
                if (isOperator(list.get(i))) {
                    if (list.get(i).equals("+"))
                        result = Float.parseFloat(list.get(i - 1)) + Float.parseFloat(list.get(i + 1));
                    if (list.get(i).equals("-"))
                        result = Float.parseFloat(list.get(i - 1)) - Float.parseFloat(list.get(i + 1));
                }
            }
            return result;
        } catch (Exception e) {
            System.out.println("Something went wrong! Check the input again!");
        }
        return 0;
    }

    /* Funktion zum Erstellen einer Liste mit allen Elementen aus der Gleichung
    * Gibt Fehler aus, falls nicht akzeptierte Zeichen oder bspw. 2 Trennzeichen in einer Zahl eingegeben werden
    * Prüft auf Richtigkeit der Eingabe
     */
    public static ArrayList<String> createList(String str) {
        ArrayList<String> list = new ArrayList<>();

        ArrayList<String> errorList = new ArrayList<>(); // Leere Liste zur Rückgabe im Fehlerfall
        int dotCount = 0;
        boolean sign = false;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
             // boolean zum Überprüfen, um es sich bei einem Minus um ein Vorzeichen oder ein Operator handelt
            if (c == '+' || c == '*' || c == '/' || c == '(' || c == ')') {
                list.add(Character.toString(c));
            } else if (c == '-') {
                if (i == 0 || isOperator(Character.toString(str.charAt(i - 1)))) {
                    sign = true;
                } else {
                    list.add(Character.toString(c));
                }
            } else if (Character.isDigit(c) || c == '.') {
                if (c == '.') dotCount++;
                    String number = "";
                    if (sign) {
                        number = "-" + c;
                        sign = false;
                    } else {
                        number = Character.toString(c);
                    }
                    while (i + 1 < str.length() && (Character.isDigit(str.charAt(i + 1)) || str.charAt(i + 1) == '.')) {
                        if (str.charAt(i + 1) == '.') dotCount++;
                        if (dotCount > 1) {
                            System.out.println("Error: Too many dots! Program ends here...");
                            return errorList;
                        }
                        number += Character.toString(str.charAt(i + 1));
                        i++; // Manuelles Erhöhen von i, da die nächsten Zeichen mit zur Nummer gehören und in der for-Schleife übersprungen werden müssen
                    }
                    list.add(number);
                    dotCount = 0;
                } else {
                    System.out.println("Error: Wrong input! Program ends here...");
                    return errorList;
                }
            }
            return list;
        }

    // Funktion zum Abschneiden, der Nachkommastelle, falls Ergebnis eine ganze Zahl ist
    public static String deleteDecimal ( float in){
        if (in % 1 == 0) {
            return Integer.toString((int) in);
        } else {
            return Float.toString(in);
        }
    }

    // Funktion prüft, ob String ein Rechenoperator ist
    public static boolean isOperator (String s){
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    // Funktion prüft, ob Operator "+" oder "-" ist
    public static boolean isAddOrSubOperator (String s){
        return s.equals("+") || s.equals("-");
    }

    // Funktion prüft, ob Operator "*" oder "/" ist
    public static boolean isMultOrDivOperator (String s){
        return s.equals("*") || s.equals("/");
    }

    // Funktion zum Erstellen einer Sublist, kopiert einen Teil von startIndex bis endIndex in eine neue Liste und gibt diese zurück
    public static List<String> createSublist (List < String > inList,int startIndex, int endIndex){
        List<String> returnList = new ArrayList<String>();
        returnList.addAll(inList);
        for (int i = returnList.size() - 1; i >= 0; i--) {
            if (i > endIndex || i < startIndex) {
                returnList.remove(i);
            }
        }
        return returnList;
    }

}
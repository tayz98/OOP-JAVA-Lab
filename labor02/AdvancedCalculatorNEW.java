package labor02;

import java.util.ArrayList;
import java.util.List;

public class AdvancedCalculatorNEW {

    /*

    Zum Aufrufen des Programmes bitte entweder:
    - die Eingabeaufforderung nutzen und Term normal eingeben.
    [Bsp: ((9+9)+6)−3*4/3−2−2*1+(3−2)*3 ]
    - PowerShell nutzen (oder Terminal direkt in der IDE) und den Termin mit "" umschließen.
    [Bsp: "((9+9)+6)−3*4/3−2−2*1+(3−2)*3" ]

    Der Term kann sowohl ohne als auch mit Leerzeichen eingegeben werden.

     */

    public static void main(String[] args) {
        // Einlesen der Argumente und löschen von Leerzeichen
        String equation = deleteSpaces(args);
        // Zmwandeln des Strings in eine Liste
        List<String> list = createList(equation);
        // Berechnung des Terms
        System.out.println("Final result = " + deleteDecimal(Float.parseFloat(getResult(list))));
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
                                list.set(i , getResult(createSublist(list, i + 1, j - 1)));
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
                    i--;
                }
            }
            // 2. Schritt: alle Ausdrücke addieren oder subtrahieren
            for (int i = 0; i < list.size(); i++) {
                if (isAddOrSubOperator(list.get(i))) {
                    list.set(i - 1, Float.toString(additionAndSubt(list.subList(i - 1, i + 2))));
                    list.subList(i, i + 2).clear();
                    i--;
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
                    if (list.get(i).equals("*")) result = Float.parseFloat(list.get(i - 1)) * Float.parseFloat(list.get(i + 1));
                    if (list.get(i).equals("/")) result = Float.parseFloat(list.get(i - 1)) / Float.parseFloat(list.get(i + 1));
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
                    if (list.get(i).equals("+")) result = Float.parseFloat(list.get(i - 1)) + Float.parseFloat(list.get(i + 1));
                    if (list.get(i).equals("-")) result = Float.parseFloat(list.get(i - 1)) - Float.parseFloat(list.get(i + 1));
                }
            }
            return result;
        } catch (Exception e) {
            System.out.println("Something went wrong! Check the input again!");
        }
        return 0;
    }

    // Funktion zum Erstellen eines Strings ohne Leerzeichen, die bei der Eingabe gemacht werden können
    public static String deleteSpaces(String[] arr) {
        String returnStr = "";
        for (String s : arr) {
            returnStr += s;
        }
        return returnStr;
    }

    // Funktion zum Erstellen einer Liste mit allen Elementen aus der Gleichung
    public static ArrayList<String> createList(String str) {
        ArrayList<String> list = new ArrayList<String>();

        // Das ist nicht sauber programmiert, aber erstmal, damit die Funktion funktioniert!
        ArrayList<String> errorList = new ArrayList<String>();
        errorList.add("Fehler: Ungültige Eingabe!");

        int dotCount = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')') {
                list.add(Character.toString(c));
            } else if (Character.isDigit(c) || c == '.') {
                String number = Character.toString(c);

                while (i + 1 < str.length() && (Character.isDigit(str.charAt(i + 1)) || str.charAt(i + 1) == '.')) {

                    if (str.charAt(i + 1) == '.') {
                        dotCount++;
                    }

                    if (dotCount > 1) {
                        return errorList;
                    }

                    number += Character.toString(str.charAt(i + 1));
                    i++;
                }
                list.add(number);
                dotCount = 0;

            } else {
                return errorList;

            }
        }
        return list;
    }

    // Funktion zum Abschneiden, der Nachkommastelle, falls Ergebnis eine ganze Zahl ist
    public static String deleteDecimal(float in) {
        if (in % 1 == 0) {
            return Integer.toString((int)in);
        } else {
            return Float.toString(in);
        }
    }

    // Funktion prüft, ob String ein Rechenoperator ist
    public static boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    // Funktion prüft, ob Operator "+" oder "-" ist
    public static boolean isAddOrSubOperator(String s) {
        return s.equals("+") || s.equals("-");
    }

    // Funktion prüft, ob Operator "*" oder "/" ist
    public static boolean isMultOrDivOperator(String s) {
        return s.equals("*") || s.equals("/");
    }

    // Funktion zum Erstellen einer Sublist, kopiert einen Teil von startIndex bis endIndex in eine neue Liste und gibt diese zurück
    public static List<String> createSublist(List<String> inList, int startIndex, int endIndex) {
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
package labor02;

import java.util.ArrayList;
import java.util.List;

public class AdvancedCalculatorNEW {
    public static void main(String[] args) {
        //String equation = deleteSpaces(args);
        //List<String> list = createList(equation);

        float result = 0;

        List<String> list = new ArrayList<>();
        /*
        list.add("4");
        list.add("*");
        list.add("(");
        list.add("4");
        list.add("+");
        list.add("(");
        list.add("4");
        list.add("+");
        list.add("3.3");
        list.add(")");
        list.add(")");
        */

        list.add("2");
        list.add("*");
        list.add("(");
        list.add("3");
        list.add("+");
        list.add("4");
        list.add(")");

        /*
        for (int i = 0; i < list.size(); i++) {
            if (i == 3) {
                list.remove(i);
            }
            System.out.println("Index: " + Integer.toString(i) + " || Inhalt: " + list.get(i) + " || Laenge list: " + list.size());
        }
        +/
         */

        // System.out.println("result = " + deleteDecimal(Float.parseFloat(getResult(list))));
        getResult(list);
        //divisionAndMult((ArrayList<String>) list, result);
        //additionAndSubt((ArrayList<String>) list, result);
        // List<String> list = new ArrayList<String>(Arrays.stream(args).toList());

        // System.out.println(deleteDecimal(result));
    }

    public static String getResult(List<String> list) {
        System.out.println("Aufruf mit folgendem Ausdruck:");
        for (String s : list) {
            System.out.print(s + " ");
        }
        System.out.println();

        // Prüfen, ob Ausdruck noch Klammern enthält
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
                                // Hier ersetzen
                                List<String> subList = new ArrayList<String>();
                                subList = list.subList(i + 1, j);
                                getResult(subList);
                                //list.set(0, tmp);
                                System.out.println("--------------------------------");
                                for (String a: list) System.out.println(a);
                                System.out.println("--------------------------------");
                                System.out.println(i);
                                System.out.println(j);
                                //list.subList(i, j - 1).clear();
                                break;
                            }
                        }
                    }
                    if (numOpenBrackets != numClosingBrackets) {
                        System.out.println("Anzahl Klammern stimmt nicht ueberein!");
                        return "0";
                    }
                }
            }


        } else {
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
        }


        if (list.size() == 1) return list.get(0);
        return "0";
    }

    // Multiplikation oder Division einer Liste (Beispielliste: {"3", "*", "4"})
    public static float divisionAndMult(List<String> list) {
        float result = 0;
        for (int i = 0; i < list.size(); i++) {
            if (isOperator(list.get(i))) {
                if (list.get(i).equals("*")) result = Float.parseFloat(list.get(i - 1)) * Float.parseFloat(list.get(i + 1));
                if (list.get(i).equals("/")) result = Float.parseFloat(list.get(i - 1)) / Float.parseFloat(list.get(i + 1));
            }
        }
        return result;
    }

    // Addition oder Subtraktion einer Liste (Beispielliste: {"3", "+", "4"})
    public static float additionAndSubt(List<String> list) {
        float result = 0;
        for (int i = 0; i < list.size(); i++) {
            if (isOperator(list.get(i))) {
                if (list.get(i).equals("+")) result = Float.parseFloat(list.get(i - 1)) + Float.parseFloat(list.get(i + 1));
                if (list.get(i).equals("-")) result = Float.parseFloat(list.get(i - 1)) - Float.parseFloat(list.get(i + 1));
            }
        }
        return result;
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

    public static boolean isNumeric(String s) {
        if (s == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(s);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static boolean isOperator(String s) {
        if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isAddOrSubOperator(String s) {
        if (s.equals("+") || s.equals("-")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isMultOrDivOperator(String s) {
        if (s.equals("*") || s.equals("/")) {
            return true;
        } else {
            return false;
        }
    }
}
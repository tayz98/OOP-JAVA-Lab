package labor02;

import java.util.ArrayList;
import java.util.List;

public class AdvancedCalculatorNEW {

    public static float additionAndSubt(ArrayList<String> list, float result) {
        while (list.size() > 0) {
            if (list.get(0).equals("+")) result += Float.parseFloat(list.get(1));
            if (list.get(0).equals("-")) result -= Float.parseFloat(list.get(1));
            list.remove(1);
            list.remove(0);
        }
        return result;
    }

    public static float divisionAndMult(ArrayList<String> list, float result) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("*") || list.get(i).equals("/")) {
                float tmp = 0;

                if (list.get(i).equals("*"))
                    tmp = Float.parseFloat(list.get(i - 1)) * Float.parseFloat(list.get(i + 1));
                if (list.get(i).equals("/"))
                    tmp = Float.parseFloat(list.get(i - 1)) / Float.parseFloat(list.get(i + 1));
                list.set(i, String.valueOf(tmp));
                list.remove(i + 1);
                list.remove(i - 1);
                i--;
            }
        }

        result = Float.parseFloat(list.get(0));
        list.remove(0);
        return result;
    }

    public static void main(String[] args) {
        String equation = deleteSpaces(args);
        List<String> list = createList(equation);
        float result = 0;
        divisionAndMult((ArrayList<String>) list, result);
        additionAndSubt((ArrayList<String>) list, result);
        // List<String> list = new ArrayList<String>(Arrays.stream(args).toList());

        System.out.println(deleteDecimal(result));
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
}
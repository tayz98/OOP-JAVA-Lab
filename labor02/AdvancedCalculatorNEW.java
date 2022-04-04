package labor02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdvancedCalculatorNEW {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.stream(args).toList());
        float result = 0;

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
        while (list.size() > 0) {
            if (list.get(0).equals("+")) result += Float.parseFloat(list.get(1));
            if (list.get(0).equals("-")) result -= Float.parseFloat(list.get(1));
            list.remove(1);
            list.remove(0);
        }
        System.out.println(result);
    }
}

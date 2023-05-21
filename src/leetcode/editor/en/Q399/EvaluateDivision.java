package leetcode.editor.en.Q399;

import java.util.*;

import javafx.util.Pair;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String, Double>> equationMap = buildEquationMap(equations, values);
        double[] result = new double[queries.size()];
        int idx = 0;
        for (List<String> query : queries) {
            String dividend = query.get(0);
            String divisor = query.get(1);
            if (!equationMap.containsKey(dividend) || !equationMap.containsKey(divisor)) {
                result[idx++] = -1.0;
                continue;
            }
            result[idx++] = findValue(dividend, divisor, equationMap, new HashSet<>());
        }

        return result;
    }


    private HashMap<String, HashMap<String, Double>> buildEquationMap(List<List<String>> equations, double[] values) {
        HashMap<String, HashMap<String, Double>> equationMap = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);

            String dividend = equation.get(0);
            String divisor = equation.get(1);
            double result = values[i];

            equationMap.computeIfAbsent(dividend, (v) -> new HashMap<>()).put(divisor, result);
            equationMap.computeIfAbsent(divisor, (v) -> new HashMap<>()).put(dividend, (1.0 / result));
        }


        return equationMap;
    }

    private double findValue(String dividend, String divisor, HashMap<String, HashMap<String, Double>> equationMap, HashSet<Pair<String, String>> stack) {
        HashMap<String, Double> divisors = equationMap.get(dividend);
        if (divisors.containsKey(divisor)) return divisors.get(divisor);
        Pair<String, String> execKey = new Pair<>(dividend, divisor);
        stack.add(execKey);
        double ans = -1.0;
        for (String dividendOfDivisor : divisors.keySet()) {
            if (stack.contains(new Pair<>(dividendOfDivisor, divisor))) continue;
            double combine = findValue(dividendOfDivisor, divisor, equationMap, stack);
            if (combine != -1) {
                combine *= divisors.get(dividendOfDivisor);
                stack.remove(execKey);
                ans = combine;
                break;
            }
        }
        stack.remove(execKey);
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class EvaluateDivision extends Solution {
}
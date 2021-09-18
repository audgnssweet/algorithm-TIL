package DifferentWaysToAddParentheses;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DifferentWaysToAddParentheses {

    Map<String, List<Integer>> map = new HashMap<>();

    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new LinkedList<>();

        if(map.containsKey(expression))
            return map.get(expression);

        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*') {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));

                for (int j = 0; j < left.size(); j++) {
                    for (int k = 0; k < right.size(); k++) {

                        switch (expression.charAt(i)) {
                            case '+':
                                res.add(left.get(j) + right.get(k));
                                break;
                            case '-':
                                res.add(left.get(j) - right.get(k));
                                break;
                            default:
                                res.add(left.get(j) * right.get(k));
                        }
                    }
                }
            }
        }

        if (res.size() == 0) {
            return List.of(Integer.parseInt(expression));
        }
        map.put(expression, res);

        return res;
    }

}

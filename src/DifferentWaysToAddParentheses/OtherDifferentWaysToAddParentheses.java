package DifferentWaysToAddParentheses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OtherDifferentWaysToAddParentheses {

    public List<Integer> diffWaysToCompute(String expression) {
        Map<String, List<Integer>> map = new HashMap<>();
        // same expression might get calcualted multiple times.
        if(map.containsKey(expression))
            return map.get(expression);
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < expression.length(); i++){
            char c = expression.charAt(i);
            if(c == '+' || c == '-' || c == '*'){
                List<Integer> l = diffWaysToCompute(expression.substring(0, i));
                List<Integer> r = diffWaysToCompute(expression.substring(i + 1));
                for(int j = 0; j < l.size(); j++){
                    for(int k = 0; k < r.size(); k++){
                        switch(c){
                            case '+':
                                res.add(l.get(j) + r.get(k));
                                break;
                            case '-':
                                res.add(l.get(j) - r.get(k));
                                break;
                            case '*':
                                res.add(l.get(j) * r.get(k));
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
        }

        // this is just a number
        if(res.size() == 0){
            res.add(Integer.valueOf(expression));
        }

        map.put(expression, res);

        return res;
    }

}

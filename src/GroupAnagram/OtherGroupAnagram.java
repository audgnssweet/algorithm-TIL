package GroupAnagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OtherGroupAnagram {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<String> temp;

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            if (map.containsKey(sorted)) {
                temp = map.get(sorted);
            } else {
                temp = new ArrayList<>();
            }
            temp.add(str);
            map.put(sorted, temp);
        }
        return new ArrayList<>(map.values());
    }
}

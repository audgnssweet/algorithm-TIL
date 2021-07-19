package GroupAnagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {

    private Map<List<Integer>, List<String>> map = new HashMap<>();

    public List<List<String>> groupAnagrams(String[] strs) {
        for (String str : strs) {
            int hap = 0;
            int gop = 1;
            for (Character ch : str.toCharArray()) {
                hap += ch;
                gop *= ch;
            }
            final List<Integer> key = Arrays.asList(str.length(), hap, gop);
            final List<String> orDefault = map.getOrDefault(key, new ArrayList<>());
            orDefault.add(str);
            map.put(key, orDefault);
        }
        return new ArrayList<>(map.values());
    }

}

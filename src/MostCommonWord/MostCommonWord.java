package MostCommonWord;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MostCommonWord {

    public String mostCommonWord(String paragraph, String[] banned) {

        List<String> sortedBanned = Arrays.stream(banned).sorted().collect(Collectors.toList());

        //전처리 소문자로바꾸고 bann단어 제외
        final List<String> data = Arrays.stream(paragraph.toLowerCase().replaceAll("[^a-z\\s]", " ").trim()
            .split("\\s+"))
            .filter(str -> !sortedBanned.contains(str))
            .collect(Collectors.toList());

        //Map으로 key-value 형태로 갯수 저장
        Map<String, Integer> resultMap = new HashMap<>();
        String maxWord = "";
        int maxCount = 0;
        for (int i = 0; i < data.size(); i++) {
            if (!resultMap.containsKey(data.get(i))) {
                resultMap.put(data.get(i), 0);
            }
            resultMap.replace(data.get(i), resultMap.get(data.get(i)) + 1);

            if (maxCount < resultMap.get(data.get(i))) {
                maxWord = data.get(i);
                maxCount = resultMap.get(data.get(i));
            }
        }

        return maxWord;
    }
}

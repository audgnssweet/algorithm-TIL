package OpenChattingRoom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static String[] solution(String[] record) {
        List<String> res = new ArrayList<>();
        Map<String, String> nickNameMap = new HashMap<>();

        for (String rec : record) {
            String[] split = rec.split(" ");

            switch (split[0]) {
                case "Enter":
                    nickNameMap.put(split[1], split[2]);
                    res.add(String.format("%s 님이 들어왔습니다.", split[1]));
                    break;
                case "Leave":
                    res.add(String.format("%s 님이 나갔습니다.", split[1]));
                    break;
                case "Change":
                    nickNameMap.put(split[1], split[2]);
            }
        }

        for (int i = 0; i < res.size(); i++) {
            String[] split = res.get(i).split(" ");
            res.set(i, res.get(i).replace(split[0] + " ", nickNameMap.get(split[0])));
        }

        return res.toArray(new String[0]);
    }

    public static void main(String[] args) {
        solution(new String[]{
            "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"
        });
    }

}

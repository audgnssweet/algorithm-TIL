package wooteco.three;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static int solution(String[] ings, String[] menu, String[] sell) {
        int[] priceOfIngs = new int[26];
        for (int i = 0; i < ings.length; i++) {
            String[] info = ings[i].split(" ");
            char cur = info[0].charAt(0);
            int price = Integer.parseInt(info[1]);

            priceOfIngs[cur - 'a'] = price;
        }

        Map<String, Integer> priceOfMenus = new HashMap<>();
        for (int i = 0; i < menu.length; i++) {
            String[] info = menu[i].split(" ");

            int outcome = 0;
            for (char ing : info[1].toCharArray()) {
                outcome += priceOfIngs[ing - 'a'];
            }
            int income = Integer.parseInt(info[2]) - outcome;

            priceOfMenus.put(info[0], income);
        }

        int ans = 0;
        for (int i = 0; i < sell.length; i++) {
            String[] info = sell[i].split(" ");

            int num = Integer.parseInt(info[1]);
            ans += priceOfMenus.get(info[0]) * num;
        }

        return ans;
    }
}

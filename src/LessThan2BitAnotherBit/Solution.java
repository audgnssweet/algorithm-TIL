package LessThan2BitAnotherBit;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    Map<Long, Long> map = new HashMap<>();

    public long[] solution(long[] numbers) {
        long[] res = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            long cur = numbers[i];

            if (!map.containsKey(numbers[i])) {
                long num = cur + 1;
                long mask = 1;
                while (Long.bitCount((cur ^ num)) > 2) {
                    num |= mask;
                    mask = mask << 1;
                }
                res[i] = num;
                map.put(cur, num);
            } else {
                res[i] = map.get(cur);
            }
        }

        return res;
    }
}

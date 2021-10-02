package LargestNumber;

import java.util.Arrays;

public class Solution {

    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder("");

        String[] numbers2 = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers2[i] = numbers[i] + "";
        }

        Arrays.sort(numbers2, (s1, s2) -> (s1 + s2).compareTo(s2 + s1) * -1);

        for (int i = 0; i < numbers.length; i++) {
            sb.append(numbers2[i]);
        }

        return sb.charAt(0) == '0' ? "0" : sb.toString();
    }

}

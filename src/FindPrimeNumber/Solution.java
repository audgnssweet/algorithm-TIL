package FindPrimeNumber;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Solution {

    static char[] chars;
    static Set<Integer> nums = new HashSet<>();

    public static int solution(String numbers) {
        chars = numbers.toCharArray();
        permutation(new LinkedList<>(), new boolean[numbers.length()]);

        int res = 0;
        int max = Integer.MIN_VALUE;
        for (Integer num : nums) {
            max = Math.max(max, num);
        }

        boolean[] primes = new boolean[max + 1];
        int idx = 2;
        int temp = 0;

        while (idx <= max) {
            if (!primes[idx]) {
                temp = idx * 2;
                while (temp <= max) {
                    primes[temp] = true;
                    temp += idx;
                }
            }

            idx += 1;
        }

        for (Integer num : nums) {
            if (!primes[num] && num > 1) {
                res += 1;
            }
        }

        return res;
    }

    static void permutation(LinkedList<Character> temp, boolean[] visit) {
        if (temp.size() != 0) {
            StringBuilder sb = new StringBuilder("");
            for (Character character : temp) {
                sb.append(character);
            }
            nums.add(Integer.parseInt(sb.toString()));
        }
        for (int i = 0; i < chars.length; i++) {
            if (!visit[i]) {
                visit[i] = true;

                temp.addLast(chars[i]);
                permutation(temp, visit);
                temp.pollLast();

                visit[i] = false;
            }
        }
    }
}

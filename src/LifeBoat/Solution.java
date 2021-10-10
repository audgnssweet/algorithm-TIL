package LifeBoat;

import java.util.Arrays;

public class Solution {

    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int idx = Arrays.binarySearch(people, limit - 40);

        int res = 0;
        if (idx >= 0) {
            while (idx < people.length && people[idx] <= (limit - 40)) {
                idx += 1;
            }
        } else {
            idx = Math.abs(idx + 1);
        }
        res += (people.length - idx);

        int left = 0, right = idx - 1;
        while (left < right) {
            if (people[left] + people[right] <= limit) {
                left += 1;
            }
            right -= 1;
            res += 1;
        }

        if (left == right) {
            res += 1;
        }

        return res;
    }
}

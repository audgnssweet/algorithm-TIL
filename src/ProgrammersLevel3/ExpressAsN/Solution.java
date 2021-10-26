package ProgrammersLevel3.ExpressAsN;

import java.util.HashSet;
import java.util.Set;

class Solution {

    public static int solution(int N, int number) {
        Set<Integer>[] sets = new Set[9];
        int tempN = N;
        for (int i = 1; i <= 8; i++) {
            sets[i] = new HashSet<>();
            sets[i].add(tempN);
            tempN = tempN * 10 + N;
        }

        for (int curLevel = 1; curLevel <= 8; curLevel++) {
            for (int tempLevel = 1; tempLevel < curLevel; tempLevel++) {
                for (int cur : sets[curLevel - tempLevel]) {
                    for (int temp : sets[tempLevel]) {
                        sets[curLevel].add(cur + temp);
                        sets[curLevel].add(cur - temp);
                        sets[curLevel].add(cur * temp);
                        if (temp != 0) {
                            sets[curLevel].add(cur / temp);
                        }
                    }
                }
            }
            if (sets[curLevel].contains(number)) {
                return curLevel;
            }
        }
        return -1;
    }
}
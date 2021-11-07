package FutureTalent.one;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String dial = br.readLine();
        String targetDial = br.readLine();

        if (dial == null || dial.length() < 7 || dial.length() > 51 || targetDial == null || targetDial.length() < 2 || targetDial.length() > 82) {
            System.out.println(-1);
            return;
        }

        Map<Character, Integer> pos = new HashMap<>();
        char[] chars = dial.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            pos.put(chars[i], i);
        }

        int len = chars.length;
        int curPos = 0;
        int whole = 0, left = 0, right = 0;
        for (char next : targetDial.toCharArray()) {
            int nextPos = pos.getOrDefault(next, -1);

            if (nextPos == -1) {
                System.out.println(-1);
                return;
            }

            if (nextPos == curPos) {
                whole += 1;
                continue;
            }

            //현재 커서가 다음 커서보다 작은 경우
            if (nextPos > curPos) {

                if (nextPos - curPos < curPos + (len - nextPos)) {
                    left += (nextPos - curPos);
                } else {
                    right += curPos + len - nextPos;
                }

                //현재 커서가 다음 커서보다 큰 경우
            } else {

                if (curPos - nextPos < len - curPos + nextPos) {
                    right += (curPos - nextPos);
                } else {
                    left += len - curPos + nextPos;
                }

            }
            whole += 1;
            curPos = nextPos;
        }

        whole += (left + right);
        System.out.println(whole + " " + left + " " + right);
    }
}

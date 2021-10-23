package NHN_20211023_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static int ans = 0;
    static Map<Integer, Integer> pos = new HashMap<>();
    static int[][] constraints;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numberOfConstraint = Integer.parseInt(br.readLine());
        constraints = new int[numberOfConstraint][];
        for (int i = 0; i < numberOfConstraint; i++) {
            String[] between = br.readLine().split(" ");
            constraints[i] = new int[]{Integer.parseInt(between[0]), Integer.parseInt(between[1])};
        }

        permutation(0, 8, new boolean[9], new int[8]);
        System.out.println(ans);
    }

    private static void permutation(int curPos, int target, boolean[] visit, int[] line) {
        if (curPos == target) {
            if (isValid()){
                ans += 1;
            }
            return;
        }

        for (int i = 1; i <= 8; i++) {
            if (!visit[i]) {
                visit[i] = true;
                pos.put(i, curPos);
                line[curPos] = i;
                permutation(curPos + 1, target, visit, line);
                pos.remove(i);
                visit[i] = false;
            }
        }
    }

    private static boolean isValid() {
        for (int i = 0; i < constraints.length; i++) {
            if (Math.abs(pos.get(constraints[i][0]) - pos.get(constraints[i][1])) == 1) {
                return false;
            }
        }
        return true;
    }
}

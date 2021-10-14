package RepeatingBinaryTransform;

public class Solution {

    public int[] solution(String s) {
        int[] ans = new int[2];
        while (!s.equals("1")) {
            String replaced = s.replaceAll("0", "");
            ans[1] += (s.length() - replaced.length());

            String next = Integer.toBinaryString(replaced.length());
            s = next;
            ans[0]++;
        }

        return ans;
    }
}

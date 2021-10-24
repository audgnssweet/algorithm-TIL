package BaekJoon1874;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder ans = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        int num = 1;
        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(br.readLine());

            while (num <= cur) {
                stack.push(num++);
                ans.append("+\n");
            }

            if (!stack.isEmpty() && stack.peek() == cur) {
                stack.pop();
                ans.append("-\n");
            } else {
                System.out.println("NO");
                return;
            }
        }

        System.out.println(ans);
        br.close();
    }
}

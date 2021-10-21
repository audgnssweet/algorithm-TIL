package BaekJoon6549;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int[] list = init(br);

            if (list.length == 0) {
                break;
            }

            long ans = getMax(list);
            System.out.println(ans);
        }

        br.close();
    }

    private static int[] init(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int idx = 0;
        int[] list = new int[Integer.parseInt(st.nextToken())];
        while (st.hasMoreTokens()) {
            list[idx++] = Integer.parseInt(st.nextToken());
        }

        return list;
    }

    private static long getMax(int[] histogram) {
        Stack<Integer> stack = new Stack<>();

        long ans = 0;
        for (int i = 0; i < histogram.length; i++) {

            while (!stack.isEmpty() && histogram[stack.peek()] >= histogram[i]) {
                int idx = stack.pop();
                int height = histogram[idx];

                long width = stack.isEmpty() ? i : i - 1 - stack.peek();

                long area = width * height;
                ans = Math.max(ans, area);
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int idx = stack.pop();
            int height = histogram[idx];

            long width = stack.isEmpty() ? histogram.length : histogram.length - 1 - stack.peek();

            long area = width * height;
            ans = Math.max(ans, area);
        }

        return ans;
    }
}

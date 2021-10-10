package StockTrading;

import java.util.Stack;

public class Solution {

    static class Node {
        int price;
        int idx;

        public Node(int price, int idx) {
            this.price = price;
            this.idx = idx;
        }
    }

    public int[] solution(int[] prices) {
        Stack<Node> stack = new Stack<>();
        int[] res = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && stack.peek().price > prices[i]) {
                Node pop = stack.pop();
                res[pop.idx] = i - pop.idx;
            }
            stack.push(new Node(prices[i], i));
        }

        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            res[pop.idx] = prices.length - pop.idx - 1;
        }

        return res;
    }
}

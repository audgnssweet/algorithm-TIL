package 올바른괄호;

import java.util.Stack;

class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solution("");
	}

	boolean solution(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			//왼쪽괄호면 걍 넣고, 오른쪽 괄호면 꺼낸다. 근데 비어있으면 바로 false return
			if (s.charAt(i) == '(') {
				stack.push('(');
			} else {
				if (stack.isEmpty()) {
					return false;
				} else {
					stack.pop();
				}
			}
		}

		return stack.isEmpty();
	}
}

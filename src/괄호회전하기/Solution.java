package 괄호회전하기;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

class Solution {

	static Deque<Character> chs = new LinkedList<>();

	public int solution(String s) {
		for (char ch : s.toCharArray()) {
			chs.addLast(ch);
		}

		int res = 0;
		for (int i = 0; i < chs.size(); i++) {
			if (isCorrect()) {
				res++;
			}

			chs.addLast(chs.removeFirst());
		}

		return res;
	}

	private boolean isCorrect() {
		Stack<Character> st = new Stack<>();
		for(char ch : chs) {
			if (!st.isEmpty() && st.peek() == getZzak(ch)) {
				st.pop();
			} else {
				st.push(ch);
			}
		}
		return st.isEmpty();
	}

	private char getZzak(char ch) {
		if (ch == ')') {
			return '(';
		} else if (ch == '}') {
			return '{';
		} else if (ch == ']') {
			return '[';
		} else {
			return '.';
		}
	}
}

package jaden문자열만들기;

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solution("for the last week");
	}

	public String solution(String s) {
		s = " " + s;

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < s.length(); i++) {
			char cur = s.charAt(i);
			if (Character.isAlphabetic(cur)) {
				if (isFirstAlphabet(s, i)) {
					if (isLowerCase(cur)) {
						cur += 'A' - 'a';
					}
				} else {
					if (!isLowerCase(cur)) {
						cur -= 'A' - 'a';
					}
				}
			}

			sb.append(cur);
		}

		return sb.toString();
	}

	private boolean isLowerCase(char cur) {
		return cur >= 'a' && cur <= 'z';
	}

	private boolean isFirstAlphabet(String s, int i) {
		return s.charAt(i - 1) == ' ';
	}
}

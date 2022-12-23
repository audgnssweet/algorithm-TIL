package 가장긴펠린드롬;

public class Solution {
	public int solution(String s) {
		if(s.length() == 1) {
			return 1;
		}
		int res = Integer.MIN_VALUE;
		for(int i = 0; i < s.length(); i++) {
			res = Math.max(res, getOddLen(i, s));
		}
		for(int i = 0; i < s.length() - 1; i++) {
			res = Math.max(res, getEvenLen(i, i + 1, s));
		}
		return res;
	}

	int getOddLen(int idx, String s) {
		int offset = 1;
		while(true) {
			int left = idx - offset;
			int right = idx + offset;

			if(outOfRange(left, right, s) || s.charAt(left) != s.charAt(right)) {
				return 1 + (offset - 1) * 2;
			}

			offset++;
		}
	}

	int getEvenLen(int left, int right, String s) {
		int offset = 0;
		while(true) {
			int l = left - offset;
			int r = right + offset;

			if(outOfRange(l, r, s) || s.charAt(l) != s.charAt(r)) {
				return r - l - 1;
			}

			offset++;
		}
	}

	boolean outOfRange(int left, int right, String s) {
		return left < 0 || right >= s.length();
	}
}

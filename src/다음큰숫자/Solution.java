package 다음큰숫자;

public class Solution {

	public int solution(int n) {
		int cnt = 0;
		for (char ch : Integer.toBinaryString(n).toCharArray()) {
			if (ch == '1') {
				cnt++;
			}
		}

		int bitCount = Integer.bitCount(n);
		System.out.println("bitCount = " + bitCount);

		String binString = Integer.toBinaryString(n);
		System.out.println("binString = " + binString);

		int k = n + 1;
		while (true) {
			Integer.bitCount(n);
			String cur = Integer.toBinaryString(k);
			int curCnt = 0;
			for (char ch : cur.toCharArray()) {
				if (ch == '1') {
					curCnt++;
				}
			}
			if (curCnt == cnt) {
				return k;
			}

			k++;
		}
	}
}

package 이진변환반복하기;

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solution("110010101001");
	}

	public int[] solution(String s) {
		//모든 0 제거
		//남은 문자열의 길이를 이진수로 변환
		//s 가 1이 될 때까지

		int removedCnt = 0;
		int cnt = 0;
		while (!s.equals("1")) {
			String after = s.replaceAll("0", "");
			removedCnt += (s.length() - after.length());
			cnt += 1;

			s = Integer.toBinaryString(after.length());
		}

		return new int[] {cnt, removedCnt};
	}
}

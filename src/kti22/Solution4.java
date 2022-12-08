package kti22;

public class Solution4 {

	public int solution(int n, int k) {
		int res = 0;

		String num = getKNumber(n, k);

		//투포인터 사용
		int left = 0;
		int right = 0;

		while (left < num.length()) {
			if (isLeftZero(num, left)) {
				left++;
				right = left;
			} else {
				while (right < num.length() && !isRightZero(num, right)) {
					right++;
				}
				System.out.println("substring = " + num.substring(left, right));
				if (isPrime(Long.parseLong(num.substring(left, right)))) {
					res++;
				}
				left = right + 1;
				right = left;
			}
		}

		return res;
	}

	private boolean isLeftZero(String num, int left) {
		return num.charAt(left) == '0';
	}

	private boolean isRightZero(String num, int right) {
		return num.charAt(right) == '0';
	}

	private String getKNumber(int n, int k) {
		StringBuilder num = new StringBuilder();
		while (n >= k) {
			num.append(n % k);
			n /= k;
			if (!(n >= k)) {
				num.append(n);
			}
		}
		return num.reverse().toString();
	}

	public boolean isPrime(long num) {
		if (num == 1) {
			return false;
		}
		if (num == 2) {
			return true;
		}
		if (num % 2 == 0) {
			return false;
		}

		for (int i = 3; i <= Math.sqrt(num); i += 2) {
			if (num % i == 0) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		Solution4 s = new Solution4();
		s.solution(437674, 3);
	}
}

package 데브매칭.three;

class Solution {

	public long solution(int k) {
		long answer = -1;
		return answer;
	}

	public static void permutation(int[] arr, int[] out, int depth, int sum, int targ) {
		if (sum == targ) {
			for (int num : out)
				System.out.print(num);
			System.out.println();
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			out[depth] = arr[i];
			permutation(arr, out, depth + 1, sum + arr[i], targ);
		}
	}

	public static void main(String[] args) {
		int[] arr = {2, 3, 4, 5, 6, 7};
		int targ = 2;
		permutation(arr, new int[15], 0, 0, targ);
	}
}

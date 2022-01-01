package BaekJoon1744;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);

		int ans = 0;
		for (int neg = 0; (neg < arr.length) && (arr[neg] < 0); neg++) {
			int sum = arr[neg];
			if (canNegativeBind(arr, neg + 1)) {
				sum *= arr[neg + 1];
				neg++;
			}
			ans += sum;
		}

		for (int pos = arr.length - 1; (pos >= 0) && (arr[pos] > 1); pos--) {
			int sum = arr[pos];
			if (canPositiveBind(arr, pos - 1)) {
				sum *= arr[pos - 1];
				pos--;
			}
			ans += sum;
		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 1) {
				ans += 1;
			}
		}

		System.out.println(ans);

		br.close();
	}

	private static boolean canNegativeBind(int[] arr, int next) {
		return next < arr.length && arr[next] <= 0;
	}

	private static boolean canPositiveBind(int[] arr, int next) {
		return next >= 0 && arr[next] > 1;
	}
}

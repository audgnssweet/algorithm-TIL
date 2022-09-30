package 머지소트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int[] arr;
	static int[] temp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		temp = new int[N];

		mergeSort(0, N - 1);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]).append("\n");
		}
		sb.setLength(sb.length() - 1);

		System.out.println(sb);

		br.close();
	}

	private static void mergeSort(int start, int end) {
		if (start >= end) {
			return;
		}

		int mid = start + ((end - start) / 2);
		mergeSort(start, mid);
		mergeSort(mid + 1, end);

		int left = start;
		int right = mid + 1;
		int idx = start;
		while (left <= mid && right <= end) {
			if (arr[left] <= arr[right]) {
				temp[idx++] = arr[left++];
			} else {
				temp[idx++] = arr[right++];
			}
		}

		while (left <= mid) {
			temp[idx++] = arr[left++];
		}

		while (right <= end) {
			temp[idx++] = arr[right++];
		}

		for (int i = start; i <= end; i++) {
			arr[i] = temp[i];
		}
	}

	private static void print() {
		System.out.println(Arrays.toString(arr));
	}
}

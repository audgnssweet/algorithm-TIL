package 퀵소트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		quickSort(0, N - 1);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]).append("\n");
		}
		sb.setLength(sb.length() - 1);

		System.out.println(sb);

		br.close();
	}

	private static void print() {
		System.out.println(Arrays.toString(arr));
	}

	private static void quickSort(int start, int end) {
		if (start >= end) {
			return;
		}

		int pivot = arr[start];
		int left = start + 1;
		int right = end;

		//left 가 right 보다 커져야 중단
		while (true) {
			while (left <= right && arr[left] <= pivot) {
				left++;
			}
			while (left <= right && arr[right] > pivot) {
				right--;
			}

			if (right < left) {
				swap(start, right);
				break;
			}

			swap(left, right);
		}

		quickSort(start, right - 1);
		quickSort(right + 1, end);
	}

	private static void swap(int i1, int i2) {
		int temp = arr[i1];
		arr[i1] = arr[i2];
		arr[i2] = temp;
	}
}

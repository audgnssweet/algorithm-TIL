package hdi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		String[] strArr = input.split(" ");
		int[] arr = new int[strArr.length];

		for (int i = 0; i < strArr.length; i++) {
			arr[i] = Integer.parseInt(strArr[i]);
		}

		Arrays.sort(arr);

		int min = Integer.MAX_VALUE;
		int res = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			int gap = arr[i + 1] - arr[i];
			if (min > gap) {
				res = i;
				min = gap;
			}
		}

		System.out.println(arr[res] + " " + arr[res + 1]);

		br.close();
	}
}

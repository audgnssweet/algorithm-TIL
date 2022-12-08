package hdi;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main4 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] NJ = br.readLine().split(" ");
		int N = Integer.parseInt(NJ[0]);
		int J = Integer.parseInt(NJ[1]);

		int[] arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}

		for (int i = 0; i < J; i++) {
			String[] SE = br.readLine().split(" ");
			int start = Integer.parseInt(SE[0]);
			int end = Integer.parseInt(SE[1]);

			arr[start] = end;
		}

		int cur = 0, max = 0, res = 0; //cur 현재위치, max 최대위치 res 점프 횟수
		while (cur < arr.length - 1) {

			int next; //다음에 어디로 갈지
			for (int i = cur; i <= cur + 6; i++) {
				if (arr[i] > max) {

				}
			}
		}

		br.close();
	}
}

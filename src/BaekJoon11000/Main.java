package BaekJoon11000;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<int[]> startPq = new PriorityQueue<>((a1, a2) -> (a1[0] - a2[0]));
		for(int i = 0; i < N; i++) {
			String[] startEnd = br.readLine().split(" ");
			startPq.offer(new int[]{Integer.parseInt(startEnd[0]), Integer.parseInt(startEnd[1])});
		}

		//초기화 끝
		int ans = 0;
		PriorityQueue<int[]> endPq = new PriorityQueue<>((a1, a2) -> (a1[1] - a2[1]));
		while(!startPq.isEmpty()) {
			int[] curStartFastest = startPq.poll();

			while(!endPq.isEmpty() && endPq.peek()[1] <= curStartFastest[0]) {
				endPq.poll();
			}

			endPq.offer(curStartFastest);
			ans = Math.max(ans, endPq.size());
		}

		System.out.println(ans);
		br.close();
	}
}

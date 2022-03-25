package BaekJoon1715;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> n1 - n2);
		for(int i = 0; i < N; i++) {
			pq.offer(Integer.parseInt(br.readLine()));
		}
		//초기화 끝

		int ans = 0;
		while(pq.size() >= 2) {
			int cur = pq.poll() + pq.poll();
			ans += cur;
			pq.offer(cur);
		}

		System.out.println(ans);

		br.close();
	}
}

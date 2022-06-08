package BaekJoon1655;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

	public static void main2(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			int cur = Integer.parseInt(br.readLine());
			int pos = Collections.binarySearch(list, cur);

			pos = pos < 0 ? Math.abs(pos) - 1 : pos;
			list.add(pos, cur);

			int midIdx = list.size() % 2 == 0 ? list.size() / 2 - 1 : list.size() / 2;
			sb.append(list.get(midIdx)).append("\n");
		}

		System.out.println(sb.toString());
		br.close();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		PriorityQueue<Integer> maxq = new PriorityQueue<>((a, b) -> b - a);
		PriorityQueue<Integer> minq = new PriorityQueue<>((a, b) -> a - b);

		for (int i = 0; i < N; i++) {
			int cur = Integer.parseInt(br.readLine());
			if (maxq.size() == minq.size()) {
				maxq.offer(cur);
			} else {
				minq.offer(cur);
			}

			if ((!maxq.isEmpty()) && (!minq.isEmpty()) && (maxq.peek() > minq.peek())) {
				int left = maxq.poll();
				int right = minq.poll();
				maxq.offer(right);
				minq.offer(left);
			}

			sb.append(maxq.peek()).append("\n");
		}

		System.out.println(sb);
		br.close();
	}
}

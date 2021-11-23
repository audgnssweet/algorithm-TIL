package BaekJoon1202;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] info = br.readLine().split(" ");
        int N = Integer.parseInt(info[0]);
        int K = Integer.parseInt(info[1]);

        int[][] jewel = new int[N][];
        for (int i = 0; i < N; i++) {
            String[] jewelInfo = br.readLine().split(" ");
            jewel[i] = new int[]{Integer.parseInt(jewelInfo[0]), Integer.parseInt(jewelInfo[1])};
        }

        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        //가방 무게 오름차순
        Arrays.sort(bags);
        //보석 무게 오름차순 정렬
        Arrays.sort(jewel, (a1, a2) -> a1[0] - a2[0]);

        //합이 int 범위를 벗어날 수 있음.
        long ans = 0;
        //보석을 꺼낼땐 가격이 비싼 순서대로
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> (n1 - n2) * -1);
        int idx = 0;
        for (int i = 0; i < bags.length; i++) {
            //현재 무게까지 넣을 수 있는 것들을 다 후보로 넣고
            while (idx < jewel.length && jewel[idx][0] <= bags[i]) {
                pq.offer(jewel[idx][1]);
                idx++;
            }

            //가장 비싼 것을 꺼낸다.
            if (!pq.isEmpty()) {
                ans += pq.poll();
            }
        }
        System.out.println(ans);
    }
}

package ProgrammersLevel3.DiskController;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

    public static int solution(int[][] jobs) {
        Arrays.sort(jobs, (a1, a2) -> a1[0] - a2[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> jobs[i1][1] - jobs[i2][1]);

        int cur = 0, terminated = 0, idx = 0, sum = 0;
        //모든 대기열이 실행되어 종료될 때까지
        while (terminated < jobs.length) {

            //현재 시간과, 대기할 수 있는 것들 다 대기열에 넣는다.
            while (idx < jobs.length && jobs[idx][0] <= cur) {
                pq.offer(idx++);
            }

            //현재 프로세스가 실행중이 아니라면 새로운걸 꺼내야하고
            if (!pq.isEmpty()) {
                int next = pq.poll();
                //대기시간 + 실행시간 을 더해준다.
                sum += (cur - jobs[next][0] + jobs[next][1]);
                cur += jobs[next][1];
                terminated++;
            } else {
                //실행중이라면 넘어가면 된다.
                cur++;
            }
        }

        return sum / jobs.length;
    }

    public static void main(String[] args) {
        solution(new int[][]{
            {0, 3},
            {1, 9},
            {2, 6}
        });
    }
}

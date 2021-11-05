package N_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());

        List<Integer> res = new LinkedList<>();
        res.add(1);
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < count; i++) {

            //branch로 삽입하는 경우
            //pq가 비어있으면 끝번호 + 1을 삽입하고,
            //pq가 비어있지 않다면 해당 번호를 삽입하되, binarySearch로 해당 위치에 삽입한다.
            String curLine = br.readLine();
            if (curLine.charAt(0) == 'b') {
                if (pq.isEmpty()) {
                    res.add(res.get(res.size() - 1) + 1);
                } else {
                    int input = pq.poll();
                    int idx = Math.abs(Collections.binarySearch(res, input) + 1);
                    res.add(idx, input);
                }
            } else {
                //merge 하는 경우
                //list에서 지우면서 동시에 pq에 넣어준다.
                Integer rem = Integer.valueOf(curLine.split(" ")[1]);
                res.remove(rem);
                pq.offer(rem);
            }
        }

        for (int num : res) {
            bw.write(num + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

package TruckPassingThroughTheBridge;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    static class Truck {

        int weight;
        int remainLength;

        public Truck(int weight, int remain) {
            this.weight = weight;
            this.remainLength = remain;
        }
    }

    static Queue<Truck> q = new LinkedList<>();

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int res = 0;
        int remainWeight = weight;
        int curTruck = 0;
        while (curTruck != truck_weights.length) {
            if (remainWeight >= truck_weights[curTruck]) {
                q.offer(new Truck(truck_weights[curTruck], bridge_length));
                remainWeight -= truck_weights[curTruck];
                curTruck += 1;
            }

            q.forEach(truck -> truck.remainLength -= 1);
            if (!q.isEmpty() && q.peek().remainLength <= 0) {
                Truck poll = q.poll();
                remainWeight += poll.weight;
            }
            res += 1;
        }

        return res + bridge_length;
    }

}

package GasStation;

public class OtherGasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curr = 0, total = 0, start = 0;
        for (int i = 0; i < gas.length; i++) {
            curr += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if (curr < 0) {
                start = i + 1;
                curr = 0;
            }
        }
        return total < 0 ? -1 : start;
    }
}

package GasStation;

public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] tmp = new int[gas.length];
        int plus = 0;
        int minus = 0;
        for (int i = 0; i < gas.length; i++) {
            tmp[i] = gas[i] - cost[i];
            plus += gas[i];
            minus += cost[i];
        }

        if (plus < minus) {
            return -1;
        }

        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i] >= 0) {
                int now = tmp[i];
                int idx = (i == tmp.length - 1) ? 0 : i + 1;
                while (now >= 0 && i != idx) {
                    now += tmp[idx];
                    idx = idx == tmp.length - 1 ? 0 : idx + 1;
                }

                if (idx == i) {
                    return i;
                }
            }
        }

        return -1;
    }
}

package KnapsackNotDividable;

public class KnapsackNotDividable {

    public int knapsack(int[][] cargo, int capacity) {
        int[][] res = new int[cargo.length + 1][capacity + 1];

        for (int num = 0; num <= cargo.length; num++) {
            for (int c = 0; c <= capacity; c++) {
                if (num == 0 || c == 0) {
                    continue;
                } else if (cargo[num - 1][1] <= c) {    //현재 물건 하나만 들어가도 전의 이윤 싹다 씹어먹을 수 있기 때문에
                    // 이 물건을 넣고나서 남은 무게로 채울 수 있는 최대 이윤 vs. 이 물건을 안넣고 얻었던 이전까지의 이 무게까지의 최대이윤
                    res[num][c] = Math.max(
                        cargo[num - 1][0] + res[num - 1][c - cargo[num - 1][1]],
                        res[num - 1][c]
                    );
                } else {
                    res[num][c] = res[num - 1][c];
                }
            }
        }

        return res[cargo.length][capacity];
    }

    public static void main(String[] args) {
        KnapsackNotDividable knapsackNotDividable = new KnapsackNotDividable();
        int res = knapsackNotDividable.knapsack(new int[][]{
                {4, 12},
                {2, 1},
                {10, 4},
                {1, 1},
                {2, 2}
            },
            15
        );
        System.out.println(res);
    }
}

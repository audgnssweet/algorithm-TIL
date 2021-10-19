package BaekJoon11724;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<Integer>[] graph;
    static boolean[] visit;
    static int visited = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] first = br.readLine().split(" ");

        int vNum = Integer.parseInt(first[0]);
        int eNum = Integer.parseInt(first[1]);

        visit = new boolean[vNum + 1];
        graph = new ArrayList[vNum + 1];
        for (int i = 1; i <= vNum; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < eNum; i++) {
            String[] nextLine = br.readLine().split(" ");
            int left = Integer.parseInt(nextLine[0]);
            int right = Integer.parseInt(nextLine[1]);

            graph[left].add(right);
            graph[right].add(left);
        }

        int count = 0;
        int start = 1;
        while (visited != vNum) {
            dfs(start);
            count += 1;

            for (int i = 1; i <= vNum; i++) {
                if (!visit[i]) {
                    start = i;
                    break;
                }
            }
        }

        System.out.println(count);
    }

    private static void dfs(int start) {
        visit[start] = true;
        visited += 1;

        for (int i = 0; i < graph[start].size(); i++) {
            int nextNode = graph[start].get(i);
            if (!visit[nextNode]) {
                dfs(nextNode);
            }
        }
    }
}

package 양과늑대;

import java.util.*;

class Solution {

    static int res = 1;
    static List<Integer>[] graph;
    static boolean[][][] visited;
    static int[] infos;

    public int solution(int[] info, int[][] edges) {
        int answer = 0;

        infos = info;
        graph = new List[info.length];
        for(int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        visited = new boolean[info.length][info.length + 1][info.length + 1];

        dfs(0, 0, 0);

        return res;
    }

    void dfs(int cur, int s, int w) {
        if(infos[cur] == 0) {
            s++;
        } else if (infos[cur] == 1) {
            w++;
        }

        if(w >= s) {
            return;
        }

        res = Math.max(res, s);
        int temp = infos[cur];
        for(int next : graph[cur]) {
            if(!visited[cur][s][w]) {
                visited[cur][s][w] = true;
                infos[cur] = -1;
                dfs(next, s, w);
                infos[cur] = temp;
                visited[cur][s][w] = false;
            }
        }
    }
}

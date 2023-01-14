package 외벽점검;

import java.util.*;

class Solution {

    int min = Integer.MAX_VALUE;

    public int solution(int n, int[] weak, int[] dist) {
        List<int[]> weaks = new ArrayList<>();
        for(int i = 0; i < weak.length; i++) {
            weaks.add(makeWeak(i, weak, n));
        }

        List<int[]> dists = new ArrayList<>();
        permutation(0, new int[dist.length], new boolean[dist.length], dist, dists);

        for(int[] w : weaks) {
            for(int[] d : dists) {
                doSenario(w, d);
            }
        }
        if(min == Integer.MAX_VALUE) {
            min = -1;
        }

        return min;
    }

    void doSenario(int[] w, int[] d) {
        int res = 0;
        int wIdx = 0;
        for(int i = 0; i < d.length; i++) {
            int max = w[wIdx] + d[i];
            while(wIdx < w.length && w[wIdx] <= max) {
                wIdx++;
            }
            res++;
            if(wIdx == w.length) {
                break;
            }
        }
        if(wIdx == w.length) {
            min = Math.min(min, res);
        }
    }

    int[] makeWeak(int start, int[] weak, int n) {
        int[] w = new int[weak.length];
        int temp = 0;
        for(int i = start; i < weak.length; i++) {
            w[temp++] = weak[i];
        }
        for(int i = 0; i < start; i++) {
            w[temp++] = weak[i] + n;
        }
        return w;
    }

    void permutation(int cur, int[] temp, boolean[] visited, int[] dist, List<int[]> dists) {
        if(cur == dist.length) {
            dists.add(Arrays.copyOf(temp, temp.length));
        } else {
            for(int i = 0; i < dist.length; i++) {
                if(!visited[i]) {
                    visited[i] = true;
                    temp[cur] = dist[i];
                    permutation(cur + 1, temp, visited, dist, dists);
                    visited[i] = false;
                }
            }
        }
    }

}
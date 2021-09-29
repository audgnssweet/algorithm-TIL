package TakePictures;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    static char[] temp = new char[8];
    //DFS를 위한 visited 배열
    static boolean[] visited = new boolean[8];
    static char[] friends = new char[]{'A', 'N', 'F', 'J', 'R', 'M', 'C', 'T'};
    static int answer = 0;
    static String[] d;
    static Map<Character, Integer> map = new HashMap<>();

    public int solution(int n, String[] data) {

        d = data;
        dfs(0);

        return answer;
    }

    static void dfs(int curPos) {
        if (curPos == 8) {
            //끝까지 채워진경우 검사하고 맞으면 채우기
            if (check()) {
                answer += 1;
            }
        } else {
            //중간인 경우 DFS
            for (int i = 0; i < friends.length; i++) {

                if (!visited[i]) {
                    //DFS를 위한 넣기
                    visited[i] = true;
                    temp[curPos] = friends[i];
                    map.put(friends[i], curPos);

                    dfs(curPos + 1);

                    //DFS를 위한 빼기
                    visited[i] = false;
                    map.remove(friends[i]);
                }

            }
        }
    }

    static boolean check() {
        for (String s : d) {
            char friend1 = s.charAt(0);
            char friend2 = s.charAt(2);
            int gap = s.charAt(4) - '0';
            char oper = s.charAt(3);

            int friend1Pos = map.get(friend1);
            int friend2Pos = map.get(friend2);

            if (oper == '=' && Math.abs(friend1Pos - friend2Pos) != (gap + 1)) {
                return false;
            } else if (oper == '<' && Math.abs(friend1Pos - friend2Pos) > gap) {
                return false;
            } else if (oper == '>' && Math.abs(friend1Pos - friend2Pos) < gap + 2) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(2, new String[]{"N~F=0", "R~T>2"});
    }
}

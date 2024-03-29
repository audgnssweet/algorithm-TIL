<h5> 다익스트라 알고리즘 </h5>

https://ratsgo.github.io/data%20structure&algorithm/2017/11/26/dijkstra/

### 대표적인 Greedy 알고리즘

<p>
다익스트라는, 최단 경로를 찾는 대표적인 기법 가운데 하나이다.<br />
너비 우선 탐색을 토대로 한다.<br />
처음에 시작노드 제외 모든 노드의 거리정보를 무한으로 초기화하고,<br />
시작노드를 기준으로 BFS를 적용한다. (탐색한 것은 탐색했다고 표기한다)<br />
탐색된 노드들 중, 가장 가중치가 작은 것을 다음 BFS 시작점으로 선택한다.<br />
이런 방식으로 모든 노드가 초기화되면,<br />
한 시작점으로부터 다른 모든 노드로의 최단 경로를 구할 수 있다.<br />
</p>

    한 곳에서 다른 모든 곳으로 가는 최단경로 구하기

    1. 최소 비용의 최단경로 구하기
    -> BFS를 이용하는 대표적인 알고리즘
    -> 정점을 더할 때, 해당 정점까지의 최단거리는 계산을 끝냈다는 확신을 가짐
    -> 이후에 더 짧은 경로가 존재한다면, 알고리즘의 논리적 기반이 무너진다.
    -> 그러므로 최장 거리를 구하는데는 사용이 불가능하다.

    2. 모든 정점이 출발지에서 도달이 가능하다면, 시간복잡도는
    O(E log V) 가 된다.

---

## 다익스트라 JAVA Code

```java
public class Solution {

    static class Edge {

        int v;
        int w;

        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    static List<List<Edge>> graph = new ArrayList<>();
    static boolean[] visit;
    static Edge[] edges;

    static void init(int N, int[][] road) {
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : road) {
            graph.get(edge[0]).add(new Edge(edge[1], edge[2]));
            graph.get(edge[1]).add(new Edge(edge[0], edge[2]));
        }

        edges = new Edge[N + 1];
        edges[1] = new Edge(1, 0);
        for (int i = 2; i <= N; i++) {
            edges[i] = new Edge(i, Integer.MAX_VALUE);
        }

        visit = new boolean[N + 1];
    }

    public static int solution3(int N, int[][] road, int K) {
        init(N, road);
        PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> e1.w - e2.w);
        for (int i = 1; i < edges.length; i++) {
            //edge를 직접 넣어준다.
            pq.offer(edges[i]);
        }

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            for (Edge next : graph.get(cur.v)) {
                //기존꺼랑 비교해서 새로운게 더 작으면 바꿔줌
                if (!visit[next.v] && edges[next.v].w > edges[cur.v].w + next.w) {
                    //PQ 안의 값을 직접번경해주기 때문에 메모리를 아낄 수 있음.
                    edges[next.v].w = edges[cur.v].w + next.w;
                    //값이 바뀌면 재정렬을 해주어야 한다.
                    pq.remove(edges[next.v]);
                    pq.add(edges[next.v]);
                }
            }
            visit[cur.v] = true;
        }

        int res = 0;
        for (int i = 1; i < edges.length; i++) {
            if (edges[i].w <= K) {
                res += 1;
            }
        }
        return res;
    }
}

```
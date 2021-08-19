<h5> 다익스트라 알고리즘 </h5>

https://ratsgo.github.io/data%20structure&algorithm/2017/11/26/dijkstra/

<p>
다익스트라는, 최단 경로를 찾는 대표적인 기법 가운데 하나이다.<br />
너비 우선 탐색을 토대로 한다.<br />
처음에 시작노드 제외 모든 노드의 거리정보를 무한으로 초기화하고,<br />
시작노드를 기준으로 BFS를 적용한다. (탐색한 것은 탐색했다고 표기한다)<br />
탐색된 노드들 중, 가장 가중치가 작은 것을 다음 BFS 시작점으로 선택한다.<br />
이런 방식으로 모든 노드가 초기화되면,<br />
한 시작점으로부터 다른 모든 노드로의 최단 경로를 구할 수 있다.<br />
</p>
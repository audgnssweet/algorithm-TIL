## 이진 탐색 트리 노드간 최소 거리

https://leetcode.com/problems/minimum-distance-between-bst-nodes

---

<h5>내 풀이법</h5>

    1. DFS를 통한 Brute Force방식을 사용했다.
    각 노드별로 오른쪽에서 왼쪽에서 가장 작은값, 오른쪽에서 가장 큰 값을 구하는 방식을 이용했다.

---

<h5> 또 다른 풀이 </h5>

    1. LVR 중위 순위를 이용
    2. 중요한 점은 왼쪽 가운데 오른쪽으로 순회를 하기 때문에,
    temp로 둔 변수를 node.val로 수정하면 1단계씩 커지는 효과를 낳을 수 있다는 점이다.
    (중요)
<h5>Greedy</h5>

    1. 항상 주어진 상황에서 최선을 선택하는 Greedy
    2. 그러므로 항상 최적해를 보장하지는 않는다.(마시멜로 문제)

    어떤 상황에 잘 동작하는가?
    -> 최적 부분 구조
    최적 부분 구조란, 지금의 선택이 다음 선택과는 전혀 무관한 경우,
    즉, 선택끼리 영향을 주지 않는 경우에 잘 동작한다.
    -> 부분해들의 집합이 곧 최적해인 경우만 

    어떤 상황에 실패하는가?
    -> TSP나 Knapsack같은 경우 실패한다.

---

<h5>다익스트라</h5>

    1. 최소 비용의 최단경로 구하기
    -> BFS를 이용하는 대표적인 알고리즘
    -> 정점을 더할 때, 해당 정점까지의 최단거리는 계산을 끝냈다는 확신을 가짐
    -> 이후에 더 짧은 경로가 존재한다면, 알고리즘의 논리적 기반이 무너진다.
    -> 그러므로 최장 거리를 구하는데는 사용이 불가능하다.

    2. 모든 정점이 출발지에서 도달이 가능하다면, 시간복잡도는
    O(E log V) 가 된다.
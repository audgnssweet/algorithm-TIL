## 일정 재구성

https://leetcode.com/problems/reconstruct-itinerary

---

<h5>내 풀이법</h5>

    1. DFS를 통한 백트래킹을 이용
    2. Map<String, List<String>> 자료구조를 이용

<h5>정리</h5>

    1. 기본적으로 if분기문이 너무 많았다. 코드가 지저분
    2. 끝내는 조건을 isEnd로 두었는데, 그것도 별로 좋지못한 선택이었다
    -> 그러나 끝내는 조건없이 add(0,from) 생각을 하기가 굉장히 어렵다.

---

<h5>정석풀이</h5>

    1. Map<String, PriorityQueue<String>> 을 이용해 정렬하는 시간을 아꼈다.
    -> 뭔가 정렬할 일이 있으면 반드시 PQ를 먼저 생각해야겠다.
    -> 자료구조의 선택부터 큰 차이가 났던 것 같다.
    2. 끝내는 조건을 너무 깔끔하게 만들었다. 몇번 탐색을 하든 결국 from을 첫 번째에 넣는다는게
    완벽한 풀이었던 것 같다.

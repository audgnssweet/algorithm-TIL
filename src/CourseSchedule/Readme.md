https://leetcode.com/problems/course-schedule

---

<h5>정석 풀이</h5>

    1. DFS인데, visited와 traced를 이용해서 루프검사를 하는 방식

<h5>정리</h5>

    1. trace와 visited를 나눈다는 생각이 중요한 것 같다.
    -> visitied는 중복탐색을 막기 위해 알고리즘 전체적으로 탐색을 했는지 판별 (가지치기)
    -> traced는 현재 루프에서 이미 탐색했는지 판별
    2. DFS가 계속 타고 들어가다가 백트래킹을 하는 것이기 때문에,
    타고 들어가다가 다시 나왔을 때 자기 자신으로 돌아왔을 때 처리방법을 잘 생각하면 좋은 것 같다. (매우중요)

---

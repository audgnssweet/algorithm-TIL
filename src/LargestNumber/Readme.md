## 가장 큰 수

https://leetcode.com/problems/largest-number

---

<h5>내 풀이법</h5>

    1. Priority Queue를 이용해, 삽입시 자동 정렬되도록 로직을 구성했다.

    2. 시간이 느린 편이었는데 좋은 방법인지는 모르겠다.
    
---

<h5> 다시 풀이법 </h5>

    1. int 자료형을 String으로 만들어버리기
    -> + "" 을 더해서

    2. Java의 Arrays.sort는 기본적으로 오름차순 정렬 (작은 것부터)

    3. Java의 Priority queue도 기본적으로 오름차순 정렬 (작은 것부터)

    그냥 기본이 작은 것부터라고 생각하면 된다. String도 마찬가지
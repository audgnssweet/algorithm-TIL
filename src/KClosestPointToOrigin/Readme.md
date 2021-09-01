## 원점에 K번째로 가까운 점

https://leetcode.com/problems/k-closest-points-to-origin

---

<h5> 내 풀이법 </h5>

    1. Priority Queue를 이용해, 삽입시 자동 정렬되도록 로직을 구성했다.
    
---

<h5> 생각 </h5>

    1. 곧이곧대로 Sqrt 연산을 적용해서 PQ에서 순서를 나열했었는데,
    단순히 Sqrt 하기 전의 크기만으로 비교해도 결과는 똑같아서
    Sqrt를 없애니 연산속도가 훨씬 증가했다.
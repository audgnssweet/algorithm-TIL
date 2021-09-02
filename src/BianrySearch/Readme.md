https://leetcode.com/problems/binary-search

---

<h5>풀이</h5>

    1. 배열로 binary search 구현

---

<h5> 새로 배운 것 </h5>

    보통 자료형에는 크기의 제한이 있기 때문에, 예를들어 int형이라면
    21억을 넘겨버리면 전혀 다른숫자가 되어버린다.

    그래서 중앙값을 구할 때 (start + end) / 2 로 구하지 말고
    start + (end - start) / 2 로 구해야한다.
    

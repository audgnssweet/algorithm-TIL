https://leetcode.com/problems/group-anagrams

---

<h5>내 풀이법</h5>

    1. 문자열을 문자 배열로 다루는 접근 (Most Common Word에서와 비슷하게)
    2. 문자열 길이, 문자들의 합, 문자들의 곱이 같으면 같은 문자열이라 판단
    3. HashMap을 이용해서 검색 및 갱신, OrDefault method 활용
    4. Map 변수를 필드로 선언

<h5>정리</h5>

    1. 속도가 매우 느렸다.
    2. 접근 방식 자체가, 시간 절약 면에서 sort를 고려하는 방향이 더 옳았다.

---

<h5>정석풀이</h5>

    1. 함수를 쪼개지말고 main에 넣는 것이 더 빨랐음
    2. getOrDefault 내장메서드보다 if else가 더 빨랐음
    3. Map을 필드 말고 main 내부에 선언하는 것이 더 빨랐음
    4. Arrays.toString()은 너무 느리니 무조건 피하고, 대신 생성자를 활용해야 한다.
    5. 문자열은 sorting을 항상 고려해야 한다.

---
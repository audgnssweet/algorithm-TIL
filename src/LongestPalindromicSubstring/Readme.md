## 가장 긴 팰린드롬 부분 문자열

https://leetcode.com/problems/longest-palindromic-substring

---

<h5>내 풀이법</h5>

    첫 번쨰 풀이
    1. DP로 접근했으나, 실행 시간초과로 풀이 자체를 실패했음
    2. 접근 자체를 잘못했음
    
    두 번째 풀이
    1. 슬라이딩 윈도우를 재귀함수로 접근했음

<h5>정리</h5>

    첫 번째 풀이
    1. 속도가 매우 느렸다.
    2. 접근 자체가 잘못되었다.

    두 번째 풀이
    1. 슬라이딩 윈도우를 재귀함수로 접근하여 속도가 매우 느렸음
    2. subString 내장함수를 남발했더니 매우 느렸음

---

<h5>정석풀이</h5>

    1. 문자열을 문자 단위로 바라보는 시각
    2. 슬라이딩 윈도우 방식
    3. 문자열을 짝수단위로 자르는방식, 홀수 단위로 자르는 방식에 대해서 공부함

---
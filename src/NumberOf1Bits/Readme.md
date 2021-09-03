## 1비트의 개수

https://leetcode.com/problems/number-of-1-bits/

### 풀이

    Integer.bitCount() 메서드를 사용했다.

### 정석

    임의의 수 n을 n-1과 xor & 연산을 할 시에, 1인 비트가 1개씩 없어진다.
    이 점을 이용할 수 있다.
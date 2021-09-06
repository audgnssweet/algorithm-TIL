## 가장 긴 반복문자 대체

https://leetcode.com/problems/longest-repeating-character-replacement/

### 내 풀이법

    sliding window를 활용했다.
    k가 음수가 될 때까지 cur을 앞으로 이동시키면서 길이를 늘려가고,
    음수가 되면 left를 k가 0이 되는 곳으로 줄일 때까지 이동시켰다.
    
    위와 같은 매커니즘으로 cur이 끝까지 이동하면, maxLen을 구할 수 있었다.

### 다른 풀이

    이해가 잘 안된다. 질문사항
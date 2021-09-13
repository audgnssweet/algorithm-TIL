## Gas Station

https://leetcode.com/problems/gas-station/

    사실상 brute force 방법으로 해결했다.

    조건은
    1. 먼저 합보다 차가 크면 바로 -1 return
    2. 출발조차 못하는 곳은 거르고 다음부터 시작

#### 1등풀이
    
    O(n) 에 풀 수 있는 방법
    total은 처음부터 끝까지 계속 더하며 가져가면서,
    cur도 마찬가지로 더해가다가 음수가 되는 순간 시작점을 다음순서로 바꿔주고

    마지막에 total을 체크함으로써 완결.
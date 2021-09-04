## 최대 슬라이딩 윈도우

https://leetcode.com/problems/sliding-window-maximum/

### 내 풀이

    DP를 이용해서 1개씩 묶었을 때 가장 큰 것, 2개씩 묶었을 때 가장 큰 것 ... k개씩 묶었을 때 가장 큰 것
    으로 해결하려고 했으나 시간 초과가 났다.

    Brute Force 방법 역시 시간 초과였다.

    가장 큰 값을 구해놓고 그 큰 값의 인덱스가 빠질 때만 새로운 값을 스캔해서 구하게 했더니
    최적화가 조금은 되긴 했지만, 그래도 너무 느렸다.

### best -1 풀이

    생각 자체가 dq에 곧이곧대로 숫자를 다 넣는다는 생각이 아니었다.
    더 작은 것은 dq에서 빼버리는 방식을 취해서 (스택처럼)
    무조건 가장 앞에는 가장 큰 수가 위치하도록 했다.

    그래서 이번 수가 idx에서 빠진건지 아닌지를 구할 때는 원래 배열을 이용해서 구했다.
    
    최적화 하기 매우 어려운 문제였다.
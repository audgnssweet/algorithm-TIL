## 2개 이하로 다른 비트

    map으로 캐싱하고, bit masking을 이용했다.
    대충 + 1 하고 오른쪽부터 1로 채워나가면 풀리는 규칙이 있었다.

    실수한 부분은 masking할 때 mask를 int type으로 잡았던 것이다.
    long type으로 잡아야 masking이 31자리 이상 되었을 때도 정상적으로 동작한다.

    자료형이 long타입을 넘어서면 반드시 long type으로 고려해야 한다.
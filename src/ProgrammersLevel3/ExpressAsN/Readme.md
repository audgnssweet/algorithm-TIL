## 프로그래머스 N으로 표현

    동적 계획법이었는데, 굉장히 어려운 문제였다.

    8개 이하의 N으로 만들 수 있는 숫자에 포함되는지 확인하는 것이었는데
    
    1개 : N
    2개 : NN, 1개 전부에 사칙연산
    3개 : NNN, 2개 전부에 사칙연산, 1개 전부에 2개 전부를 사칙연산
    ...
    해서 DP로 해결하는 문제였고, 중복은 Set으로 해결해야 했다.

---

    DP 라는걸 알고 풀어도 어떤식으로 접근해야할지가 어려웠다.
    Set배열을 통해 전부를 1개일때 -> 8개일때로 늘려가며
    각 모든 요소끼리 연산하는 방식이 인상적이었다.
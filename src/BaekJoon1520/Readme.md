## 백준 1520 내리막길

    이번 문제로 많은 것을 배웠다.
    
    우선 겹치는 경로를 탐색하는 문제는 DFS + DP 를 사용해야 한다는 것이 중요점이었다.

    1.
    내가 놓쳤던 점은 이미 탐색된 경로일 경우 단순하게 1만 더해줬던 점이었다.
    이미 탐색된 노드를 마주치더라도, 그 이후에 분기되어 더 많은 경우의 수가 생길 수 있다.

    2.
    또 중요한 점은 가장 먼저 -1로 초기화해 주었다가 탐색 시작시 0으로 초기화해주어야 한다는 점이었다.
    처음부터 0으로 초기화를 한 상태에서는 이미 탐색 해서 0개인지, 아니면 탐색 했는데 0개인지 모르기 때문에
    이미 방문한 경로를 다시 한 번 탐색할 수 있기 때문이다.
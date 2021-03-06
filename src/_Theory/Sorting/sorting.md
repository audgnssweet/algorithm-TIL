<h3> 정렬 </h3>

    목록의 요소를 특정 순서대로 넣는 알고리즘이다.
    대개 숫자식 순서와 사전식 순서로 정렬한다.

    빅오, 분할정복, 힙, 이진트리, 시공간 트레이드오프 등 핵심 주제를 아우르기 때문에
    알고리즘에 입문하기 좋다.

---

    1. 버블정렬

    시간복잡도가 O(n^2)이 나오는 알고리즘으로, 효율이 구려 사용하지 않는다.

---

    2. 병합 정렬

    시간복잡도가 O(n log n) 이다. 최선일때도, 최악일때도 마찬가지이다.
    퀵 정렬보다 일반적으로 살짝 느리지만, 최악인 경우에도 O(n log n) 을 보장한다는 점에서
    안정적인 정렬이다.

---

    3. 퀵 정렬

    피벗을 기준으로 좌우를 나누는 특징이 있다. 이 또한 분할 정복 알고리즘이며 
    피벗보다 작으면 왼쪽, 피벗보다 크면 오른쪽으로 보낸다.

    시간 복잡도가 O(n log n) 으로 보통은 가장 빠른 정렬속도를 보이나,
    이미 정렬된 배열이 들어올 경우 분할정복의 이점을 이용할 수 없어
    최악의 경우 O(n^2)이 될 수 있다.

---

    4. 삽입 정렬

    왼쪽부터 시작하여 한개씩 자신의 자리를 찾아 정렬한다.
    이것도 마찬가지로 O(n^2) 시간이 걸린다.
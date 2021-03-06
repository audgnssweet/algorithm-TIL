<h4> 이진 탐색 트리 </h4>

---

이진 탐색 트리
    
    이진 트리에서 정렬이 추가된 버전으로, 최대 차수가 2인것 까지는 똑같으나
    새로운 노드가 추가될 때 정렬하며 삽입이 되는데, 비교하는 노드보다
    작으면 왼쪽 크면 오른쪽으로 정렬되는 트리를 의미한다.
    
    이진 탐색 트리가 강력한 점은 O(log n) 시간에 특정 노드의 탐색이 가능하다는 것이다.
    
    물론, 양쪽 균형이 잘 맞지 않는 이진 탐색 트리의경우 O(n) 시간까지 탐색시간이 증가할 수 있다.
    이를 해결하기 위해 나온 방법이 자가 균형 이진탐색 트리이다.

---

자가 균형 이진 탐색 트리

    BST에서 삽입, 삭제시 자동으로 높이를 작게 유지하는 이진 탐색트리이다.

    불균형과 균형 BST의 성능 차이는 매우 극심하기 때문에
    자가 균형 이진탐색트리가 만들어졌으며
    그 종류에는 AVL트리, 레드-블랙 트리(실무에서 빈번히 쓰인다)가 있다.
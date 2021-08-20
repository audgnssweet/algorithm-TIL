## 이진트리의 직렬화 & 역직렬화

https://leetcode.com/problems/serialize-and-deserialize-binary-tree

---

<h5>풀이</h5>

    1. 이진 트리라는 점을 이용
    2. 이진 트리에서의 BFS식 순회방법을 이용
    3. 중간에 들어있는 null은, 결국에는 그 이후의 노드가 존재하는 것을 이용
    4. null일때는 아무 처리도 해주지 않음.
    5. int index를 따로 둬서, BFS순서대로 따라가며 노드를 삽입하도록 처리

---
## 색 정렬

https://leetcode.com/problems/sort-colors

---

<h5> 풀이 </h5>

    1. 네덜란드 국기 문제를 응용해서 풀어야 한다.

    3 그룹으로 나누어 정렬할 때 유용하게 사용할 수 있다.

---

<h5> 네덜란드 국기 문제 pseudo code </h5>

    three-way-partition(A: array of values, mid: value) :
        i <- 0
        j <- 0
        k <- size of A

        while j < k :
            if A[j] < mid :
                swap A[i] and A[j]
                i <- i + 1
                j <- j + 1
            else if A[j] > mid :
                k <- k - 1
                swap A[j] and A[k]
            else :
                j <- j + 1
package MergeSort;

import java.util.Arrays;

public class MergeSort {

    static void mergeSort(int[] arr, int start, int end) {
        if (end - start + 1 >= 2) {

            int mid = (start + end) / 2;

            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid + 1, end);
        }
    }

    static void merge(int[] arr, int start1, int start2, int end2) {
        int start = start1;
        int end1 = start2 - 1;
        int[] newArr = new int[end2 - start + 1];
        int idx = 0;
        while (start1 <= end1 && start2 <= end2) {
            if (arr[start1] > arr[start2]) {
                newArr[idx++] = arr[start2++];
            } else {
                newArr[idx++] = arr[start1++];
            }
        }

        while (start1 <= end1) {
            newArr[idx++] = arr[start1++];
        }

        while (start2 <= end2) {
            newArr[idx++] = arr[start2++];
        }

        for (int i = 0; i < end2 - start + 1; i++) {
            arr[i + start] = newArr[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        mergeSort(arr, 0, arr.length - 1);

        Arrays.stream(arr).forEach(System.out::println);
    }

}

package QuickSort;

import java.util.Arrays;

public class QuickSort {

    static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = end, left = start, right = end - 1;
        while (left <= right) {
            if (arr[left] < arr[pivot]) {
                left++;
                continue;
            }

            if (arr[right] > arr[pivot]) {
                right--;
                continue;
            }

            swap(arr, left, right);
            left++;
            right--;
        }
        swap(arr, left, pivot);

        quickSort(arr, start, left - 1);
        quickSort(arr, left + 1, end);
    }

    static void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 8, 7, 1, 3, 5, 6, 4};
        quickSort(arr, 0, arr.length - 1);

        Arrays.stream(arr).forEach(System.out::println);
    }

}

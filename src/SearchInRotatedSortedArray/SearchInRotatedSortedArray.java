package SearchInRotatedSortedArray;

public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid = 0;

        while (left != right) {
            mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        int pivot = left;    //가장 작은 값의 인덱스를 구했음
        left = 0;
        right = nums.length - 1;

        if (target > nums[nums.length - 1]) {
            right = pivot - 1;
        } else {
            left = pivot;
        }

        while (left <= right) {
            mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}

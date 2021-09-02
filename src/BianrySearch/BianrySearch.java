package BianrySearch;

public class BianrySearch {

    public int search(int[] nums, int target) {
        return binSearch(nums, target, 0, nums.length - 1);
    }

    private int binSearch(int[] nums, int target, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;    //정확하게 구하는 방법
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return binSearch(nums, target, mid + 1, end);
        } else {
            return binSearch(nums, target, start, mid - 1);
        }
    }
}

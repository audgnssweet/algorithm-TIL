package TwoSum2InputArrayIsSorted;

public class TwoSum2InputArrayIsSorted {

    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > target) {
                break;
            }

            int idx = binSearch(numbers, target - numbers[i], 0, numbers.length - 1);
            if (idx != -1) {
                if (idx != i) {
                    return new int[]{i + 1, idx + 1};
                } else if (numbers[idx] == numbers[idx - 1]) {
                    return new int[]{i + 1, idx};
                } else if (numbers[idx] == numbers[idx + 1]) {
                    return new int[]{i + 1, idx + 2};
                }
            }
        }
        return null;
    }

    private int binSearch(int[] numbers, int target, int left, int right) {
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;

            if (numbers[mid] == target) {
                return mid;
            } else if (numbers[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}

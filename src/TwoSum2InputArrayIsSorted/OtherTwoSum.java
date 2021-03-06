package TwoSum2InputArrayIsSorted;

public class OtherTwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int lo=0, hi=numbers.length-1;
        while(lo < hi) {
            if(numbers[lo] + numbers[hi] == target) {
                return new int[] {lo+1, hi+1};
            } else if(numbers[lo] + numbers[hi] < target) {
                lo++;
            } else {
                hi--;
            }
        }
        return new int[]{-1,-1};
    }
}

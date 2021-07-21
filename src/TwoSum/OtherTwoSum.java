package TwoSum;

import java.util.ArrayList;
import java.util.List;

public class OtherTwoSum {
    //1. 그냥 index vs. enhanced for = 그냥 index가 아주 약간더빠름
    //2. 반복문으로 리스트 만들기 vs. Stream으로 리스트 만들기 = 비슷함

    int[] twoSum(int[] nums, int target) {
        List<Integer> newNums = new ArrayList<>();
        for (int num : nums) {
            newNums.add(num);
        }

//        List<Integer> newNums = Arrays.stream(nums).boxed().collect(Collectors.toList());

        for (int i = 0; i < newNums.size(); i++) {
            int result = newNums.indexOf(target - newNums.get(i));
            if (result != -1 && result != i) {
                return new int[]{i, result};
            }
        }
        return null;
    }

}

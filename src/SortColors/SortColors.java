package SortColors;

public class SortColors {

    public void sortColors(int[] nums) {
        int red = 0, white = 0, blue = nums.length;

        while (white < blue) {
            if (nums[white] < 1) {
                swap(nums, red, white);
                red += 1; white += 1;
            } else if (nums[white] > 1) {
                blue -= 1;
                swap(nums, white, blue);
            } else {
                white += 1;
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}

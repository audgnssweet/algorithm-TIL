package TrappingRainWater;

public class OtherTrappingRainWater {

    //1번풀이 투포인터
    public int trap(int[] height) {
        int result = 0;
        int maxIndex = 0;
        for (int i = 1; i < height.length; i++) {
            if (height[maxIndex] < height[i]) {
                maxIndex = i;
            }
        }

        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        while (left < maxIndex) {
            if (height[left] >= leftMax) {
                leftMax = height[left];
            } else {
                result += (leftMax - height[left]);
            }
            ++left;
        }
        while (right > maxIndex) {
            if (height[right] >= rightMax) {
                rightMax = height[right];
            } else {
                result += (rightMax - height[right]);
            }
            --right;
        }

        return result;
    }

}

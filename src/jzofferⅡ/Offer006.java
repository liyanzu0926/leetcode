package jzofferⅡ;

/**
 * @Description
 * @Author lyz
 * @Date 2022/9/5 9:37
 */
public class Offer006 {
}

class Solution006 {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int local = numbers[i] + numbers[j];
            if (local < target) {
                i++;
            } else if (local > target) {
                j--;
            } else {
                return new int[]{i, j};
            }
        }
        return new int[0];
    }
}

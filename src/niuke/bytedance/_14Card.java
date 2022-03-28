package niuke.bytedance;

import java.util.*;

/**
 * 14张牌是否可以胡
 * https://www.nowcoder.com/questionTerminal/448127caa21e462f9c9755589a8f2416
 */
public class _14Card {
    static boolean flag;

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int[] nums = new int[10];
        for (int i = 0; i < 13; i++) {
            nums[cin.nextInt()]++;
        }

        for (int i = 1; i <= 9; i++) {
            if (nums[i] <= 3) {
                int[] card = Arrays.copyOf(nums, nums.length);
                card[i]++;
                flag = false;
                if (isHu(card, 1, 14)) {
                    System.out.print(i + " ");
                }
            }
        }
    }

    public static boolean isHu(int[] card, int start, int total) {
        if (total == 0) {
            flag = true;
            return flag;
        }
        // 把该牌当作雀头
        if (card[start] >= 2 && total % 3 != 0) {
            card[start] -= 2;
            if (card[start] == 0 && start + 1 <= 9) {
                flag = isHu(card, start + 1, total - 2);
            } else {
                flag = isHu(card, start, total - 2);
            }
            // 回溯，去判断下一种情况
            card[start] += 2;
        }
        // 把该牌当作顺子
        if (card[start] >= 3) {
            card[start] -= 3;
            if (card[start] == 0 && start + 1 <= 9) {
                flag = isHu(card, start + 1, total - 3);
            } else {
                flag = isHu(card, start, total - 3);
            }
            // 回溯，去判断下一种情况
            card[start] += 3;
        }
        // 把该牌当作刻子
        if (start + 2 <= 9 && card[start] > 0 && card[start + 1] > 0 && card[start + 2] > 0) {
            card[start]--;
            card[start + 1]--;
            card[start + 2]--;
            if (card[start] == 0) {
                flag = isHu(card, start + 1, total - 3);
            } else {
                flag = isHu(card, start, total - 3);
            }
            // 回溯，去判断下一种情况
            card[start]++;
            card[start + 1]++;
            card[start + 2]++;
        }
        // 这种牌没了，去判断下一种牌
        if (card[start] == 0) {
            flag = isHu(card, start + 1, total);
        }
        return flag;
    }
}

package com.ants.onehundredsixseven;

/**
 * @author lyy
 * @Deprecated
 * @date 2020/7/20
 */
public class Solution {
    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{5,25, 75}, 100);
        for (int item:ints){
            System.out.println(item);
        }


    }
    public static int[] twoSum(int[] numbers, int target) {

        int low = 0, high = numbers.length - 1;
        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum == target) {
                return new int[]{low + 1, high + 1};
            } else if (sum < target) {
                ++low;
            } else {
                --high;
            }
        }
        return new int[]{-1, -1};

    }
}

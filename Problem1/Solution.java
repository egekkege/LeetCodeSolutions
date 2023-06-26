package Problem1;

import java.util.HashMap;
import java.util.Map;

// Brute Force Solution
// Time Complexity: O(n^2)
// Space Complexity: O(1)
// 1. Iterate through the array
// 2. For each element, iterate through the rest of the array
// 3. If the sum of the two elements is equal to the target, return the indices
// 4. Else, continue iterating
// 5. If no indices are found, return an empty array

class Solution {
    /*
     * public int[] twoSum(int[] nums, int target) {
     * int[] arrToReturn = new int[2];
     * int index = 0;
     * for (int i = 0; i < nums.length; i++) {
     * for (int j = i + 1; j < nums.length; j++) {
     * if (nums[i] + nums[j] == target) {
     * arrToReturn[index] = i;
     * arrToReturn[index + 1] = j;
     * index += 2;
     * }
     * }
     * }
     * return arrToReturn;
     * }
     */

    // One-pass Hash Table Solution
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    // 1. Iterate through the array
    // 2. For each element, check if the complement is in the map
    // 3. If it is, return the indices
    // 4. Else, add the element to the map
    // 5. If no indices are found, return an empty array

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        // In case there is no solution, we'll just return null
        return null;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = { 2, 7, 11, 15 };
        int target = 9;
        int[] arrToReturn = sol.twoSum(arr, target);
        for (int i = 0; i < arrToReturn.length; i++) {
            System.out.print(arrToReturn[i] + " ");
        }
    }
}
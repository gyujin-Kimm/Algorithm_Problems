class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int answer = 1;
        int[] LIS = new int[n];

        for (int i = 0; i < n; i++) {
            LIS[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    LIS[i] = Math.max(LIS[i], LIS[j] + 1);
                }
            }
            answer = Math.max(answer, LIS[i]);
        }
        return answer;
    }

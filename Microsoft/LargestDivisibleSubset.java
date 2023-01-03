/*Problem link: https://leetcode.com/problems/largest-divisible-subset/description/ */

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums.length == 0) return new ArrayList();
        int n = nums.length;
        int[] count = new int[n];
        int[] pre = new int[n];
        int len = 1, idx = 0;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 && count[j] + 1 > count[i]) {
                    count[i] = count[j] + 1;
                    pre[i] = j;
                }
            }
            if (count[i] >= len) {
                len = count[i];
                idx = i;
            }
        }
        
        List<Integer> res = new ArrayList();
        for (int k = 0; k < len; ++k) {
            res.add(nums[idx]);
            idx = pre[idx];
        }
        return res;
    }
}

/*Submission Link: --> https://leetcode.com/problems/largest-divisible-subset/submissions/870564831/  */
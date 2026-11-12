class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        

        int max = 1;
        int inc = 1;
        int dec = 1;

        for(int i=1; i<nums.length; i++){

            inc = nums[i]>nums[i-1]? inc+1 : 1;
            dec = nums[i]<nums[i-1]? dec+1 : 1;

            max = Math.max(max, inc);
            max = Math.max(max, dec);
        }

        return max;
    }
}
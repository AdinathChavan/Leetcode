class Solution {
    public int maxSubArray(int[] nums) {

        int maxSum = nums[0];
        int currentSum = 0;

        for(int e : nums){

            currentSum +=e;

            maxSum = Math.max(maxSum, currentSum);

            if(currentSum<0){
                currentSum = 0;
            }

        }


        return maxSum;
    }
}
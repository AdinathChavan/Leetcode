class Solution {
    public int trap(int[] height) {

        int total = 0;

        int leftMax = height[0];
        int rightMax = height[height.length-1];

        int left = 0;
        int right = height.length-1;

        while(left<right){

            if(leftMax<rightMax){
                left++;
                leftMax = Math.max(leftMax, height[left]);
                total += leftMax-height[left];         
             }
             else{
                right--;
                rightMax = Math.max(rightMax, height[right]);
                total += rightMax-height[right];
             }

        }

        return total;
        
    }
}
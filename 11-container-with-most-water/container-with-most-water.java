class Solution {
    public int maxArea(int[] height) {

        int max = 0;

        int left =0;
        int right = height.length-1;

        while(left<right){

            if(height[left]<height[right]){
                max = Math.max((right-left)*height[left], max);
                left++;
            }else{
                max = Math.max((right-left)*height[right], max);
                right--;
            }
        }

        return max;
        
    }
}
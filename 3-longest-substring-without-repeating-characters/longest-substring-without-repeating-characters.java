class Solution {
    public int lengthOfLongestSubstring(String s) {

        int max =0; 

        int left =0;

        Set<Character> set = new HashSet<>();

        for(int i=0; i<s.length(); i++){

            char ch = s.charAt(i);

            while(set.contains(ch) && left<i){
                set.remove(s.charAt(left));
                left++;
            }

            set.add(ch);

            max = Math.max(max, i-left+1);
        }

        return max;
        
    }
}
class Solution {
    public String convert(String s, int numRows) {

        Map<Integer, String> map = new HashMap<>();

        if(numRows==1) return s;

        if(s.length()<numRows) return s;


        int i =0;
        int d =0;
        int m =0;

        while(i<s.length()){

           m=i;
           int j =d;
           while(j<numRows && m<s.length()){
                map.put(j, map.getOrDefault(j,"")+s.charAt(m));
                m++;
                j++;
            }

            int k = numRows-2;

            while(k>=0 && m<s.length()){
                map.put(k, map.getOrDefault(k,"")+s.charAt(m));
                m++;
                k--;
            }

            d=1;
            i=m;
        }

         String result = "";

         for(int a=0; a<numRows; a++){
            result+=map.get(a);
         }

         return result;
        
    }
}
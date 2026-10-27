class Solution {

    class Pair{
        int a;
        int b; 

        public Pair(int a, int b){
            this.a = a;
            this.b = b;
        }

        public int first(){
            return this.a;
        }
        public int second(){
            return this.b;
        }

        public String toString(){
           return "{"+a+" "+b+"}";
        }
    }


    public int numEnclaves(int[][] grid) {

        
        int m = grid.length;
        int n = grid[0].length;

        Queue<Pair> que = new LinkedList<>();
         // 1 -> 0  0-> -1  visited -> 2
       int[][] visited = new int[m][n];

       for(int i=0; i<m; i++){
        for(int j=0; j<n; j++){
            if(i==0 || j==0 || i==m-1 || j==n-1){
                if(grid[i][j]==1){
                    que.offer(new Pair(i,j));
                    visited[i][j]=2;
                }
            }
        }
       }

       System.out.println(que);

       int[] trav = {-1,+1};

       while(!que.isEmpty()){

           int row = que.peek().first();
           int col = que.peek().second();
           que.poll();

           for(int i=0; i<trav.length; i++){
              if(row+trav[i] < m && row+trav[i]>=0){
                if(grid[row+trav[i]][col]==1 && visited[row+trav[i]][col]!=2){
                    que.offer(new Pair(row+trav[i],col));
                    visited[row+trav[i]][col]=2;
                }
              }
           }

           for(int i=0; i<trav.length; i++){
              if(col+trav[i] < n && col+trav[i]>=0){
                if(grid[row][col+trav[i]]==1 && visited[row][col+trav[i]]!=2){
                    que.offer(new Pair(row,col+trav[i]));
                    visited[row][col+trav[i]]=2;
                }
              }
           }
       }

       

       int count =0;

       for(int i=0; i<m; i++){
        for(int j=0; j<n; j++){
            if(grid[i][j]==1 && visited[i][j]==0){
                count++;
            }
        }
       }

       return count;





       
        
    }
}
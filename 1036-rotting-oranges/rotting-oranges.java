class Solution {

    class Pair{
        int row;
        int col;
        int step;

        Pair(int a, int b, int c){
            this.row = a;
            this.col = b;
            this.step = c;
        }
    }
    public int orangesRotting(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int maxSteps = 0;

        int[][] visited = new int[m][n];

        Queue<Pair> que = new LinkedList<>();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==2){
                    que.offer(new Pair(i,j,0));
                }
            }
        }

        int[][] trav = { {1,0}, {0,1}, {-1,0},{0,-1}};

        while(!que.isEmpty()){

            Pair p = que.poll();

            int row = p.row;
            int col = p.col;
            int step = p.step;

        

            for(int[] a : trav){
                int newRow = row + a[0];
                int newCol = col + a[1];

                if(newRow>=0 && newRow<m && newCol>=0 && newCol<n
                && visited[newRow][newCol]!=2 && grid[newRow][newCol]==1){
                    visited[newRow][newCol]=2;
                    que.offer(new Pair(newRow, newCol, step+1));
                     maxSteps = Math.max(maxSteps, step+1);
                }
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1 && visited[i][j]!=2){
                    return -1;
                }
            }
        }



        return maxSteps;


        
    }
}
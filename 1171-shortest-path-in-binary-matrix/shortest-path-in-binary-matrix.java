class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        if(grid[0][0]==1 || grid[m-1][n-1]==1) return -1;

        int[][] dist = new int[m][n];

        Queue<int[]> que = new LinkedList<>();

        que.offer(new int[]{0,0});
        dist[0][0]=1;

        int[][] trav = {
            {-1,0},{+1,0},{0,-1},{0,+1},
            {+1,+1},{-1,-1},{+1,-1},{-1,+1} };

        while(!que.isEmpty()){

            int[] arr = que.poll();

            int row = arr[0];
            int col = arr[1];

            if(row==m-1 && col==n-1){
                return dist[row][col];
            }

            for(int[] dir : trav){
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if(newRow>=0 && newRow<m && newCol>=0 && newCol<n && grid[newRow][newCol]==0 && dist[newRow][newCol]==0 ){
                    dist[newRow][newCol]=dist[row][col]+1;
                    que.offer(new int[]{newRow, newCol});
                }
            }
        }



        return -1;
    }
}
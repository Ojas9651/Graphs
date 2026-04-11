import java.util.*;
    
class Rotten_Oranges {

        static class Pair{
            int row;
            int col;
            int time;
            Pair(int row, int col, int time){
                this.row = row;
                this.col = col;
                this.time = time;
            }
        }

        public static int orangesRotting(int[][] grid) {
            Queue<Pair> q = new LinkedList<>(); 

            int m = grid.length;
            int n = grid[0].length;

            //vis matrix

            int[][] vis = new int[m][n]; // SC - 0(n*m)

            int countFresh = 0; // to count fresh oranges

            //filling the queue will all the rotten oranges and marking the visted array

            for(int i=0; i<m; i++){ // TC - 0(n*m)
                for(int j=0; j<n; j++){
                    if(grid[i][j] == 2){
                        q.offer(new Pair(i, j, 0));
                        vis[i][j] = 2;
                    }
                    if(grid[i][j] == 1) countFresh++;
                }
            }

            //Neighbours in order -> left, up, right, down

            int[] posRow = {0, -1, 0, 1};
            int[] posCol = {-1, 0, 1, 0};

            int time = 0;
            int count = 0;

            while(!q.isEmpty()){ //O(n*m)
                Pair p = q.poll();
                int r = p.row;
                int c = p.col;  
                int t = p.time;
                time = Math.max(time, t);
                for(int i=0; i<4; i++){
                    int nrow = r+posRow[i];
                    int ncol = c+posCol[i];
                    if(nrow >= 0 && nrow < m && ncol >=0 && ncol < n && grid[nrow][ncol] == 1 && vis[nrow][ncol] != 2){
                        vis[nrow][ncol] = 2;
                        q.offer(new Pair(nrow, ncol, t+1));
                        count++;
                    }
                }
            }
            if(count != countFresh) return -1;
            return time;
        }
 
        public static void main(String[] args) {
            int[][] grid = new int[3][3];
            grid[0][0] = 2;
            grid[0][1] = 1;
            grid[0][2] = 1;
            grid[1][0] = 1;
            grid[1][1] = 1;
            grid[1][2] = 0;
            grid[2][0] = 0;
            grid[2][1] = 1;
            grid[2][2] = 1;
            System.out.println(orangesRotting(grid));
        }
}


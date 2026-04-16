import java.util.LinkedList;
import java.util.Queue;

public class Number_Of_Enclaves {

    public static class Pair{
        int r;
        int c;

        Pair(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    public static int numEnclaves(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        Queue<Pair> q = new LinkedList<>();

        int[][] vis = new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0 || j==0 || i == m-1 || j == n-1){
                    if(grid[i][j] == 1){
                        vis[i][j] = 1;
                        q.offer(new Pair(i, j));
                    }
                }
            }
        }
        int[] deltaRow = {0, -1, 0, 1};
        int[] deltaCol = {-1, 0, 1, 0};
        while(!q.isEmpty()){
            Pair p = q.poll();
            for(int i=0; i<4; i++){
                int nrow = p.r + deltaRow[i];
                int ncol = p.c + deltaCol[i];
                if(nrow >=0 && nrow <m && ncol >=0 && ncol < n && grid[nrow][ncol] == 1 && vis[nrow][ncol] != 1){
                    vis[nrow][ncol] = 1;
                    q.offer(new Pair(nrow, ncol));
                }
            }
        }

        int count = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1 && vis[i][j] == 0) count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] grid = {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
        System.out.println(numEnclaves(grid));
    }
}

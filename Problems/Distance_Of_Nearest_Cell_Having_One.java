//TC - O(m*n)
//SC - O(m*n)

import java.util.LinkedList;
import java.util.Queue;
import java.util.*;

public class Distance_Of_Nearest_Cell_Having_One {

    public static class Pair{
        int row;
        int col;
        int level;

        Pair(int row, int col, int level){
            this.row = row;
            this.col = col;
            this.level = level;
        }
    }

    public static int[][] updateMatrix(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;

        int[][] vis = new int[m][n]; //O(m*n)

        int[][] ans = new int[m][n]; //O(m*n)

        Queue<Pair> q = new LinkedList<>(); //O(m*n)

        for(int i=0; i<m; i++){ //O(m*n)
            for(int j=0; j<n; j++){
                if(mat[i][j] == 0){
                    vis[i][j] = 1;
                    q.offer(new Pair(i, j, 0));
                }
            }
        }

        int[] deltaRow = {0, -1, 0, 1};
        int[] deltaCol = {-1, 0, 1, 0};

        while(!q.isEmpty()){ //O(m*n)
            Pair p = q.poll();
            int row = p.row;
            int col = p.col;
            int level = p.level;
            for(int i=0; i<4; i++){
                int nrow = row + deltaRow[i];
                int ncol = col + deltaCol[i];
                if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && vis[nrow][ncol] != 1){
                    ans[nrow][ncol] = level+1;
                    vis[nrow][ncol] = 1;
                    q.offer(new Pair(nrow, ncol, level+1));
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] mat = {{0,0,0},{0,1,0},{1,1,1}};
        int[][] ans = updateMatrix(mat);
        for(int[] arr : ans){
            for(int i : arr){
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
    

/*
    TC - 2 O(m*n) ~ o(m*n)
    SC - O(m*n)
*/

public class Number_Of_Islands {
    public static void dfs(int i, int j, char[][] grid, int[] deltaRow, int[] deltaCol, int m, int n){
        grid[i][j] = '0';
        for(int k=0; k<4; k++){
            int nrow = i + deltaRow[k];
            int ncol = j + deltaCol[k];
            if(nrow >=0 && nrow < m && ncol >= 0 && ncol < n && grid[nrow][ncol] == '1'){
                dfs(nrow, ncol, grid, deltaRow, deltaCol, m ,n);
            }
        }
    }

    public static int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] deltaRow = {0, -1, 0, 1};
        int[] deltaCol = {-1, 0, 1, 0};

        int islands = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1'){
                    dfs(i, j, grid, deltaRow, deltaCol, m, n);
                    islands++;
                }
            }
        }
        return islands;
    }

    public static void main(String[] args) {
        char[][] grid = {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}};

        System.out.println(numIslands(grid));
    }
}

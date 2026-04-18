/*

    Total TC - O(n*m) + O(n+m) + O(n*m) = O(2(n*m)) + O(n+m) ~ O(n*m) + (n+m)
    Total SC - O(n*m)

    Solution -

    Go to all border elements and if the char is a 'O' do a dfs for it.
    At the end of the loop all the regions that can't be surrounded are maked in the vis matrix
    Now traverse in vis and if vis[i][j] == 0 && board[i][j] == 'O', then mark it 'X'
    The element left after the border tarversal are the surounded regions.
*/

public class Surrounded_Regions {

    //TC - O(n*m)
    //SC - O(m*n)

    public static void dfs(int i, int j, char[][] board, int[][] vis, int[] deltaRow, int[] deltaCol, int m, int n){
        vis[i][j] = 1;
        for(int k=0; k<4; k++){
            int nrow = i + deltaRow[k];
            int ncol = j + deltaCol[k];
            if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && board[nrow][ncol] == 'O' && vis[nrow][ncol] != 1){
                dfs(nrow, ncol, board, vis, deltaRow, deltaCol, m ,n);
            }
        }
    }

    public static void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        int[][] vis = new int[m][n]; //SC - O(m*n)

        int[] deltaRow = {0, -1, 0, 1};
        int[] deltaCol = {-1, 0, 1, 0};

        /*
            TC for below loop -
            2 rows -> 2 * n columns -> O(2n)
            2 op. for all remaining rows -> 2 * (m-2) -> O(2m) 
            Total - O(n + m)
        */

        for(int i=0; i<m; i++){
            if(i == 0 || i == m-1){
                for(int j=0; j<n; j++){
                    if(board[i][j] == 'O') dfs(i, j, board, vis, deltaRow, deltaCol, m, n);
                }
            }else{
                if(board[i][0] == 'O') dfs(i, 0, board, vis, deltaRow, deltaCol, m, n);
                if(board[i][n-1] == 'O') dfs(i, n-1, board, vis, deltaRow, deltaCol, m, n);
            }
        }

        for(int i=0; i<m; i++){ //O(n*m)
            for(int j=0; j<n; j++){
                if(vis[i][j] == 0 && board[i][j] == 'O') board[i][j] = 'X';
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        solve(board);
        for(char[] arr : board){
            for(char i : arr){
                System.out.print(i);
            }
            System.out.println();
        }
    }
}

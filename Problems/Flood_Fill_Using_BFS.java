import java.util.LinkedList;
import java.util.Queue;

public class Flood_Fill_Using_BFS {

    static class Pair{
        int row;
        int col;
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {

        if(image[sr][sc] == color) return image;

        int m = image.length;
        int n = image[0].length;

        int startColor = image[sr][sc];
        image[sr][sc] = color;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(sr, sc));

        int[] nRowEl = {0, -1, 0, 1};
        int[] nColEl = {-1, 0, 1, 0};

        while(!q.isEmpty()){
            Pair p = q.poll();
            int row = p.row;
            int col = p.col;
            for(int i=0; i<4; i++){
                int nrow = row + nRowEl[i];
                int ncol = col + nColEl[i];
                if(nrow >=0 && nrow < m && ncol >=0 && ncol < n && image[nrow][ncol] == startColor){
                    image[nrow][ncol] = color;
                    q.offer(new Pair(nrow, ncol));
                }
            }
        }
        return image;
    }

    public static void main(String[] args) {
        int[][] image = new int[3][3];
        image[0][0] = 2;
        image[0][1] = 1;
        image[0][2] = 1;
        image[1][0] = 1;
        image[1][1] = 1;
        image[1][2] = 0;
        image[2][0] = 0;
        image[2][1] = 1;
        image[2][2] = 1;

        floodFill(image, 1, 1, 2);

        for(int i=0; i<image.length; i++){
            for(int j=0; j<image[0].length; j++){
                System.out.print(image[i][j]);
            }
            System.out.println();
        }
    }
} 

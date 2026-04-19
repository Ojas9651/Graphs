/*
    We have to mark all the nodes with 0/1 colors
    Any two adjacent nodes can't have the similar color
    
    Solution -

    vis arr marked with -1;

    If there is a odd cycle in graph then the graph is not Bipartite and true otherwise;

    TC - O(V + E)
    SC - O(V)
        
*/

import java.util.Arrays;

public class Bipartite {


    public static void dfs(int node, int color, int[][] graph, int[] vis, int[] flag){
        vis[node] = color;
        for(int i=0; i<graph[node].length; i++){
            int next = graph[node][i];
            if(vis[next] != -1){
                if(vis[next] == color){
                    flag[0] = 0;
                    return;
                }
            }
            else{
                dfs(next, 1-color, graph, vis, flag);
            }
        }
    }

    public static boolean isBipartite(int[][] graph) {
        int m = graph.length;

        int[] vis = new int[m]; 
        Arrays.fill(vis, -1);

        int[] flag = {1};

        for(int i=0; i<m; i++){ 
            if(vis[i] == -1){
                dfs(i, 0, graph, vis, flag);
            }
        }

        if(flag[0] == 0) return false;

        return true;
    }

    public static void main(String[] args) {
        int[][] graph = {{1,2,3},{0,2},{0,1,3},{0,2}};
        System.out.println(isBipartite(graph));
    }
}

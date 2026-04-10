import java.util.*;

public class DFS {

    public static void utilDFS(int node, int[] vis, List<List<Integer>> adj, List<Integer> dfs){
        vis[node] = 1;
        dfs.add(node);
        for(int i : adj.get(node)){
            if(vis[i] == 0){
                utilDFS(i, vis, adj, dfs);
            }
        }
    }

    public static void main(String[] args) {
        int n = 9;
        int m = 9;
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0; i<n+1; i++){
            adj.add(new ArrayList<Integer>());
        }

        //Creating Adj list
        adj.get(1).add(2);
        adj.get(1).add(6);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(2).add(4);
        adj.get(3).add(2);
        adj.get(4).add(2);
        adj.get(4).add(5);
        adj.get(5).add(4);
        adj.get(5).add(8);
        adj.get(6).add(1);
        adj.get(6).add(7);
        adj.get(6).add(9);
        adj.get(7).add(6);
        adj.get(7).add(8);
        adj.get(8).add(7);
        adj.get(8).add(5);
        adj.get(9).add(6);

        int[] vis = new int[n+1];

        List<Integer> dfs = new ArrayList<>();

        utilDFS(1, vis, adj, dfs);

        for(int i : dfs){
            System.out.print(i + " ");
        }
    }
}

import java.util.*;

class BFS{
    public static void main(String[] args) {
        int n = 9;
        int m = 9;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

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

        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        vis[1] = 1;
        List<Integer> bfs = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            bfs.add(node);
            for(int i=0; i<adj.get(node).size(); i++){
                int nbr = adj.get(node).get(i);
                if(vis[nbr] == 0){
                    vis[nbr] = 1;
                    q.offer(nbr);
                }
            }
        }

        for(int i : bfs){
            System.out.print(i);
        }
    }
}

package level3;

import java.util.*;

public class 섬연결하기 {



    private static class Node{
        private int depth = 1;
        private Node parent = null;


        public boolean isConnected(Node node){
            return root() == node.root();
        }


        public void merge(Node node){
            if(isConnected(node)) return;

            Node root1 = root();
            Node root2 = node.root();

            if(root1.depth > root2.depth){
                root2.parent = root1;
            }
            else if(root1.depth < root2.depth){
                root1.parent = root2;
            }
            else{
                root2.parent = root1;
                root1.depth += 1;
            }
        }


        private Node root(){
            if(parent == null) return this;

            return parent.root();
        }

    }

    private static class Edge{
        public final int u;
        public final int v;
        public final int cost;

        private Edge(int u, int v, int cost){
            this.u = u;
            this.v = v;
            this.cost = cost;
        }
    }


    public int solution(int n, int[][] costs) {
        int answer = 0;

        Edge[] edges = Arrays.stream(costs)
                .map(edge -> new Edge(edge[0], edge[1], edge[2])) // u : [0], v : [1], cost : [2]
                .sorted(Comparator.comparingInt(edge -> edge.cost))
                .toArray(Edge[]::new);

        Node[] nodes = new Node[n];
        for(int i = 0; i < n; i++){
            nodes[i] = new Node();
        }

        int totalCost = 0;

        for(Edge edge : edges){
            Node node1 = nodes[edge.u];
            Node node2 = nodes[edge.v];

            if(node1.isConnected(node2)) continue;

            node1.merge(node2);
            totalCost += edge.cost;
        }



        return totalCost;
    }

    //=============

    List<Edge> edgeList = new ArrayList<>();
    int[] parent;
    int sum = 0;

    public int solution22(int n, int[][] costs) {


        parent = new int[n];
        for(int[] cost : costs){
            edgeList.add(new Edge(cost[0], cost[1], cost[2]));
        }

        for(int i = 0; i < n; i++){
            parent[i] = i;
        }

        Collections.sort(edgeList, (o1, o2) -> o1.cost - o2.cost);

        for(int i = 0; i < edgeList.size(); i++){
            Edge edge = edgeList.get(i);

            if(!isSameParent(edge.u, edge.v)){
                sum += edge.cost;
                merge(edge.u, edge.v);
            }
        }


        return sum;
    }


    public boolean isSameParent(int u, int v){
        u = find(u);
        v = find(v);

        if(u == v) return true;

        return false;

    }

    public void merge(int u, int v){
        u = find(u);
        v = find(v);

        if(u != v){
            if(u < v) parent[v] = u;
            else parent[v] = u;
        }
    }

    public int find(int v){
        if(parent[v] == v) return v;

        return parent[v] = find(parent[v]);
    }
}

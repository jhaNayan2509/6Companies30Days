/*RELATED TOPICS: DP,GRAPH,Topo Sort,Shortest Path,Dijkstra Algo */
class Solution {
    public int countPaths(int n, int[][] roads) {
        int mod  = (int)(1e9+7);

        
        List<List<Pair>> adj = new ArrayList<>();
        int m = roads.length;
        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i<m; i++){
            adj.get(roads[i][0]).add(new Pair(roads[i][1], roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0], roads[i][2]));
        }

        
        int [] time = new int[n];
        
        long [] ways = new long[n];
        Arrays.fill(time, (int)1e18);
        
        time[0] = 0;
        ways[0] = 1;

        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.first - y.first);
        pq.add(new Pair(0, 0));

        while(!pq.isEmpty()){
            Pair out = pq.peek();
            int currTime = out.first;
            int node = out.second;
            pq.remove();

            for(Pair val : adj.get(node)){
                int adjNode = val.first;
                int weight = val.second;

                if(weight + currTime < time[adjNode]){
                    time[adjNode] = weight+currTime;
                    pq.add(new Pair(time[adjNode], adjNode));
                    ways[adjNode] = ways[node];
                }else if(weight + currTime == time[adjNode]){
                    ways[adjNode] = (ways[adjNode]+ways[node])%mod;
                }
            }
        }
        return (int)ways[n-1];
    }
}
class Pair{
    int first, second;
    public Pair(int _first, int _second){
        this.first = _first;
        this.second = _second;
    }
}
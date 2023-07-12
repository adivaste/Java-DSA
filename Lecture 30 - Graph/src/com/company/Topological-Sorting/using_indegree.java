import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution
{
    //Function to return list containing vertices in Topological order. 
    
    public static List<Integer> topoSort(int V, ArrayList<ArrayList<Integer>> adj) {

        // Convert arraylist to hashmap
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();
        
        for(int i=0; i<V; i++){
            graph.put(i, adj.get(i));
        }
        
        
        // Store answer in list
        List<Integer> answer = new ArrayList<>();

        while (!graph.isEmpty()) {
            HashMap<Integer, Integer> indegree = new HashMap<>();

            // Calculate indegree of each vertex
            for (ArrayList<Integer> vertexList : graph.values()) {
                for (int vertex : vertexList) {
                    indegree.put(vertex, indegree.getOrDefault(vertex, 0) + 1);
                }
            }

            // Find all vertices with zero indegree
            for (int vertex : indegree.keySet()) {
                if (indegree.get(vertex) == 0) {
                    answer.add(vertex);
                    graph.remove(vertex);
                    for (ArrayList<Integer> edges : graph.values()) {
                        edges.remove((Integer) vertex);
                    }
                }
            }

        }

      //   int[] ans = new int[answer.size()];
      //   for(int i=0; i<answer.size(); i++){
      //       ans[i] = answer.get(i);
      //   }
        return answer;
    }

    public static void main(String[] args){
      ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        // Add vertices to the graph
        for (int i = 0; i < 6; i++) {
            graph.add(new ArrayList<Integer>());
        }

        // Add edges to the graph
        graph.get(0).add(1);
        graph.get(0).add(2);
        graph.get(1).add(3);
        graph.get(2).add(3);
        graph.get(2).add(4);
        graph.get(3).add(5);
        graph.get(4).add(5);

        System.out.println(topoSort(6, graph));

    }
}

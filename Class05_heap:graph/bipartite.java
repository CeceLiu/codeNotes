/**
 * public class GraphNode {
 *   public int key;
 *   public List<GraphNode> neighbors;
 *   public GraphNode(int key) {
 *     this.key = key;
 *     this.neighbors = new ArrayList<GraphNode>();
 *   }
 * }
 */
public class Solution {
  public boolean isBipartite(List<GraphNode> graph) {
    assert graph != null;
    // use 0 or 1 to denote two differenct groups 
    // the map contains if node visited and which group it belongs to 
    HashMap<GraphNode, Integer> map = new HashMap<GraphNode, Integer>();
    for (GraphNode node: graph){
      if (!BFS(node, map))
        return false;
    }
    return true;
  }
  
  private boolean BFS(GraphNode node, HashMap<GraphNode, Integer> map){
    // if node already traversed no need to BFS
    if (map.containsKey(node)){
      return true;
    }
    Queue<GraphNode> queue = new LinkedList<GraphNode>();
    queue.offer(node);
    map.put(node, 0);
    while(!queue.isEmpty()){
      GraphNode curr = queue.poll();
      int currValue = map.get(curr);
      int neighborValue = currValue==0 ? 1:0;
      for(GraphNode neighbor: curr.neighbors){
        // if the neighbor hasn't been traversed, put in the queue
        // assign to a correct group
        if (!map.containsKey(neighbor)){
            queue.offer(neighbor);
            map.put(neighbor, neighborValue);
        }
        // if the neighbor has been traversed but in a wrong group  
        else if (map.get(neighbor) != neighborValue)
            return false;
      }
    }
    return true;
  }
}

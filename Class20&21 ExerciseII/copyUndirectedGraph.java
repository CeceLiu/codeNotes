/*
* class GraphNode {
*   public int key;
*   public List<GraphNode> neighbors;
*   public GraphNode(int key) {
*     this.key = key;
*     this.neighbors = new ArrayList<GraphNode>();
*   }
* }
*/
public class Solution {
  public List<GraphNode> copy(List<GraphNode> graph) {
    // Write your solution here.
    if(graph==null)
      return null;
    // key:original node value: new node
    HashMap<GraphNode, GraphNode> map = new HashMap<GraphNode, GraphNode>();
    for(GraphNode node: graph){
      // if(!map.containsKey(node)){
      //   map.put(node, new GraphNode(node.key));
      //   DFS(node, map);
      // }
      GraphNode value = map.get(node);
      if(value==null){
        map.put(node, new GraphNode(node.key));
        DFS(node, map);
      }
    }
    return new ArrayList<GraphNode>(map.values());
  }
  
  public void DFS(GraphNode node, HashMap<GraphNode, GraphNode> map){
    GraphNode copy = map.get(node);
    for(GraphNode neighbor: node.neighbors){
      if(!map.containsKey(neighbor)){
        map.put(neighbor, new GraphNode(neighbor.key));
        DFS(neighbor, map);
      }
      copy.neighbors.add(map.get(neighbor));
      
      // GraphNode next = map.get(neighbor);
      // if(next==null){
      //   map.put(neighbor, new GraphNode(neighbor.key));
      //   DFS(neighbor, map);
      // }
      // ** WRONG: since next was updated as a new GraphNode
      // copy.neighbors.add(next);
    }
  }
}

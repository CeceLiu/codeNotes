/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
 */
public class Solution {
  public List<List<Integer>> layerByLayer(TreeNode root) {
    // Write your solution here.
    List<List<Integer>> ret = new ArrayList<List<Integer>>();
    if (root == null)
      return ret;
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.offer(root);
    
    while(!queue.isEmpty()){
      List<Integer> currLayer = new ArrayList<Integer>();
      int size = queue.size();
      for(int i=0; i<size; i++){
        TreeNode curr = queue.poll();
        currLayer.add(curr.key);
        if (curr.left != null)
          queue.offer(curr.left);
        if (curr.right != null)
          queue.offer(curr.right);
      }
      ret.add(currLayer);
    }
    return ret;
  }
}

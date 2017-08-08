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
  public TreeNode reconstruct(int[] in, int[] level) {
    // HashMap<in[i], i> to find left subtree elements by compare the index 
    // level[0] is root; find root in IN left subarray is left-subtree and right subarray is right-subtree
    // recursion
    HashMap<Integer, Integer> map = new HashMap<>();
    for(int i=0; i<in.length; i++){
      map.put(in[i], i);
    }
    List<Integer> levelList = new LinkedList<>();
    for(int num:level)
      levelList.add(num);
    return reconstruct(levelList, map);
  }
  
  public TreeNode reconstruct(List<Integer> levelList, HashMap<Integer, Integer> map){
    if(levelList.isEmpty())
      return null;
    TreeNode root = new TreeNode(levelList.remove(0));
    List<Integer> left = new LinkedList<>();
    List<Integer> right = new LinkedList<>();
    // ** already remove current node, if no dup index from map can't eaqual to current
    for(Integer num: levelList){
      if(map.get(num) < map.get(root.key))
        left.add(num);
      else
        right.add(num);
    }
    root.left = reconstruct(left, map);
    root.right = reconstruct(right, map);
    return root;
  }
}

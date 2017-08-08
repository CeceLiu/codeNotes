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
  public boolean exist(TreeNode root, int target) {
    // ** similar to LC 112 Root to leaf path equals to target
    if(root==null)
      return false;
    List<TreeNode> list = new LinkedList<>();
    return exist(root, target, list);
  }
  
  public boolean exist(TreeNode root, int target, List<TreeNode> list){
    list.add(root);
    int sum = 0;
    for(int i=list.size()-1; i>=0; i--){
      sum += list.get(i).key;
      if( sum == target){
        list.remove(list.size()-1);
        return true;
      }
    }
    if(root.left != null && exist(root.left, target, list)){
      list.remove(list.size()-1);
      return true;
    }
    if(root.right!=null && exist(root.right, target, list)){
      list.remove(list.size()-1);
      return true;
    }
    list.remove(list.size()-1);
    return false;
  }
}

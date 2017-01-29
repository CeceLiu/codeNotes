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
  public List<Integer> getRange(TreeNode root, int min, int max) {
    // Write your solution here.
    List<Integer> ret = new ArrayList<Integer>();
    search(root, min, max, ret);
    return ret;
  }
  
  public void search(TreeNode root, int min, int max, List<Integer> ret){
    if (root == null){
      return;
    }
    /*
    if (root.key < min){
      search(root.right, min, max, ret);
    }
    if (root.key <= max && root.key >= min){
      // in-order traverse to make sure result in ascending order
      search(root.left, min, max, ret);
      ret.add(root.key);
      search(root.right, min, max, ret);
    }
    if (root.key > max ){
      search(root.left, min, max, ret);
    }
    return;
    */
    if (root.key > min){
      search(root.left, min, max, ret);
    }
    if (root.key <= max && root.key >= min){
      ret.add(root.key);
    }
    if (root.key < max){
      search(root.right, min, max, ret);
    }
  }
}

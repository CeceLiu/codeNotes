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
  public int largestSmaller(TreeNode root, int target) {
    // if curr.key < target: update res if feasible move to right subtree
    // else move to left subtree DO NOT update res
    int res = Integer.MIN_VALUE;
    TreeNode curr = root;
    while(curr != null){
      if(curr.key < target){
        if(Math.abs(curr.key-target) < Math.abs(res-target))
          res = curr.key;
        curr = curr.right;
      }
      else
        curr = curr.left;
    }
    return res;
  }
}

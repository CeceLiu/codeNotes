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
  public int closest(TreeNode root, int target) {
    // if target in BST return node.key
    // if target < root, move to left subtree
    // if target > root, move to right subtree
    int res = Integer.MAX_VALUE;
    TreeNode curr = root;
    while(curr!=null){
      if(curr.key == target)
        return curr.key;
      if(Math.abs(res-target) > Math.abs(curr.key-target))
        res = curr.key;
      if(curr.key < target)
        curr = curr.right;
      else
        curr = curr.left;
    }
    return res;
  }
}

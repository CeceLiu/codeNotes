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
  public TreeNode reverse(TreeNode root) {
    // Write your solution here.
    /*
    // M1 recursion
    if(root==null || root.left==null)
      return root;
    TreeNode parent=root, left=root.left, right=root.right;
    TreeNode res = reverse(left);
    left.left = parent;
    left.right = right;
    root.left = null;
    root.right=null;
    return res;
    */

    // M2 iteration
    TreeNode prev=null, prevRight=null;
    while(root!=null){
      TreeNode next = root.left;
      TreeNode right = root.right;
      root.left = prev;
      root.right = prevRight;
      prevRight = right;
      prev = root;
      root=next;
    }
    return prev; 
  }
}

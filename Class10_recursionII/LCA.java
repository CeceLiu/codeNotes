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
  public TreeNode lowestCommonAncestor(TreeNode root,
      TreeNode one, TreeNode two) {
    // Write your solution here.
    // baseCase
    if (root == null)
      return null;
    // *** object compare instead of value ***
    if (root == one || root == two)
      return root;
    
    // what expect from lChild/rChild, usually it is the return type of the func
    TreeNode leftN = lowestCommonAncestor(root.left, one, two);
    TreeNode rightN = lowestCommonAncestor(root.right, one, two);
    // action on current layer
    if(leftN != null && rightN != null)
      return root;
    else
      return leftN == null ? rightN:leftN;
  }
}

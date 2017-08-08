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
/*
both the starting and ending node of the subpath should be on the same path from root to one of the leaf nodes, 
and the subpath is allowed to contain only one node
*/
public class Solution {
  public int maxPathSum(TreeNode root) {
    // Write your solution here.
    if(root==null)
      return 0;
    int[] res = new int[]{Integer.MIN_VALUE};
    maxPathSum(root, res);
    return res[0];
  }
  
  public int maxPathSum(TreeNode root, int[] res){
    if(root==null)
      return 0;
    int left = maxPathSum(root.left, res);
    int right = maxPathSum(root.right, res);
    int currM = Math.max(root.key+left, root.key+right);
    // ** allowed to contain only one node so have to compare with node itself
    res[0] = Math.max(res[0], root.key);
    res[0] = Math.max(res[0], currM);
    return currM;
  }
}

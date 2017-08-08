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
    // return max(root.key, root.key+left, root.key+right)
    int currM = Math.max(root.key+left, root.key+right);
    currM = Math.max(currM, root.key);
    // update globalMax if max(root.key+left+right, currM) > globalMax
    res[0] = Math.max(root.key+left+right, res[0]);
    res[0] = Math.max(currM, res[0]);
    return currM;
  }
}

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
    // Initialize the return value as MIN
    int[] res = new int[]{Integer.MIN_VALUE};
    maxPathSum(root, res);
    return res[0];
  }
  // A utility function to find the maximum sum between any
  // two leaves.This function calculates two values:
  // 1) Maximum path sum between two leaves which is stored in res[0].
  // 2) The maximum root to leaf path sum which is returned.
  // If one side of root is empty, then it returns INT_MIN
  public int maxPathSum(TreeNode root, int[] res){
    // base case 
    if(root==null)
      return 0;
    if(root.left==null && root.right==null)
      return root.key;
      
    int leftC = maxPathSum(root.left, res);
    int rightC = maxPathSum(root.right, res);
    int currSum = leftC+rightC+root.key;
    if(root.left !=null && root.right!=null){
      res[0] = Math.max(res[0], currSum);
      // ** Return maxium possible value for root being on one side
      return Math.max(rightC, leftC)+root.key;
    }
    // ** return the non-empty child
    return root.left==null ? rightC+root.key : leftC+root.key;
  }
}

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
  public TreeNode reconstruct(int[] in, int[] pre) {
    // the first element in Pre is root
    if(in==null || pre==null)
      return null;
    int[] inIdx = new int[]{0};
    int[] preIdx = new int[]{0};
    return reconstruct(in, pre, inIdx, preIdx, Integer.MAX_VALUE);
  }
  
  public TreeNode reconstruct(int[] in, int[] pre, int[] inIdx, int[] preIdx, int target){
    // left => before go to left preIndex+1 and pass currt root.key
    // right => before go to right inIndex+1 and pass currt root.parent.key (value from previous recursion call)
    // once the value found in IN return null
    if(inIdx[0]>=in.length || in[inIdx[0]] == target )
      return null;
    TreeNode root = new TreeNode(pre[preIdx[0]]);         
    preIdx[0] += 1;
    root.left = reconstruct(in, pre, inIdx, preIdx, root.key);
    inIdx[0] += 1;
    root.right = reconstruct(in, pre, inIdx, preIdx, target);
    return root;
  }
}

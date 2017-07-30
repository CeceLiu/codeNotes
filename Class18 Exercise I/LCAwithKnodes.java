public class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root, List<TreeNode> nodes) {
    // Write your solution here.
    if(root==null)
      return null;
    // ** check if root is any node in the list 
    for(TreeNode node: nodes){
      if(node==root)
        return root;
    }
    TreeNode left = lowestCommonAncestor(root.left, nodes);
    TreeNode right = lowestCommonAncestor(root.right, nodes);
    // ** return non-empty node
    if(left!=null && right!=null)
      return root;
    return left==null ? right:left;
  }
}

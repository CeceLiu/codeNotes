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
  public TreeNode reconstruct(int[] post) {
    // set a range [min..max] for each node for BST
    // left subTree range in [min..root.val]
    // right subTree range in [root.val .. max]
    if(post==null || post.length<1)
      return null;
    int[] index = new int[] {post.length-1};
    // last element in Postoder tranversal is root
    return reconstruct(post, index, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }
  
  public TreeNode reconstruct(int[] post, int[] index, int min, int max){
    if(index[0]<0 || post[index[0]]>max || post[index[0]]<min)
      return null;
    TreeNode root = new TreeNode(post[index[0]]);
    index[0] -= 1;
    root.right = reconstruct(post, index, root.key, max);
    root.left = reconstruct(post, index, min, root.key);
    return root;
  }
}

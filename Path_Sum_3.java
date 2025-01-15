/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int total = 0;
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        helper(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return total;
    }

    void helper(TreeNode root, long sum) {
        if(root == null) return;
        
        
        if(sum== root.val){
            total++; 
        } 

        helper(root.left, sum-root.val);
        helper(root.right, sum-root.val);
    }
}

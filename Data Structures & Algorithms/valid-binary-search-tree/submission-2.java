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
    public boolean isValidBST(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        inorder(root,list);
        int prev=list.get(0);
        for(int i=1;i<list.size();i++){
            if(prev>=list.get(i)){
                return false;
            }
            prev=list.get(i);
        }
        return true;
    }
    private void inorder(TreeNode root, List<Integer> path){
        if(root==null){
            return;
        }
        inorder(root.left, path);
        path.add(root.val);
        inorder(root.right,path);
    }
}

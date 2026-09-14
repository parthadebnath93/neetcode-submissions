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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path1 = new ArrayList<>();
        List<TreeNode> path2 = new ArrayList<>();
        findPath(path1, p, root);
        findPath(path2, q, root);
        return findLCA(path1, path2);
    }
    private TreeNode findLCA(List<TreeNode> path1, List<TreeNode> path2) {
        int index;
        for (index = 0; index < path1.size() && index < path2.size(); index++) {
            if (path1.get(index).val != path2.get(index).val) {
                break;
            }
        }
        return path1.get(index-1);
    }

    private boolean findPath(List<TreeNode> path, TreeNode node, TreeNode root) {
        if (root == null) {
            return false;
        }
        path.add(root);
        if (node.val == root.val) {
            return true;
        }
        if (root.left != null && findPath(path, node, root.left)) {
            return true;
        } else if (root.right != null && findPath(path, node, root.right)) {
            return true;
        } else {
            path.remove(path.size() - 1);
            return false;
        }
    }
}

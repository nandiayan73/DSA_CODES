package CODES;
class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null) return true;  // If the list is empty, it's always a subpath.
        if (root == null) return false; // If the tree is empty and list is not, return false.
        
        // Check if there's a path from the current node or any of its children.
        return dfs(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean dfs(ListNode head, TreeNode root) {
        if (head == null) return true;  // Reached end of list, path found.
        if (root == null) return false; // Reached end of tree path, but list still remains.
        
        if (root.val != head.val) return false; // Values don't match, this path is invalid.

        // Continue searching for the next node in the list along both children of the current tree node.
        return dfs(head.next, root.left) || dfs(head.next, root.right);
    }
}

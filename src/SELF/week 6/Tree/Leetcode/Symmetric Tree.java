# [101\. Symmetric Tree](https://leetcode.com/problems/symmetric-tree/)

## Description

Difficulty: **Easy**  

Related Topics: [Tree](https://leetcode.com/tag/tree/), [Depth-First Search](https://leetcode.com/tag/depth-first-search/), [Breadth-First Search](https://leetcode.com/tag/breadth-first-search/), [Binary Tree](https://leetcode.com/tag/binary-tree/)


Given the `root` of a binary tree, _check whether it is a mirror of itself_ (i.e., symmetric around its center).

**Example 1:**

![](https://assets.leetcode.com/uploads/2021/02/19/symtree1.jpg)

```
Input: root = [1,2,2,3,4,4,3]
Output: true
```

**Example 2:**

![](https://assets.leetcode.com/uploads/2021/02/19/symtree2.jpg)

```
Input: root = [1,2,2,null,3,null,3]
Output: false
```

**Constraints:**

*   The number of nodes in the tree is in the range `[1, 1000]`.
*   `-100 <= Node.val <= 100`

**Follow up:** Could you solve it both recursively and iteratively?

## Solution

Language: **Java** 

```java DFS
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return mirror(root,root); 
    }
    public boolean mirror(TreeNode A , TreeNode B){
        if(A==null && B==null) return true;
        if(A==null || B==null) return false; 
        if(A.val!=B.val) return false;
        return mirror(A.left, B.right) && mirror(A.right,B.left);
    }
}
```
BFS

 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        TreeNode A = root.left ;
        TreeNode B = root.right;
        Stack<TreeNode> st = new Stack<>();
        while(!st.isEmpty() || A!=null || B!=null){
            while(A!=null && B!=null){
                if(A.val!=B.val) return false;
                st.push(A);
                st.push(B);
                A = A.left;
                B= B.right;
            }
            if(A!=null || B!=null) return false;
            B = st.pop().left;
            A = st.pop().right;
        }
        return true;
    }
}


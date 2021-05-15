/**
 * https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/


Note
preorder: head->left->right
    [8,5,1,7,10,12]

observation: 
    ith element head node;
    next greater of ith is right sub-tree(suppose next greater: mx_ind)
    left sub-tree is from ith+1 to mx_ind

    IMP: this observation is applicable on BST only




imp when ith==mx_ind
    right subtree is null 
    left sub-tree from ith+1 to end


 */
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        return bst(preorder, 0, preorder.length-1);
    }
    
    
    public TreeNode bst(int ar[], int start, int end){

        if(start>end) return null;

        //leaf node
        if(start==end) return new TreeNode(ar[start]);
        

        //finding next greater
        int mx_index = start;
        for(int i=start+1; i<=end; i++){
            if(ar[i]>ar[mx_index]){
                mx_index=i;
                break;
            }
        }
        
        //create node
        TreeNode head = new TreeNode(ar[start]);
        
        //when next greater is not exist
        if(start==mx_index){
            head.left = bst(ar, start+1, end);
            head.right = null;
        }
        else{
            // mx_index: right tree
            // start+1: left tree
            head.left = bst(ar, start+1, mx_index-1);
            head.right = bst(ar, mx_index, end);
        }    
        return head;
    }
}
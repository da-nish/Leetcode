/**
 * https://leetcode.com/problems/deepest-leaves-sum/

create queue and put root and null;
null represents end of level

calculate the sum when curr.left curr.right !=null 
reset sum and add null(at the end) to know next level


//recursive 
https://leetcode.com/problems/deepest-leaves-sum/discuss/464774/Java-1ms-DFS-single-traversal-O(N)

 */


class Solution {
    public int deepestLeavesSum(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        qu.add(null);
        int sum=0;
        while(qu.size()>0){

            TreeNode temp = qu.remove();
            
            //when last node
            if(temp==null && qu.isEmpty()) break;

            //level end
            if(temp==null){ 
                qu.add(null);
                sum=0;
            }

            else{
                sum+=temp.val;//calculate sum
                if(temp.left!=null) qu.add(temp.left); 
                if(temp.right!=null) qu.add(temp.right);
            }
        }
        return sum;
        
    }
}
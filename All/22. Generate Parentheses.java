/*
https://leetcode.com/problems/generate-parentheses/

this question can be done using catalan


See Catalan folder
*/

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        doo(list, "", n, n);
        return list;
    }
    
    public static void doo(List<String> list, String re,int left, int right){
        if(left==0 && right==0) {
            list.add(re);
            return;
        }
        if(left>right) return;
        
        if(left>0) doo(list, re+'(', left-1,  right);
        if(right>0) doo(list, re+')', left,  right-1);
        
    }
}
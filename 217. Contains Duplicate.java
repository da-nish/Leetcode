/*
https://leetcode.com/problems/contains-duplicate/
*/

class Solution {
    public boolean containsDuplicate(int[] ar) {
        
        
        int n=ar.length;
        
        Set<Integer> set = new HashSet<>();
        
        for(int i:ar){
            if(set.contains(i)) return true;
            else set.add(i);
        }
        return false;
        
    }
}
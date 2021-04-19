/*
https://leetcode.com/problems/subsets/

Approach - Backtracking Element-respect
*/

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> main  = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        
        doo(main, temp, nums,0);
        return main;
        
    }
    
    public static void doo(List<List<Integer>> main, List<Integer> temp, int ar[], int i){
        if(i==ar.length){
            main.add(new ArrayList<>(temp));
            return;
        }
        
        temp.add(ar[i]);
        doo(main, temp, ar, i+1);
        temp.remove(temp.size()-1);
        
        doo(main, temp, ar, i+1);
        
    }
}
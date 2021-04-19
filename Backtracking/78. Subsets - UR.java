/*
https://leetcode.com/problems/subsets/

Approach - Backtracking User-respect
*/

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> main  = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        
        doo(main, temp, nums,0);
        return main;
        
    }
    
    public static void doo(List<List<Integer>> main, List<Integer> temp, int ar[], int strt){
        if(strt>ar.length) return;

        //IMP, in user-respect, we will get subset on each call
        if(strt<=ar.length){
            main.add(new ArrayList<>(temp));
        }
        for(int i=strt; i<ar.length; i++){
            temp.add(ar[i]);
            doo(main, temp, ar, i+1);
            temp.remove(temp.size()-1);
        }
        
    }
}
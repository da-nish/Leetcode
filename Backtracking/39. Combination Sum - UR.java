/*
https://leetcode.com/problems/combination-sum/

Approach - Backtracking User-Respect looping

*/

class Solution {
    public List<List<Integer>> combinationSum(int[] ar, int t) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        
        doo(list, temp, ar, t, 0);
        
        return list;
        
    }
    
    public static void doo(List<List<Integer>> main, List<Integer> temp, int ar[], int t, int strt){
        if(t==0){
            main.add(new ArrayList<>(temp));
            return;
        }
        
        
        for(int i=strt; i<ar.length; i++){
            
            if(t>=ar[i]){
                temp.add(ar[i]);
                doo(main, temp, ar, t-ar[i], i);
                temp.remove(temp.size()-1);
            }
            
        }
        
    }
}
/*
https://leetcode.com/problems/combination-sum/

Approach - Backtracking Element-Respect

*/

class Solution {
    public List<List<Integer>> combinationSum(int[] ar, int t) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        
        doo(list, temp, ar, t, 0);
        
        return list;
        
    }
    
    public static void doo(List<List<Integer>> main, List<Integer> temp, int ar[], int t, int i){
        if(t==0){
            main.add(new ArrayList<>(temp));
            return;
        }
        
        if(i==ar.length) return;
        
            
        if(t>=ar[i]){
            temp.add(ar[i]);
            doo(main, temp, ar, t-ar[i], i);
            temp.remove(temp.size()-1);
        }
            
        doo(main, temp, ar, t, i+1);
          
    }
}
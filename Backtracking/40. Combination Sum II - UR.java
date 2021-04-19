/*
https://leetcode.com/problems/combination-sum-ii/

Approach - Backtracking User-Respect looping

make two changes in problem number 39
1. sort the array
2. check last element

*/

class Solution {
    public List<List<Integer>> combinationSum2(int[] ar, int t) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(ar);
        
        doo(list, temp, ar, t, 0);
        
        return list;
    }
    
    public static void doo(List<List<Integer>> main, List<Integer> temp, int ar[], int t, int strt){
        if(t==0){
            main.add(new ArrayList<>(temp));
            return;
        }
        
        if(strt==ar.length) return;
        
        for(int i=strt; i<ar.length; i++){

            //required condition for non-duplicate
            if(i>strt && ar[i]==ar[i-1])
                continue;
                
            if(t>=ar[i]){
                temp.add(ar[i]);
                doo(main, temp, ar, t-ar[i], i+1);
                temp.remove(temp.size()-1);
            
            }
        }
            
          
    }
}
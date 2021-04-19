/*

https://leetcode.com/problems/combination-sum-iii/

Approach - Backtracking - User-Respect looping

*/


class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> main = new ArrayList<>();
        List<Integer> temp  = new ArrayList<>();
        int ar[] = {1,2,3,4,5,6,7,8,9};//
        
        doo(main, temp, ar, n, k, 0);
        return main;
    }
    
    public static void doo(List<List<Integer>> main, List<Integer> temp, int ar[], int t, int k, int strt){
        
        if(t==0){
            if(k==0){
                main.add(new ArrayList<>(temp));
            }
            return;
        }
        
        if(t<0 || k<0) return;
        
        for(int i=strt; i<ar.length; i++){
            temp.add(ar[i]);
            doo(main, temp, ar, t-ar[i], k-1, i+1);
            temp.remove(temp.size()-1);
        }
        
        
    }
}
/*

https://leetcode.com/problems/combination-sum-iii/

Approach - Backtracking - Element-Respect

*/


class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> main = new ArrayList<>();
        List<Integer> temp  = new ArrayList<>();
        int ar[] = {1,2,3,4,5,6,7,8,9};//
        
        doo(main, temp, ar, n, k, 0);
        return main;
    }
    
    public static void doo(List<List<Integer>> main, List<Integer> temp, int ar[], int t, int k, int i){
        
        if(t==0){
            if(k==0){
                main.add(new ArrayList<>(temp));
            }
            return;
        }
        if(i==ar.length || t<0 || k<0) return;

        temp.add(ar[i]);
        doo(main, temp, ar, t-ar[i], k-1, i+1);
        temp.remove(temp.size()-1);
        doo(main, temp, ar, t, k, i+1);
        
    }
}
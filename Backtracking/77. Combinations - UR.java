/*
https://leetcode.com/problems/combinations/


Approach - Backtracking User-Respect looping

*/
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> main = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int ar[] = new int[n];
        for(int i=1;i<=n; i++) ar[i-1]=i;
        doo(main, temp, n, 1, k);
        
        return main;
        
    }
    public static void doo(List<List<Integer>> main, List<Integer> temp, int n, int strt, int k){
        
        if(k==0){
            main.add(new ArrayList<>(temp));
            return;
        }
        if(k<0) return;
        
        for(int i=strt; i<=n; i++){
            temp.add(i);
            doo(main, temp, n, i+1, k-1);
            temp.remove(temp.size()-1);
        }
        
        
    }
}
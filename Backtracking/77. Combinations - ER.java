/*
https://leetcode.com/problems/combinations/


Approach - Backtracking Element-Respect

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
    public static void doo(List<List<Integer>> main, List<Integer> temp, int n, int i, int k){
        
        if(k==0){
            main.add(new ArrayList<>(temp));
            return;
        }
        if(i>n || k<0) return;
        
        
        temp.add(i);
        doo(main, temp, n, i+1, k-1);
        temp.remove(temp.size()-1);
        
        doo(main, temp, n, i+1, k);
        
        
    }
}
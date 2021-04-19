/*
https://leetcode.com/problems/subsets-ii/

Approach - Backtracking User-respect looping

*/
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
            List<List<Integer>> main  = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        
        doo(main, temp, nums,0);
        return main;
        
    }
    
    public static void doo(List<List<Integer>> main, List<Integer> temp, int ar[], int strt){
        
        if(strt<=ar.length){
            main.add(new ArrayList<>(temp));
        }

        for(int i=strt; i<ar.length; i++){
            
            if(i>strt && ar[i]==ar[i-1]) continue;

            temp.add(ar[i]);
            doo(main, temp, ar, i+1);
            temp.remove(temp.size()-1);
            // doo(main, temp, ar, i+1,false);
        }
    }
}
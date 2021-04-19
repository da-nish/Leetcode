/*
https://leetcode.com/problems/subsets-ii/

Approach - Backtracking Element-respect
*/

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        List<List<Integer>> main  = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        
        doo(main, temp, nums,0, true);
        return main;
        
    }
    
    public static void doo(List<List<Integer>> main, List<Integer> temp, int ar[], int i, boolean flag){
        if(i==ar.length){
            main.add(new ArrayList<>(temp));
            return;
        }
        
        if(flag==false && ar[i]==ar[i-1]){
            doo(main, temp, ar, i+1,false);
        }
        else{
            temp.add(ar[i]);
            doo(main, temp, ar, i+1,true);
            temp.remove(temp.size()-1);
            doo(main, temp, ar, i+1,false);
        }
    }
}
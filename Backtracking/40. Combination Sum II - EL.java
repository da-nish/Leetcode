/*
https://leetcode.com/problems/combination-sum-ii/

Approach - Backtracking Element-Respect

make two changes in problem number 39
1. sort the array
2. check last element

*/

class Solution {
    public List<List<Integer>> combinationSum2(int[] ar, int t) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(ar);
        
        doo(list, temp, ar, t, 0, true);
        
        return list;
    }
    
    public static void doo(List<List<Integer>> main, List<Integer> temp, int ar[], int t, int i, boolean flag){
        if(t==0){
            main.add(new ArrayList<>(temp));
            return;
        }
        
        if(i==ar.length || t<0) return;
        
        if(flag==false && ar[i]==ar[i-1]){
            // if current==previous and previous element was excluded then exclude this element.
            // form the recursion tree to better understand
            doo(main, temp, ar, t, i+1, false);
        }
        else{
            temp.add(ar[i]);
            doo(main, temp, ar, t-ar[i], i+1, true);
            temp.remove(temp.size()-1);

            doo(main, temp, ar, t, i+1, false);
        }
            
          
    }
}
/*
https://leetcode.com/problems/permutations/

approach - backtracking User-respect
*/

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean visit[] = new boolean[nums.length];
    
        doo(list, temp, nums, 0, visit);
        
        return list;
    }
    
    public static void doo(List<List<Integer>> list, List<Integer> temp, int ar[], int strt, boolean visit[]){
        if(strt>=ar.length){
            list.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i=0; i<ar.length; i++){
            if(visit[i]==false){
                visit[i]=true;
                temp.add(ar[i]);
                doo(list, temp, ar, strt+1, visit);
                temp.remove(temp.size()-1);
                visit[i]=false;
            }
        }
        
    }
}
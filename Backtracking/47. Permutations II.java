/*
https://leetcode.com/problems/permutations-ii/

approach - backtracking User-respect
*/
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        
        doo(list, temp, nums, new boolean[nums.length], 0);
        
        return list;
    }
    public static void doo(List<List<Integer>> list, List<Integer> temp, int ar[], boolean visit[], int k){
        
        if(k==ar.length){
            list.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i=0; i<ar.length; i++){

            // subtree(0f 112) in middle one will not process 2,
            // because in subtree parent element should not consider
            // visit[i-1]==false used on top level call
            if(i > 0 && ar[i]==ar[i-1] && visit[i-1]==true) continue;
            if(visit[i]==false){
                visit[i]=true;
                temp.add(ar[i]);
                doo(list, temp, ar, visit, k+1);
                temp.remove(temp.size()-1);
                visit[i]=false;
            }
        }
    }
}
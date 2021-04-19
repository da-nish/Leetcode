
/*
https://leetcode.com/problems/degree-of-an-array/

*/

class Solution {
    public int findShortestSubArray(int[] ar) {
        
        int n = ar.length;
        int re = Integer.MAX_VALUE;
        
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();
        Map<Integer, Integer> count = new HashMap<>();
        
        for(int i=0; i<n; i++){
            if(left.get(ar[i])==null) left.put(ar[i],i);
            right.put(ar[i], i);
            count.put(ar[i], count.getOrDefault(ar[i],0)+1);
        }
        
        int max_degree = 0;
        for(int i: count.keySet()){
            max_degree = Math.max(max_degree, count.get(i));
        }
        
        for(int i: count.keySet()){
            if(max_degree==count.get(i)){
                re = Math.min(re, right.get(i)-left.get(i)+1);
            }
        }
        
        return re;
        
    }
}
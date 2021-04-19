/*
https://leetcode.com/problems/contains-duplicate-ii/
*/

class Solution {
    public boolean containsNearbyDuplicate(int[] ar, int k) {
        
        int n=ar.length;
/*
		NOT WORKING 
        if(n==1) return false;
        
        for(int i=0; i<n; i++){
            if(ar[i] == ar[(i+k)%n]) return true;
        }
        return false;
        
*/      
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<n; i++){
            
            if(map.containsKey(ar[i])){
                if(i-map.get(ar[i]) <= k){
                    return true;
                }
            }
            
            map.put(ar[i], i);
        }
        return false;
    }
}
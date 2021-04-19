
/*
https://leetcode.com/problems/majority-element/

//constraint majority element appears more than n/2 times

other solution:

	Arrays.sort(ar);
	return ar[n/2];

*/


class Solution {
    public int majorityElement(int[] ar) {
        
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i:ar){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        
        int re = 0;
        int m = 0;
        for(int i:ar){
            if(m<map.get(i)) {
                re = i;
                m=map.get(i);
            }
        }
        return re;
        
        
    }
}
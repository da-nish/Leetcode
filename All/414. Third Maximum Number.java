/*

https://leetcode.com/problems/third-maximum-number/

*/

class Solution {
    public int thirdMax(int[] ar) {
        int n=ar.length;
        
        Integer max = null;
        Integer sec = null;
        Integer thr = null;
        
        
        for(Integer i: ar){
            if(i.equals(max) || i.equals(sec) || i.equals(thr)) continue;
            
            if(max==null || max<i){
                thr = sec;
                sec = max;
                max = i;
            }
            else if(sec==null || sec<i){
                thr = sec;
                sec = i;
            }else if(thr==null || thr<i){
                thr = i;
            }
            
        }
        
        if(thr==null) return max;
        
        return thr;
       
    }
}

/*

https://leetcode.com/problems/summary-ranges/

*/
class Solution {
    public List<String> summaryRanges(int[] ar) {
        
        int n=ar.length;
        List<String> list = new ArrayList<>();
        int left = 0;
        for(int i=0; i<n; i++){
            left = i;
            while(i<n-1 && ar[i]+1 == ar[i+1]) i++;
            
            if(left==i) list.add(""+ar[i]);
            else list.add(""+ar[left]+"->"+ar[i]);
        
        }
        return list;
        
    }
}

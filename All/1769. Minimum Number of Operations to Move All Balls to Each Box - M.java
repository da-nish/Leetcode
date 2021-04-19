/*
https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/
MEDIUM
*/

class Solution {
    public int[] minOperations(String box) {
        
        int n = box.length();
        int ar[] = new int[n];
        
        int last = 0;
        int c = 0;
        for(int i=0; i<n; i++){
            ar[i] = last+c;
            last = ar[i];
            
            if(box.charAt(i)=='1') c++;
        }
        
        last = 0;
        c = 0;
        for(int i=n-1; i>=0; i--){
            ar[i] += last+c;
            last = last+c;
            
            if(box.charAt(i)=='1') c++;
        }
        
        
        return ar;
    }
}
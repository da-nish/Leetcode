import java.util.*;
/*
https://leetcode.com/problems/queries-on-a-permutation-with-key/
*/


class Solution {
    public int[] processQueries(int[] q, int m) {
        
        List<Integer> list = new ArrayList<>();
        int re[] = new int[q.length];
        int it = 0;
        
        for(int i=0; i<m; i++){
            list.add(i+1);
        }
        
        int n=q.length;
        for(int i=0; i<n; i++){

            int val = q[i];
            re[it++] = list.indexOf(val);
            list.remove(list.indexOf(val));
            list.add(0,val);
            
        }
        return re;
        
    }
}
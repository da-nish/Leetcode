/*
https://leetcode.com/problems/counting-bits/


*/
class Solution {
    public int[] countBits(int n) {
        
        int c=0;
        int ar[] = new int[n+1];
        for(int i=1; i<=n; i++)
            ar[i]=getbit(i);
        
        return ar;
    }
    
    //approach 1 - using inbuilt function
    public int getbit(int n){
        String s = Integer.toBinaryString(n);
        int c=0;
        for(int i=0; i<s.length(); i++)
            if(s.charAt(i)=='1') c++;
        
        return c;
    }

    //approach 2 - self define function 
    //time logn 
    public int getbit(int n){
        if(n==0 || n==1) return n;
        
        int c=0;
        while(n!=0){
            if(n%2!=0) c++;
            n=n/2;
        }
        return c;
    }
}
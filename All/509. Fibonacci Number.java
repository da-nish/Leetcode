/*
https://leetcode.com/problems/fibonacci-number/
*/

class Solution {
    public int fib(int n) {
        int a=0;
        int b=1;
        int sum =0;
        
        if(n==1) return 1;
        
        int re=0;
        
        while(n--!=0){
            re = sum;
            sum=a+b;
            a=b;
            b=sum;
        }
        return re;
    }
}
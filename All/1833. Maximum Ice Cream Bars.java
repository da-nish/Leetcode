/*
https://leetcode.com/problems/maximum-ice-cream-bars/
*/
class Solution {
    public int maxIceCream(int[] ar, int t) {
        Arrays.sort(ar);
        int re=0;
        int sum=0;
        for(int i=0; i<ar.length; i++){
            sum+=ar[i];
            if(t>=sum) re++;
            else{break;}
        }
        return re;
    }
}
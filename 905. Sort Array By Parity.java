/*
https://leetcode.com/problems/sort-array-by-parity/
*/


class Solution {
    public int[] sortArrayByParity(int[] A) {
        int n = A.length;

        int odd = -1;
        int even = -1;
        for(int i=0; i<n; i++){
            if(A[i]%2!=0) {
                odd = i;
                break;
            }
        }
        if(odd==-1) return A;
        //if all even elements 

        for(int i=odd; i<n; i++){
            if(A[i]%2==0){
                even = i;
                break;
            }
        }
        if(even==-1) return A;
        //if all odd elements 



        even = n-1;
        while(odd<n && even<n && even != odd){
            if(A[odd]%2==0) odd++;
            else if(A[even]%2!=0) even--;
            else{
                int t = A[odd];
                A[odd] = A[even];
                A[even] = t;
            }

        }
        return A;
    }
}
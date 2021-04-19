/*
https://leetcode.com/problems/fair-candy-swap/
*/

class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        
        int n=A.length;
        int m=B.length;
        
        int sumA = 0;
        int sumB = 0;
        
        for(int i: A) sumA+=i;
        for(int i: B) sumB+=i;
        
        for(int i=0; i<n; i++){
            
            for(int j=0; j<m; j++){
                if(sumA-A[i]+B[j] == sumB-B[j]+A[i]){
                    int ar[] = {A[i], B[j]};
                    return ar;
                }    
            }
            
        }
        
        int ar[] = {A[0], B[0]};
        return ar;
        
    }
}


//efficient

class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        
        int n=A.length;
        int m=B.length;
        
        int sumA = 0;
        int sumB = 0;
        
        for(int i: A) sumA+=i;
        for(int i: B) sumB+=i;
        
        int ex = (sumB-sumA)/2 ;
        
        Set<Integer> set = new HashSet<>();
        for(int i: B)  set.add(i);
        
        
        for(int i:A){
            if(set.contains(i+ex)){
                int ar[] = {i, i+ex};
                return ar;
            }
        }
        
        int ar[] = {A[0], B[0]};
        return ar;
        
    }
}
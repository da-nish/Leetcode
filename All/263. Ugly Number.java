// https://leetcode.com/problems/ugly-number/

class Solution {

    public boolean isUgly(int n) {
        if(n==0) return false;
        int ar[] = {2,3,5};
        
        for(int i=0; i<ar.length; i++){

            //check with all the integer
            while(n%ar[i]==0){
                n=n/ar[i];
            }
        }
        return n==1?true:false;
    }


    //using recursion
    public boolean isUgly(int num) {
        if (num <= 0) {return false;}
        if (num == 1) {return true;}
        
        if (num % 2 == 0) {
            return isUgly(num/2);
        }

        if (num % 3 == 0) {
            return isUgly(num/3);
        }

        if (num % 5 == 0) {
            return isUgly(num/5);
        }
        return false;
}

}



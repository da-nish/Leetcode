import java.util.*;
/*
https://leetcode.com/problems/valid-mountain-array/
*/
class file{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);

        int ar[] = {0,3,2,1};
        System.out.println("result: "+ validMountainArray(ar));
    }




    public static boolean validMountainArray(int[] ar) {
        int n=ar.length;
        
        int i=1;        
        while(i<n){
            if(ar[i]>ar[i-1]){
                
            }else{
                break;
            }
            i++;
        }
        
        if(i==n || i==1) return false;
        
        while(i<n){
            if(ar[i]<ar[i-1]){
                
            }else{
                return false;
            }
            i++;
        }
            
        return true;
        
    }
}
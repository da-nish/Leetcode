/*
https://leetcode.com/problems/restore-ip-addresses/
*/

class Solution {
   public static List<String> restoreIpAddresses(String s) {
        List<List<String>> list = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        int k=4;
        doo(s, 0, 0, "", temp);    

        
        return temp;
    }
    
    
    public static void doo(String s, int ind, int k, String re, List<String> list){
        
        
        if(k==4){
            if(s.length()==ind){
                list.add(re.substring(0,re.length()-1));
            }
            return ;
        }
        
        for(int i=ind+1; i<=s.length(); i++){
            if(valid(s.substring(ind,i))){
                doo(s, i, k+1, re+s.substring(ind,i)+".", list);
            }
        }

    }
    
    public static boolean valid(String s){
        if(s.charAt(0)=='0' && s.equals("0")==false)
            return false;
        // int val = Integer.valueOf(s);
        return s.length()<4 && Integer.valueOf(s)>=0 && Integer.valueOf(s)<=255;
    }
}
/*
https://leetcode.com/problems/split-array-into-fibonacci-sequence/
Approach - backtracking user-respect
*/
class Solution {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> temp = new ArrayList<>();
        doo(temp, S, 0);
        return temp;
    }
    
    public static boolean doo(List<Integer> temp, String s, int strt){
        if(strt==s.length()){
            if(temp.size()>2) return true;
            return false;
        }
        
        int val = 0;
        for(int i=strt; i<s.length(); i++){
            val = val*10+(s.charAt(i)-'0');

            //imp, out of integer limit
            if(val<0) return false;
            
            if(temp.size()<2||temp.get(temp.size()-1)+temp.get(temp.size()-2)==val){
                temp.add(val);
				//when we found sequence(positive base condition return true, return from here so fibo-sequence will remain in the list
                if(doo(temp, s, i+1)) 
                    return true;
                temp.remove(temp.size()-1);
            }
            
            if(i==strt && s.charAt(i)=='0') return false;
        }
        return false;
        
    }
}
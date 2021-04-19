/*
https://leetcode.com/problems/letter-combinations-of-a-phone-number/

Approach - Backtracking Element-respect
*/

class Solution {
    public List<String> letterCombinations(String digits) {
        String key[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv" , "wxyz"};
        List<String> list = new ArrayList<>();
        
        doo(key, digits, list, "");
        return list;
        
    }
    
    public static void doo(String key[], String d, List<String> list, String re, int i){
            
        if(d.length()==0){
            if(re.length()>0)
            list.add(re);
            // System.out.println(re+" ");
            return ;
        }

        String temp = key[d.charAt(0)-'0'];//getting chars of ith digit
        
        if(i>=temp.length()) return ;//negative base case
        
        //consider element, remove digit and append in result, set i=0 for next digit
        doo(key, d.substring(1), list, re+temp.charAt(i), 0);

        //Not consider, set i=i+1 to start from i+1 char in current digit
        doo(key, d, list, re, i+1);
            
    }
}
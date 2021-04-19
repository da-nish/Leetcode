/*
https://leetcode.com/problems/letter-combinations-of-a-phone-number/

Approach - Backtracking User-respect
*/

class Solution {
    public List<String> letterCombinations(String digits) {
        String key[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv" , "wxyz"};
        List<String> list = new ArrayList<>();
        
        doo(key, digits, list, "");
        return list;
        
    }
    
    public static void doo(String key[], String d, List<String> list, String re){
            
            if(d.length()==0){
                if(re.length()>0)
                list.add(re);
                return;
            }
            for(int i=0; i<key[d.charAt(0) - '0'].length(); i++){                
                doo(key, d.substring(1), list, re+key[d.charAt(0) - '0'].charAt(i));
            }
            
    }
}
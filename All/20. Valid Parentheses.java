// https://leetcode.com/problems/valid-parentheses/

class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> st = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(']', '[');
        map.put('}', '{');
        map.put(')', '(');

        
        for(Character c: s.toCharArray()){
            if(map.containsKey(c)){ //if close braket
                if(st.size()>0 && st.peek()==map.get(c))
                    st.pop();
                else
                    return false;
                
            }else{
                st.add(c);
            }
        }
        
        if(st.size()!=0) return false;
        return true;
        
        
    }
}
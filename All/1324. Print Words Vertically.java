// https://leetcode.com/problems/print-words-vertically/
class Solution {
    public List<String> printVertically(String s) {
        String st[] = s.split(" ");
        
        List<String> list = new ArrayList<>();
        
        int mx=-1;
        for(String t: st){
            mx = Math.max(mx, t.length());
        }
        
        for(int i=0; i<mx; i++){
            String temp="";
            for(int j=0; j<st.length; j++){
                if(i<st[j].length()) temp += st[j].charAt(i);
                else temp+=" ";
            }
            temp = trimend(temp);
            list.add(temp);
        }
        
        return list;
    }

    //remove whitespace from end
    public String trimend(String s){
        int len=0;
        for(int i=s.length()-1; i>=0; i--){
            if(s.charAt(i)==' ') len++;
            else break;
        }
        return s.substring(0, s.length()-len); 
    }
}
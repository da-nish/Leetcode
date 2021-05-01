/*
https://leetcode.com/problems/additive-number/
approach - bactracking user-respect
*/
class Solution {
    public boolean isAdditiveNumber(String num) {
        List<Integer> list = new ArrayList<>();
        re=false;
        doo(num, 0, list);
        
        return re;
    }
    static boolean re = false;
    public static boolean doo(String s, int strt, List<Integer> list){
    	// we need true or false in result 
    	// find only one answer cancel all recursive calls
        
        if(strt==s.length()){
            if(list.size()>2) return re = true;
        }

        if (re) return re;
        int val = 0;

        for(int i=strt; i<s.length(); i++){
        	//concatenation
            val = val*10+(s.charAt(i)-'0');
            
            if(list.size()<2 || list.get(list.size()-1)+list.get(list.size()-2)==val){
                list.add(val);
                doo(s, i+1, list);
                list.remove(list.size()-1);
            }
            
            //when first char is '0'
            if(i==strt&&s.charAt(i)=='0')
                return false;
        }
        return re;
        
    }
    
}
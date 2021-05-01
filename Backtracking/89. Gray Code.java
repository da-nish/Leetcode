/*
https://leetcode.com/problems/gray-code/
https://www.youtube.com/watch?v=KOD2BFauQbA
*/

class Solution {
       
    public List<Integer> grayCode(int n) {
        List<Integer> re = new ArrayList<>();
        List<String> list = code(n);
        for(String s:list){
            re.add(Integer.parseInt(s,2));   
        }
        return re;
      
    }
    
    static public List<String> code(int n) {
        if(n==1){
            List<String> li = new ArrayList<>();
            li.add("0");
            li.add("1");
            return li;
        }
        List<String> list = code(n-1);
        List<String> re = new ArrayList<>();
        
        for(int i=0; i<list.size(); i++){
            re.add("0"+list.get(i));
        }
        for(int i=list.size()-1; i>=0; i--){
            re.add("1"+list.get(i));
        }
        
        return re;
        
    }
    
   
    
    
}
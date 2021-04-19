/*
https://leetcode.com/problems/positions-of-large-groups/
*/

class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> re = new ArrayList<>();
        List<Integer> list;
        
        int n = s.length();
        int t = 1;
        
        for(int i=1; i<n; i++){
            
            if( s.charAt(i-1)==s.charAt(i) ) t++;
            else{
                
                if(t>=3){
                    list = new ArrayList<>();
                    list.add(i-t);
                    list.add(i-1);
                    re.add(list);
                }
                t=1; 
            }
            
        }//end for
        if(t>=3){
            list = new ArrayList<>();
            list.add(n-t);
            list.add(n-1);
            re.add(list);
        }
        
        return re;
    }
}
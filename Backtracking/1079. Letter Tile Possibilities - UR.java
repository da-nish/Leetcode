/*
https://leetcode.com/problems/letter-tile-possibilities/

Approach - Backtracking User Respect looping

*/

class Solution {
    public int numTilePossibilities(String tiles) {
        List<String> list = new ArrayList<>();
        int ar[] = new int[26];
        for(char c: tiles.toCharArray()){
            ar[c-'A']++;    
        }
        doo(list, "", ar);
        return list.size();
        
    }
    
    //in looping, we get result on each call
    public static void doo(List<String> list, String re, int ar[]){
        if(re.length()>0) list.add(re);
        
        for(int i=0; i<ar.length; i++){
            if(ar[i]!=0){
                ar[i]--;
                doo(list, re+(char)(i+'A'), ar);
                ar[i]++;
            }
        }
        
        
    }
}
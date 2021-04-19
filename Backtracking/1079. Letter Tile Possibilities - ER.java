/*
https://leetcode.com/problems/letter-tile-possibilities/

Approach - Backtracking Element Respect

INCOMPLETE

*/
import java.util.*;

class Solution {
    public static void main(String args[]) {
        String tiles = "AAB";
        List<String> list = new ArrayList<>();
        int ar[] = new int[26];
        for(char c: tiles.toCharArray()){
            ar[c-'A']++;    
        }
        doo(list, "", ar, 0);
        System.out.println(list);
        // return list.size();
        
    }
    
    public static void doo(List<String> list, String re, int ar[], int i){
        if(re.length()>0) list.add(re);
        
        if(ar[i]==0){
            doo(list, re, ar, i+1);
        }
        else{
            doo(list, re+(char)(i+'A'), ar, 0);
            doo(list, re, ar, i+1);
        }

    }
}
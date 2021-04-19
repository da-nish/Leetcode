/*
https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/
*/

class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        int n=deck.length;
        if(n<=1) return false;
        
        Map<Integer,Integer> map = new HashMap<>();
        for(int i:deck) map.put(i, map.getOrDefault(i,0)+1);

        int x = -1;
        
        for(int i: map.keySet()){
            if(x==-1) x = map.get(i);
            else x = gcd(x, map.get(i));
        }
        
        
        return x>=2;
    }
    
    public static int gcd(int x, int y){
        
        return x==0 ? y : gcd(y%x, x);
    }
    
}

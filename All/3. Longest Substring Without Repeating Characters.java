/*
https://leetcode.com/problems/longest-substring-without-repeating-characters/
*/
class Solution {
    //O(n square)
    public int lengthOfLongestSubstring(String s) {
        
        Set<Character> set = new HashSet<>();
        int mx=0;
        for(int i=0; i<s.length(); i++){
            int j=i;
            while(j<s.length() && !set.contains(s.charAt(j))){         
                set.add(s.charAt(j));
                mx = Math.max(mx, set.size());
                j++;
            }
            set.clear();
    
        }
        return mx;
    }



    //O(n), sliding window technique
    public int lengthOfLongestSubstring(String s) {
        
        Set<Character> set = new HashSet<>();
        int mx=0;
        int last=0;
        int first=0;
        
        while(last<s.length()){
            //increasing windows size when unique item
            if(!set.contains(s.charAt(last))){
                set.add(s.charAt(last));
                mx=Math.max(mx, set.size());
                last++;
            }
            //decreasing window size, removing from 0 ind -- n until we get all unique element in set
            else{
                set.remove(s.charAt(first));
                first++;
            }
        }
        return mx;
    }
}
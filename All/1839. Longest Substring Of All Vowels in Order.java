class Solution {
    
    //this solution is not working
    //i thing test case was wrong    
    public int longestBeautifulSubstring(String word) {
        char v[] = {'a','e','i','o','u','.'};
        
        int n=word.length();
        int re=0;
        for(int i=0; i<n; i++){
            
            if(word.charAt(i)!=v[0]) continue;
            int end=i;
            int j=1;
            
            while(j<v.length && end<n){
                
                if(word.charAt(end)==v[j]){
                    j++;
                }
                else if(word.charAt(end)==v[j-1]){}
                else{
                    break;
                }
                end++;
            }
            
            if(j>=5){
                re = Math.max(re, end-i);
                System.out.println(i+" "+end);
            }
            i=end;
        }
        
        return re;
    }


    /*
    //this solution is working 
    //copied
    public int longestBeautifulSubstring(String word) {
        int longest = 0;
        Set<Character> seen = new HashSet<>();
        for (int lo = -1, hi = 0; hi < word.length(); ++hi) {
            if (hi > 0 && word.charAt(hi - 1) > word.charAt(hi)) {
                seen = new HashSet<>();
                lo = hi - 1;
            }
            seen.add(word.charAt(hi));
            if (seen.size() == 5) {
                longest = Math.max(longest, hi - lo);
                System.out.println(lo+" "+hi);

            }
        }
        return longest;
    }
    */
}
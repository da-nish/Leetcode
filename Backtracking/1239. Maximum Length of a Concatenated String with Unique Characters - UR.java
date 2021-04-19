/*
https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/
Approach - Backtracking User-respect looping

*/

class Solution {
    public int maxLength(List<String> arr) {
        
        max=0;
		doo(arr, "", 0);
		// System.out.println(max);
        return max;
	}

	static int max = 0;
	public static void doo(List<String> s, String re, int strt){
		if(re.length()>max) max = Math.max(max,getmax(re));

		for(int i=strt; i<s.size(); i++){
			doo(s, re+s.get(i), i+1);
		}

	}

	public static int getmax(String re){
		Set<Character> set = new HashSet<>();
		for(char c:re.toCharArray()){
			if(set.contains(c)) return -1;
			else set.add(c);
		}
		return re.length();
	}
}
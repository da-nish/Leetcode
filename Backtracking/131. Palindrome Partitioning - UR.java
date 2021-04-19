/*
https://leetcode.com/problems/palindrome-partitioning/
Approach - Backtracking User-Respect looping

*/

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
		List<String> temp = new ArrayList<>();

		doo(s, 0, list, temp);
        return list;
    }
    
    public static void doo(String s, int strt, List<List<String>> list, List<String> temp){
		if(temp.size()>0 && strt==s.length()){
			list.add(new ArrayList<>(temp));
			return;
		}
		for(int i=strt; i<s.length(); i++){

			if(palin(s, strt, i)){
				if(strt==i){
					temp.add(""+s.charAt(i));
				}
				else{
					temp.add(s.substring(strt, i+1));
				}
				doo(s, i+1, list, temp);
				temp.remove(temp.size()-1);
			}

		}
	}


	public static boolean palin(String s, int i, int j){
		if(i==j) return true;

		while(i<j){
			if(s.charAt(i)!=s.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}
}

/*
https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
*/

class Solution {
    public List<Integer> findDisappearedNumbers(int[] ar) {
        
        int n = ar.length;
        
        List list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        
        for(int i:ar){
            if(!set.contains(new Integer(i))) set.add(new Integer(i));
        }
        
        for(int i=1; i<=n; i++){
            if(set.contains(new Integer(i))) set.remove(new Integer(i));
            else set.add(new Integer(i));
        }
        
        return new ArrayList<>(set);
        
    }
}
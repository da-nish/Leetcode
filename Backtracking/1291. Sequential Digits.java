/*
https://leetcode.com/problems/sequential-digits/

*/

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        
        List<Integer> list = new ArrayList<>();
        for(int i=1; i<=9; i++) doo(i, low, high, list);
        Collections.sort(list);
        return list;
    }
    
    public static void doo(int val, int low, int high, List<Integer> list){
        if(val>=low && val<=high) list.add(val);//positive bc
        if(val>high) return;//negative bc

        if(val%10==9) return;// if last digit is 9 then it became 100(wrong)
        
        int t = (val*10)+((val%10)+1);
        if(val%10!=9)
        doo(t, low, high, list);
        
    }
}
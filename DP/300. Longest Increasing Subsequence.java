/*
https://leetcode.com/problems/longest-increasing-subsequence/
*/
class Solution {
    public int lengthOfLIS(int[] nums) {


        int dp[][]=new int[nums.length+1][nums.length];
        for(int i[]:dp) Arrays.fill(i,-1);
        
        int result_recursion = lis(nums, -999999, 0);
        int result_recursion_memo = lis(nums, 0, 1, dp);
        //
        return lis(nums, -999999, 0);
    }
    

    /*  SOLUTION 1
        this solution is in exponential time 2^n
        Recursion

        last = previous value, Default -99999
        cur=current index
    */
    public int lis(int ar[], int last, int cur){
        if(cur>=ar.length) return 0;
        

        //consider when greater than last
        int consider = 0;
        if(ar[cur]>last){
            //update last value, +1 means consider
            consider = lis(ar, ar[cur], cur+1, dp)+1;
        }

        //not consider each time, do not update last value
        int notconsider = lis(ar, last, cur+1, dp);

        //return max 
        return Math.max(consider, notconsider);        
    }

    /*  SOLUTION 2
        this solution is in n^2 time
        Recursion + Memoization

        pre = previous index
        cur = current index

        using previous index Not value
        
        pre and cur working on 1-based index, but pre default is 0 to know first element(and make consider call for first element )  
        so access array[pre-1] OR array[cur-1] and in dp[cur][pre]

        call
        int dp[][]=new int[nums.length+1][nums.length];
        for(int i[]:dp) Arrays.fill(i,-1);
        result = lis(nums, 0, 1, dp);
    */
    public int lis(int ar[], int pre, int cur, int dp[][]){
        if(cur>ar.length) return 0;
         

        if(dp[cur][pre]!=-1) return dp[cur][pre];
        

        // consider when pre==0(first value)
        // consider when pre_index value < curr_index value
        int consider = 0;
        if(pre==0 || ar[cur-1]>ar[pre-1]){
            //update pre and cur index
            consider = lis(ar, cur, cur+1, dp)+1;//+1 
        }
        // not consider each time
        int notconsider = lis(ar, pre, cur+1, dp);

        return Math.max(consider, notconsider);  
    }

    /*  SOLUTION 3
        this solution is in n^2 time but using N space without recursion

        2 pointer technique
        
        call
        int dp[][]=new int[nums.length+1][nums.length];
        for(int i[]:dp) Arrays.fill(i,-1);
        result = lis(nums, 0, 1, dp);
    */

    public int lis(int ar[]){
        int n = ar.length;
        int dp[] = new int [n];
        Arrays.fill(dp,1);

        for (int i=1; i<n; i++) {
            for(int j=0; j<i; j++){
                if(ar[i]>ar[j]){
                    dp[i]=dp[j]+1;
                }
            }       
        }
        return dp[n-1];
    }

    /*  SOLUTION 4
        this solution is in nlogn time and using N space without recursion

        using TreeSet

        Treeset.ceiling(): it return equal or next greater element
        int cannot be compared with null So use Integer wrapper class
    */
    public int lis2(int[] nums) {
       if(nums.length==0) return 0;
        TreeSet<Integer> treeset = new TreeSet<>();
        
        for(int num: nums){
            Integer greater = treeset.ceiling(num);
            if(greater!=null){
                treeset.remove(greater);
            }
            treeset.add(num);
        }
        
        return treeset.size();
        
    }


    /*  SOLUTION 5
        this solution is in n time and using N space without recursion
        use arraylist or linkedlist


        implementing binary search to get i-th OR next i-th index
        it return equal or next greater element

    */
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        LinkedList<Integer> piles = new LinkedList<>();
        // 10 9 2 5 3 7 100 18
        for(int num : nums){
            if(piles.isEmpty() || num > piles.getLast()){
                piles.addLast(num);
            } else{
                int pos = binarySearch(piles, num);
                piles.set(pos, num); 
            }
        }
        return piles.size();
    }
    
    private int binarySearch(List<Integer> piles, int x){
        int left = 0, right = piles.size() - 1;

        while(left <= right){

            int mid = left + (right - left)/2;

            if(piles.get(mid) >= x){
                right = mid -1;
            }
            else{
                left = mid +1;
            }    
        }
        return right + 1;  
    }

}
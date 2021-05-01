/*

1. add 1 to N digit in array list;
2. find group of kth val  // first digit in group will be same  
	
	group=k/fac(n-1)
	if(k%fac(n-1)!=0) (when 2/6=0, but it should be first group)
		group++;
	
3. get the digit and remove
	int curr_digit = list.get(group); //getting digit
	list.remove(group); //removing digit, IMP

4. finding new k value for n-1 digit
    	int newK = k - (group-1)*n1_fac;
    	int newK = n1_fac - ((group*n1_fac)-k); //same line, use only one

5. recursive call
    return doo(n-1, newK, re+curr_digit, list);

6. base condition
	return re;


total permuation is factorial(n)


1234
1243
1324
1342
1423
1432
2134
2143
2314
2341
2413
2431
3124
3142
3214
3241
3412
3421
4123
4132
4213
4231
4312
4321

*/

class Solution {
    public String getPermutation(int n, int k) {
        
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<=n; i++) 
        	list.add(i);

		return doo(n, k, "", list);
    }

    public static String doo(int n, int k, String re, List<Integer> list){
    	if(n<=0) return re;

    	int n1_fac = fac(n-1); //n-1 permutation

    	int group = k/n1_fac;
    	if(k%n1_fac!=0) group++;

    	int t = list.get(group);
    	list.remove(group);

    	// finding new k value, for next n-1 digit
    	int newK = k - (group-1)*n1_fac;
    	//int newK = n1_fac - ((group*n1_fac)-k); //other way to find newK
    	
    	return doo(n-1, newK, re+t, list);
    }

    public static int fac(int n){
    	int val=1;
    	for(int i=2; i<=n; i++)
    		val=val*i;

    	return val;
    }
    
}
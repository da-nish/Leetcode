import java.util.*;
/*
https://leetcode.com/problems/next-permutation/
*/
class file{
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);

		int t = in.nextInt();
		while(t--!=0){
			int n = in.nextInt();
			int ar[] = new int[n];

			for(int i=0; i<n; i++){
				ar[i] = in.nextInt();
			}

			doo(ar, ar.length);
		}

	}

	public static void doo(int[] nums, int n) {
        int i = n - 2;

        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }

        //find just greater and swap
        if (i >= 0) {
            int j = n - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            int temp = nums[i];
        	nums[i] = nums[j];
        	nums[j] = temp;
        }

        //reversing

        i = i+1;
        int j = n - 1;
        while (i < j) {
            int temp = nums[i];
        	nums[i] = nums[j];
        	nums[j] = temp;
            i++;
            j--;
        }

        for(int ele: nums) 
        	System.out.println(ele+" ");
    }

}
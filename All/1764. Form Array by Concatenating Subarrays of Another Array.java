import java.util.*;

class file{
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
/*
[[1,-1,-1],[3,-2,0]]
[1,-1,0,1,-1,-1,3,-2,0]

{{21,22,21,22,21,30}};
{21,22,21,22,21,22,21,30};
*/
		int gp[][] = {{-5,0}};
		int ar[] = {2,0,-2,5,-1,2,4,3,4,-5,-5};

		System.out.println(canChoose(gp,ar));


	}

    public static boolean canChoose(int[][] gp, int[] ar) {
        
        int n=ar.length;
        int m=gp.length;
        int i = 0;
        int k = 0;

        while(k < m && i < n) {
            int[] g = gp[k];
            int j = 0;

            for(; j < g.length; ++j) {
            	if(i+j>=n) break;
                if(ar[i+j] != g[j]) break;
            }
            if(j==g.length) {
                ++k;
                i += j;
            }
            else ++i;
        }
        if(k==m) return true;
        return false;
    }

}	
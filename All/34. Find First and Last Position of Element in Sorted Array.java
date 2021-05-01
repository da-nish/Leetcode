class Solution {
    public int[] searchRange(int[] ar, int t) {
        

        int m=bs(ar,0,ar.length-1,t); //any index of target value

        // finding right index
        int right=m;
        while(right<ar.length-1 && right!=-1){
            if(ar[right+1]==ar[right]) right++;
            else break;
        }

        //finding left index
        int left=m;
        while(left>=1 && left!=-1){
            if(ar[left-1]==ar[left]) left--;
            else break;
        }

        
        int re[]={left, right};
        return re;
        
        
    }
    
    //binary search
    public static int bs(int ar[], int l, int r, int t){
        if(l>r) return -1;
        int m=(l+r)/2;
        if(t<ar[m]) return bs(ar, l, m-1, t);
        else if(t>ar[m]) return bs(ar, m+1, r, t);
        else return m;
    }
}
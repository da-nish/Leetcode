
/*
https://leetcode.com/problems/average-waiting-time/
1701. Average Waiting Time
*/
class Solution {
    public double averageWaitingTime(int[][] ar) {
        
        int wtime=0;
        double wait = 0;
        int n=ar.length;
        
        for(int i=0; i<n; i++){
            if(wtime<ar[i][0]){ //when chef is idle
                wtime = ar[i][0]+ar[i][1];  //total working time
                wait += wtime - ar[i][0];   //customer waiting time
            }
            else{ //when chef is working
                wtime += ar[i][1];          //total working time
                wait += wtime - ar[i][0];   //customer waiting time
            }
        }
        
        double re = wait/n; // avg time
        return re;
    }
}
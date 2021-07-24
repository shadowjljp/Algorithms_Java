package graph;

public class FindTheCelebrity277 {
    public int findCelebrity(int n) {
        int potential_Celebrity =0;
        for(int i=0;i<n;i++){
            if(know(potential_Celebrity,i)) potential_Celebrity = i;
        }
        if(check(potential_Celebrity,n)) return potential_Celebrity;
        return -1;
    }

    //function provide by leetcode
    private boolean know(int potential_celebrity, int i) {
        return true;
    }

    private boolean check(int potential_celebrity, int n) {
        for(int j=0;j<n;j++){
            if(potential_celebrity ==j) continue;
            if(know(potential_celebrity,j) || know(j,potential_celebrity)) return false;
        }
        return true;
    }
}

//https://leetcode.com/problems/n-queens


class Solution {
    private List<List<String>> result;
    private boolean [][] board;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        board = new boolean[n][n];
        helper(0,n);
        return result;
    }
    private void helper(int r, int n){
        //base
        if(r==n) {
            List<String> list = new ArrayList<>();
            for(int i=0;i<n;i++){
                StringBuilder str = new StringBuilder();
                for(int j=0;j<n;j++){
                    if(board[i][j]) str.append("Q");
                    else str.append(".");
                }
                list.add(str.toString());
            }
            result.add(list);
            return;
        }
        //logic
        for(int c=0;c<n;c++){
            if(isSafe(r,c,n)){
                board[r][c] = true;
                helper(r+1,n);
                board[r][c] = false;
            }
        }
    }
    private boolean isSafe(int r, int c, int n){
        for(int i=0; i< n; i++){
            if(board[i][c]) return false;
        }
        int i=r, j=c;
        while(i>=0 && j<n){
            if(board[i][j]) return false;
            i--;j++;
        }
        i=r; j=c;
        while(i>=0 && j>=0){
            if(board[i][j]) return false;
            i--;j--;
        }
        return true;
    }
}

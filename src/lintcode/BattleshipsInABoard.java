package lintcode;

public class BattleshipsInABoard {
	/**
     * @param board: the given 2D board
     * @return: the number of battle ships
     */
	public int countBattleships(char[][] board) {
        int len1 = board.length;
        if(len1 == 0){
            return 0;
        }
        int len2 = board[0].length;
        int ans = 0;
        for (int i = 0; i < len1; i++){
            for(int j=0 ; j < len2; j++){
                if(board[i][j] == 'X' && (i == 0 || board[i-1][j] == '.') && (j == 0 || board[i][j-1] == '.')){
                	/*
                	Case 1:
                		.
                		X YES
                		X NO
                		X NO
                		. NO
                		. NO
                	Case 2:
                		.   X   X   X   .
                		NO  YES NO  NO  NO
                	*/
                    ans ++;
                }
            }
        }
        return ans;
    }
}

public class TicTacToe {
	
	char[][] board = new char[3][3];
	//o will start the game (because next player changes player at start of game)
	char currentPlayer = 'x'; 
	
	public TicTacToe(){
		newBoard();
	}
	
	public void newBoard() {
		for(int i = 0; i < 3; i++){
			//Print out each row first
			for(int j = 0; j < 3; j++) {
				board[i][j] = '-';
			}
			//Skip a line, print the next row
			System.out.println();
		}
	}
	
	public void printBoard() {
		for(int i = 0; i < 3; i++){
			//Print out each row first
			for(int j = 0; j < 3; j++) {
				System.out.print(board[i][j] + " ");
			}
			//Skip a line, print the next row
			System.out.println();
		}
	}
	
	//  check if the game has been won
	public boolean checkforwin(){
		//only need to check 3 diagonal squares for player, because it is 
		//not possible to have 3 in a row w/o using one of those squares
		
		//check rows
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++) {
				if(board[i][j] == currentPlayer) {
					if(j == 2) {
						return true;
					}
				} else {
					//exit the j loop
					j = 3;
				} 
			}
		}
		
		//Check Columns
		for(int j = 0; j < 3; j++){
			for(int i = 0; i < 3; i++) {
				if(board[i][j] == currentPlayer) {
					if(i == 2) {
						return true;
					}
				} else {
					//exit the i loop
					i = 3;
				}
			}
		}
		
		//Check Diagonals
		if(board[1][1] == currentPlayer) {
			if(board[0][0] == currentPlayer && board[2][2] == currentPlayer){
				return true;
			} if(board[0][2] == currentPlayer && board[2][0] == currentPlayer){
				return true;
			}
		}
		return false;
		
	}
	
	public char getChar(int x, int y) {
		return board[x-1][y-1];
	}
		
	public char getCurrentPlayer(){
		return currentPlayer;
	}
	
	public char getNextPlayer(){
		if(currentPlayer == 'x'){
			currentPlayer = 'o';
		} else {
			currentPlayer = 'x';
		}
		return currentPlayer;
	}
	
	public void addToBoard(int x, int y) {
		board[x-1][y-1] = getCurrentPlayer();
	}

}

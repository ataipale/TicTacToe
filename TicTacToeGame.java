
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class TicTacToeGame {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		TicTacToe newGame = new TicTacToe();
		
		//track number of moves that have been made, to preclude checking for 
		//winning when less than 3 moves have been made by one player
		int moves = 0;
		boolean hasWon = false;
		
		while(!hasWon){
			boolean successfulAdd = false;
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Player " + newGame.getNextPlayer() + " Turn.");
			System.out.println();
			System.out.println("Current Board: ");
			newGame.printBoard();
			while (!successfulAdd) {
				System.out.println();
				System.out.println("Please enter your desired row number: ");
				int row = Integer.parseInt(br.readLine());
				System.out.println("Please enter your desired column number: ");
				int column = Integer.parseInt(br.readLine());
				if(newGame.getChar(row, column) == '-'){
					newGame.addToBoard(row, column);
					successfulAdd = true;
				}else {
					System.out.println("Spot already taken! Please enter new coordinates.");
				}
			}
			moves++;
			if (moves > 4) {
				hasWon = newGame.checkforwin();
			}
		}
		System.out.println("End Board: ");
		newGame.printBoard();
		System.out.println("Congrats, Player " + newGame.getCurrentPlayer() + ", you won!");
		
		
	}

}

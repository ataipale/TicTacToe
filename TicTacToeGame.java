/*Alex Taipale, 2014.02.02
 * Tic Tac Toe Game to be played between two humans in the console.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TicTacToeGame {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		TicTacToe newGame = new TicTacToe();
		
		//track number of moves that have been made, to preclude checking for 
		//winning when less than 3 moves have been made by one player and to
		//stop the game if 9 moves have been made, because the gris will be full!
		int moves = 0;
		boolean hasWon = false;
		
		while(!hasWon && moves < 9){
			
			newGame.getNextPlayer();
			System.out.println();
			System.out.println("Current Board: ");
			newGame.printBoard();
			int[] play = getPlayerMove(newGame);
			newGame.addToBoard(play[0], play[1]);
			moves++;
			if (moves > 4) {
				hasWon = newGame.checkforwin();
			}
			
		}
		
		System.out.println("End Board: ");
		newGame.printBoard();
		System.out.println();
		if (hasWon) {
			System.out.println("Congrats, Player " + newGame.getCurrentPlayer() + ", you won!");
		} else {
			System.out.println("It's a draw!");
		}
		
	}
	
	public static int[] getPlayerMove(TicTacToe Game) throws NumberFormatException, IOException {
		int[] playerMove = new int[2];
		//to check that entered coordinates were acceptable
		boolean successfulAdd = false; 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Human Player " + Game.getCurrentPlayer() + " Turn.");
		System.out.println();	
		while (!successfulAdd) {
			System.out.println();
			System.out.print("Please enter your desired row number: ");
			playerMove[0] = Integer.parseInt(br.readLine());
			System.out.print("Please enter your desired column number: ");
			playerMove[1] = Integer.parseInt(br.readLine());
			
			//Checks for in-bound coordinates
			if(playerMove[0] < 1 || playerMove[0] > 3 || playerMove[1] < 1 || playerMove[1] > 3) {
				System.out.println("Coordinates out of bounds. Please enter new coordinates.");
			} else {
				
				//Checks for open spot
				if(Game.getChar(playerMove[0], playerMove[1]) == '-'){
					successfulAdd = true;
				}else {
					System.out.println("Spot already taken! Please enter new coordinates.");
				}
			}
		}
		return playerMove; 
	}	

}

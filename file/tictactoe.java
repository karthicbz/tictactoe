import java.util.*;
public class tictactoe {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][] board = new char[3][3];
		int limit = 0;
		int playerValue = 0;
		boolean gameEnd = false;
		while(limit!=9 && gameEnd == false) {
			char[] players = {'X', 'O'};
			
			if(playerValue > 1) {
				playerValue = 0;
			}
			System.out.print(players[playerValue]+" Choose ur location: ");
			int x=sc.nextInt();
			int y=sc.nextInt();
			board[x][y] = players[playerValue];
			printBoard(board);
			gameEnd = gameLogic(board);
			playerValue += 1;
			limit += 1;
		}
		
		if(limit == 9) {
			System.out.println("Game tie");
		}
	}
	
	public static void printBoard(char[][] playingBoard) {
		for(int i=0; i<3; i++) {
			System.out.print("\t");
			for(int j=0; j<3; j++) {
				System.out.print(playingBoard[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static boolean gameLogic(char[][] boardValues) {
		boolean amIWin = false;
		char[] values = new char[3];
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				values[j] = boardValues[i][j];
			}
			amIWin = checkingWinner(values);
			if(amIWin)
				break;
			values = new char[3];
		}
		if(amIWin == false) {
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				values[j] = boardValues[j][i];
			}
			amIWin = checkingWinner(values);
			if(amIWin)
				break;
			values = new char[3];
		}
		}
		if(amIWin == false) {
			for(int i=0; i<1; i++) {
				for(int j=0; j<3; j++) {
					values[j] = boardValues[i][j];
					i+=1;
				}
				amIWin = checkingWinner(values);
				if(amIWin)
					break;
				values = new char[3];
			}
			
		}
		
		if(amIWin == false) {
			for(int i=0; i<1; i++) {
				for(int j=2; j>=0; j--) {
					values[j] = boardValues[i][j];
					i+=1;
				}
				amIWin = checkingWinner(values);
				if(amIWin)
					break;
				values = new char[3];
			}
			
		}
		return amIWin;
	}
	
	public static boolean checkingWinner(char[] currentValue) {
		boolean result = false;
		if(currentValue[0] == 'X' && currentValue[1] == 'X' && currentValue[2] == 'X') {
			System.out.println("Player X wins");
			result = true;
			//break;
		}else if(currentValue[0] == 'O' && currentValue[1] == 'O' && currentValue[2] == 'O') {
			System.out.println("Player Y wins");
			result = true;
			//break;
		}
		return result;
	}
}

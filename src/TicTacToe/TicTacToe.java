package TicTacToe;

import java.util.Scanner;

/**
 * @author vishnukumar.t
 *
 */
public class TicTacToe {
	private static Scanner sc = new Scanner(System.in);
	private static char[][] Board = new char[3][3];
	private static char Player = 'X';
	private static boolean Winner = true;
	private static int count = 0;

	public static void main(String[] args) {
		welcome();
		Run();
	}

	public static void Run() {
		while (Winner) {
			print();
			add();
			verify();
			result();
			changeplayer();
		}
		print();
		Rematch();
	}

	public static void Rematch() {
		System.out.println(" If you want Rematch press 0");
		if (sc.nextInt() == 0) {
			System.out.println("-------------------------------------------------------");
			Board = new char[3][3];
			Player = 'X';
			Winner = true;
			count = 0;
			Run();
		}
		System.exit(1);
	}

	public static void result() {
		if (!Winner)
			System.out.println("-------------------Player " + Player + " Won !!!!!!!!!!!-------------------");
	}

	public static void changeplayer() {
		Player = Player == 'X' ? '0' : 'X';
	}

	public static void verify() {
		for (int i = 0; i < 3; i++)
			if ((Board[i][0] == Player && Board[i][1] == Player && Board[i][2] == Player)
					|| (Board[0][i] == Player && Board[1][i] == Player && Board[2][i] == Player)) {
				Winner = false;
				return;
			}
		if ((Board[0][0] == Player && Board[1][1] == Player && Board[2][2] == Player)
				|| (Board[0][2] == Player && Board[1][1] == Player && Board[2][0] == Player)) {
			Winner = false;
			return;
		}
		// Winner=false;
	}

	public static void add() {

		if (count >= 9) {
			System.out.println("--------- Match is Tie ---------");
			Rematch();
			// System.exit(0);
		}
		System.out.print("Player " + Player + " enter : ");
		int row = sc.nextInt(), col = sc.nextInt();
		if (Board[row][col] == '\u0000') {
			Board[row][col] = Player;
			count++;
		} else
			System.out.println("invalid Move");

	}

	public static void print() {
		for (char[] arr : Board) {
			for (int i = 0; i < arr.length; i++)
				System.out.print(arr[i] + " |");
			System.out.println();
		}
	}

	public static void welcome() {
		System.out.println("    Welcome to TIC TAC TOE ");
	}
}

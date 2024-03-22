package RockPaperSiccors;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissor {
	private static Scanner sc = new Scanner(System.in);
	private static Random r = new Random();
	private static int score1 = 0, score2 = 0, n = 0, i = 1;

	public static void main(String[] args) throws InterruptedException {
		Greetings();
		caller();
	}

	static void caller() throws InterruptedException {
		System.out.println("Enter how many Rounds You Wanna Play ");
		n = sc.nextInt();
		for (; i <= n; i++) {
			moves();
			AnnounceRoundResult(RoundResult(logic(input(), random())));
		}
		MatchResult();

		System.out.println("\n Do You Wanna Play Again type 'yes' ");
		String s = sc.next().toLowerCase();
		if (s == "yes")
			caller();
	}

	static void Greetings() {
		System.out.println("--------------Welcome to VKGames-----------");
		System.out.println("             Rock Paper Scissor ");
	}

	static void moves() {
		System.out.println("\n            Round " + i);
		System.out.println(" 1 - Rock, 2 - Paper, 3 - Scissor  ");
		System.out.print(" Choose Your Move :");
	}

	static int input() {
		int input = sc.nextInt();
		if (input >= 1 && input <= 3)
			return input;
		else {
			System.out.println("Enter correct Number ");
			input();
		}
		return 0;
	}

	static int random() {
		int rando = r.nextInt(3) + 1;
		OpponentsMove(rando);
		return rando;
	}

	static int logic(int input, int random) {
		if (input == random)
			return 2;
		if (input == 1)
			return 1;
		if (input == 3 && random == 2)
			return 1;

		return 0;
	}

	static void OpponentsMove(int random) {
		System.out.println();
		if (random == 1)
			System.out.println("Opponent's move is 'Rock' ");
		else if (random == 2)
			System.out.println("Opponent's move is 'Paper' ");
		else
			System.out.println("Opponent's move is 'Scissor' ");
	}

	static String RoundResult(int status) {
		if (status == 0) {
			score2++;
			return " 'You Lose'!! ";
		}
		if (status == 1) {
			score1++;
			return " 'You Win' ";
		}
		score1++;
		score2++;
		return " Tie ";
	}

	static void AnnounceRoundResult(String result) {
		System.out.println();
		System.out.println("Round " + i + " Result : " + result);
	}

	static void MatchResult() throws InterruptedException {
		Thread.sleep(800);

		System.out.println("\n***Score Card***");
		Thread.sleep(500);
		System.out.println("Player 1 (You) - " + score1);
		System.out.println("\nPlayer 2     -   " + score2 + "\n");
		Thread.sleep(500);
		if (score1 == score2)
			System.out.println(" 'Awwww' Match is 'Tie' ");
		else if (score1 > score2)
			System.out.println(" 'Hooray'  'You Won' ");
		else {
			System.out.println(" **'You Lost'** ");
			System.out.println("\n Better Luck Next Time");
		}
		Thread.sleep(700);
	}
}

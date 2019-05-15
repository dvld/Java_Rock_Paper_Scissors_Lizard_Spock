package rpsls;

import java.util.Scanner;
import java.util.Random;

public class Rock_Paper_Scissors_Lizard_Spock {

	static int player_wins = 0;
	static int computer_wins = 0;
	static String player_choice;
	
	public static String ask_for_input() {
		Scanner input = new Scanner(System.in);
		System.out.println("Make your choice");
		player_choice = input.next();
		return player_choice.toLowerCase();
	}
	
	public static void player_win() {
		System.out.println("Player Wins");
		player_wins++;
	}
	
	public static String determine_user_hand() {

		player_choice = ask_for_input();
		do {
			
			if (player_choice.charAt(0) == 'r') {
				player_choice = "rock";
			} else if (player_choice.charAt(0) == 'p') {
				player_choice = "paper";
			} else if (player_choice.charAt(1) == 'c') {
				player_choice = "scissors";
			} else if (player_choice.charAt(1) == 'p') {
				player_choice = "spock";
			} else if (player_choice.charAt(0) == 'l') {
				player_choice = "lizard";
			} else {
				System.out.println("Invalid input. Try again.");
				player_choice = ask_for_input();
			}
		} while ((player_choice != "rock") && (player_choice != "paper") && (player_choice != "scissors") && (player_choice != "lizard") && (player_choice != "spock"));

		System.out.println("You chose " + player_choice);
		return player_choice;
	}
	
	public static String determine_computer_hand() {
		int computer_choice;
		String computer_hand;
		
		// configure random number
		Random random_number = new Random();
		
		// append computer_choice to random_number
		computer_choice = random_number.nextInt(100);
		
		// convert computer choice to string
		if (computer_choice <= 19) {
			computer_hand = "rock";
		} else if (computer_choice <= 39) {
			computer_hand = "paper";
		} else if (computer_choice <= 59) {
			computer_hand = "scissors";
		} else if (computer_choice <= 79) {
			computer_hand = "lizard";
		} else {
			computer_hand = "spock";
		}
		System.out.println("Computer chose " + computer_hand);
		return computer_hand;
	}
	
	public static void determine_winner() {
		String player_hand = determine_user_hand();
		String computer_hand = determine_computer_hand();
		if (player_hand.equals(computer_hand)) {
			System.out.println("Tie Game");
		} else if ( (player_hand.equals("rock")) && ( (computer_hand.equals("scissors")) || (computer_hand.equals("lizard")) ) ) {
			player_win();
		} else if ( (player_hand.equals("paper")) && ( (computer_hand.equals("rock")) || (computer_hand.equals("spock")) ) ) {
			player_win();
		} else if ( (player_hand.equals("scissors")) && ( (computer_hand.equals("paper")) || (computer_hand.equals("lizard")) ) ) {
			player_win();
		} else if ( (player_hand.equals("lizard")) && ( (computer_hand.equals("spock")) || (computer_hand.equals("paper")) ) ) {
			player_win();
		} else if ( (player_hand.equals("spock")) && ( (computer_hand.equals("rock")) || (computer_hand.equals("scissors")) ) ) {
			player_win();
		} else {
			System.out.println("Computer Wins");
			computer_wins++;
		}
	}
	
	public static void play_game() {
		Scanner rounds = new Scanner(System.in);
		System.out.println("How many rounds to win?");
		int number_of_rounds = rounds.nextInt();
		do {
			determine_winner();
		} while ((player_wins != number_of_rounds) && (computer_wins != number_of_rounds));
		if (player_wins == number_of_rounds) {
			System.out.println("Player wins the match!");
		} else if (computer_wins == number_of_rounds) {
			System.out.println("Computer wins the match!");
		}
	}
	
	public static void main(String[] args) {
		play_game();
	}

}

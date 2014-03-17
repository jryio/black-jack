package game;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Game {

	private static Player player;
	private static Hand hand;
	private static Dealer dealer;
	private static Shoe shoe = new Shoe(4);
	private static String playerName;
	private static double playerBank;
	private int numDecks;

	static Scanner intInput = new Scanner(System.in);
	static Scanner stringInput = new Scanner(System.in);
	static Random generate = new Random();

	public static void main(String[] args) {

		System.out.println(">WELCOME TO BLACKJACK, WHAT IS YOU NAME?:");
		playerName = stringInput.nextLine();
		playerName = playerName.toUpperCase();

		try {
			System.out
			.println(">GENERATING RANDOM BANK TO PLAY WITH $(50 - 2000)...");
			TimeUnit.MILLISECONDS.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		playerBank = (double) generate.nextInt(1950) + 50;
		System.out.println(">PLAYER BANK = $" + playerBank);

		try {
			System.out.println(">CREATING PLAYER...");
			TimeUnit.MILLISECONDS.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		hand = new Hand(shoe.dealCard(), shoe.dealCard());
		player = new Player(hand, playerName, playerBank);

		System.out.println(">PLAYER CREATED.");

		dealer = new Dealer(player, shoe);

		System.out.println("How much would you like to bet? (up to "
				+ player.getBankString() + ")");
		double bet = (double) intInput.nextInt();
		player.playerBet(bet);

		System.out.println(">ARE YOU READY TO START " + playerName + "? (y/n)");
		String answer = stringInput.nextLine();
		answer.toLowerCase();
		try {
			if (answer.equals("y")) {
				play();
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
	}

	public static void play() {
		while (dealer.getHandEnd() == false) {
			dealer.firstDeal();
		}
		playAgain();

	}

	public static void playAgain() {
		System.out.println("\n>Do you wan to play again?(y/n)");
		String answer = stringInput.nextLine();
		answer.toLowerCase();
		try {
			if (answer.equals("y")) {
				dealer.handEndReset();
				play();
			} else {
				System.out.println("Thanks for playing. Your total: "
						+ player.getBank());
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
	}

}

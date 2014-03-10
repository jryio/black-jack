package game;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Player {

	private double playerBank = 0;
	private String playerBankString;
	private String playerName;
	private double playerBet;
	private Hand hand;

	NumberFormat formatter = NumberFormat.getCurrencyInstance();
	Scanner intInput = new Scanner(System.in);
	Scanner stringInput = new Scanner(System.in);
	Random generate = new Random();

	public Player(Hand h, String name, double cash) {
		this.playerName = name;
		this.playerBank = cash;
		this.playerBankString = formatter.format(cash);
		this.hand = h;
	}

	public void hit(Card c) {
		hand.addCard(c);
		System.out.println("Dealer dealt: " + c.toString());
		if (hand.getHandValue() > 21) {
			if ((hand.getHandRanks().contains("Ace"))) {

				hand.getHand().get(hand.getHandRanks().indexOf("Ace")).setAce();

			} else {
				playerBust();
			}
		}
	}
		

	public void clearHand() {
		hand.clearHand();
	}

	public void playerBet(double bet) {
		this.playerBet = bet;
		if (playerBank > 0) {
			playerBank -= bet;
			playerBankString = formatter.format(playerBank);
		} else {
			System.out.println("You have no more moeny, game is over.");
		}
	}

	public void playerBust() {
		System.out.println("You busted.");
		this.hand.clearHand();
		playerBet = 0;

	}

	public void playerLost() {
		System.out.println("You lost");
		this.hand.clearHand();
		playerBet = 0;
	}

	public void wonBet() {
		if (hand.getHand().get(0).getRank().equals("Ace")
				&& (hand.getHand().get(1).getRank().equals("King")
						|| hand.getHand().get(1).getRank().equals("Queen")
						|| hand.getHand().get(1).getRank().equals("Jack") || hand
						.getHand().get(1).getRank().equals("Ten"))) {
			blackJack();
		} else {
			System.out.println("You won: $" + playerBet);
			playerBank += 2 * playerBet;
			playerBankString = formatter.format(playerBank);
			playerBet = 0;
		}

	}

	public void insurance() {
		double pBank = playerBank;
		double pBet = playerBet;

		if ((pBank -= (0.5) * pBet) >= 0) {
			System.out.println("Dealer's Visible Card is an Ace. "
					+ "Would you like to purchase Insurance? "
					+ "(y/n): ");
			String playerAction = stringInput.nextLine();
			playerAction.toLowerCase();
			switch (playerAction) {
			case "y":
				playerBet += ((0.5) * playerBet);
				playerBank -= playerBet;
				playerBankString = formatter.format(playerBank);
				System.out.println("Current bet: " + playerBet);
				break;
			case "n":
				break;
			}
		}
	}

	public void blackJack() {
		System.out.println("You got BlackJack! You won:  " + (3 * playerBet)
				/ 2);
		playerBank += (3 * playerBet) / 2;
		playerBankString = formatter.format(playerBank);
		playerBet = 0;
	}

	public Hand getHand() {
		return hand;
	}

	public ArrayList<Card> getHandArray() {
		return hand.getHand();
	}

	public double getBank() {
		return playerBank;
	}

	public double getBet() {
		return playerBet;
	}

	public String getBankString() {
		return playerBankString;
	}

	public String toString() {
		return playerName + " - " + playerBankString + " with hand: "
				+ hand.toString();
	}

}

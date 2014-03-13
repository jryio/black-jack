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
	private boolean gameEnd = false;

	NumberFormat formatter = NumberFormat.getCurrencyInstance();
	Scanner intInput = new Scanner(System.in);
	Scanner stringInput = new Scanner(System.in);

	public Player(Hand h, String name, double cash) {
		this.playerName = name;
		this.playerBank = cash;
		this.playerBankString = formatter.format(cash);
		this.hand = h;
	}

	public void hit(Card c) {
		hand.addCard(c);
		
		System.out.println("Dealer dealt: " + c.toString());
		if (hand.getHandValue() > 21 && (hand.getHandRanks().contains("Ace"))) {

			hand.getHand().get(hand.getHandRanks().indexOf("Ace")).setAce();
			hand.setAceValue();
			System.out.println(this.toString());

		} else if (hand.getHandValue() > 21
				&& !(hand.getHandRanks().contains("Ace"))) {
			playerBust();
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
		playerBet = 0;
		gameEnd = true;

	}

	public void playerLost() {
		System.out.println("You lost");
		this.hand.clearHand();
		playerBet = 0;
		gameEnd = true;
	}

	public void playerPush() {
		playerBank += playerBet;
		playerBet = 0;
		playerBankString = formatter.format(playerBank);
		gameEnd = true;
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
			gameEnd = true;
		}

	}

	public void insurance() {
		double pBank = playerBank;
		double pBet = playerBet;

		if ((pBank -= (0.5) * pBet) >= 0) {
			System.out.println("Dealer's Visible Card is an Ace. "
					+ "Would you like to purchase Insurance? " + "(y/n): ");
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
		playerBank += (3 * playerBet) / 2;
		playerBankString = formatter.format(playerBank);
		System.out.println("You got BlackJack! You won:  " + playerBankString);
		playerBet = 0;
		gameEnd = true;
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

	public boolean getGameEnd() {
		return gameEnd;
	}

	public String getBankString() {
		return playerBankString;
	}

	public String toString() {
		return playerName + " - " + playerBankString + " with hand: "
				+ hand.toString();
	}

}

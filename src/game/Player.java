package game;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Player {

	// Defines the player's Bank, Name, Bet, Hand, and BankString (for printing
	// purposes).
	private double playerBank = 0;
	private String playerBankString;
	private String playerName;
	private double playerBet;
	private Hand hand;
	private boolean gameEnd = false;
	private boolean playerBusted = false;

	// Imports and Instantiates NumberFormatter
	NumberFormat formatter = NumberFormat.getCurrencyInstance();
	// Imports and Instantiates Scanner for Integers
	Scanner intInput = new Scanner(System.in);
	// Imports and Instantiates Scanner for Strings
	Scanner stringInput = new Scanner(System.in);

	// Player constructor takes a player's Hand, Name, and Bank to start and
	// assigns them to private variables defined above. player hand is not
	// instantiated
	public Player(Hand h, String name, double cash) {
		this.playerName = name;
		this.playerBank = cash;
		this.playerBankString = formatter.format(cash);
		this.hand = h;
	}

	// Hit adds a card to the player's hand and checks to see if that card
	// caused the handValue to exceed 21 (breaking the rules) or if the player
	// got a natural BlackJack from the first hand.
	public void hit(Card c) {
		hand.addCard(c);

		System.out.println(">Dealt: " + c.toString());
		if (hand.getHandValue() > 21 && (hand.getHValues().contains(11))) {

			hand.getHand().get(hand.getHandRanks().indexOf("Ace")).setAce();
			hand.setAceValue();
			hand.setAceValue();
			System.out.println(this.toString());

		} else if (hand.getHandValue() > 21
				&& !(hand.getHandRanks().contains("Ace"))) {
			playerBust();
		}

	}

	// Uses the hand's clearHand() method
	public void clearHand() {
		hand.clearHand();
	}

	// Takes a bet amount as a parameter and subtracts the value from the
	// playerBank. Only allows the bet to take place if the player's Bank is
	// greater than zero.
	public void playerBet(double bet) {
		this.playerBet = bet;
		if (playerBank > 0) {
			playerBank -= bet;
			playerBankString = formatter.format(playerBank);
		} else {
			System.out.println("You have no more money, game is over.");
		}
	}

	// When the player goes over 21 they bust and their bet is lost to the
	// dealer. playerBest = 0;
	public void playerBust() {
		System.out.println("You busted.");
		playerBet = 0;
		playerBusted = true;
		gameEnd = true;

	}
	
	public boolean ifBusted(){
		return playerBusted;
		
	}

	// If the player's hand was less than the dealer's then they lost and their
	// hand is cleared and their bet is set to zero
	public void playerLost() {
		System.out.println("You lost");
		this.hand.clearHand();
		playerBet = 0;
		gameEnd = true;
	}

	// If the player and the dealer get the same amount they push, 1:1 payout
	public void playerPush() {
		playerBank += playerBet;
		playerBet = 0;
		playerBankString = formatter.format(playerBank);
		gameEnd = true;
	}

	// wonBet() determines what type of win the player has received and calls
	// the appropriate method(s)
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
			this.hand.clearHand();
		}

	}

	// If the dealer's visible card is an Ace then the player has the option
	// to purchase insurance which is half of the original bet added to the
	// pool.
	// If the dealer doesn't have BlackJack then the player loses their
	// insurance wager. If the dealer does, then the player loses their original
	// bet and the insurance money pays off 2:1
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
				pBank = 0;
				pBet = 0;
				break;
			case "n":
				pBank = 0;
				pBet = 0;
				break;
			}
		}
	}

	public void doubleDown() {
		playerBet *= 2;
		playerBank -= playerBet;
		playerBankString = formatter.format(playerBank);
		System.out.println("Youn doubled down, current bet is: "
				+ this.getBet());
	}

	// Calculates proper payout for when the player gets BlackJack(0
	public void blackJack() {
		playerBank += (3 * playerBet) / 2;
		playerBankString = formatter.format(playerBank);
		System.out.println("You got BlackJack! You won:  " + playerBankString);
		playerBet = 0;
		gameEnd = true;
	}

	// Returns the Hand object
	public Hand getHand() {
		return hand;
	}

	// Returns the ArrayList of Cards, hand.getHand();
	public ArrayList<Card> getHandArray() {
		return hand.getHand();
	}

	// Returns the playerBank
	public double getBank() {
		return playerBank;
	}

	// returns the playerBet
	public double getBet() {
		return playerBet;
	}

	// Returns the Boolean when the game is over to check if it passes
	public boolean getGameEnd() {
		return gameEnd;
	}

	// Returns String playerBankString which has been formatter with
	// NumberFormatter for currency
	public String getBankString() {
		return playerBankString;
	}

	// Returns a String of relevant information about the player, their bet,
	// and their hand.
	public String toString() {
		return playerName + " - " + playerBankString + " with hand: "
				+ hand.toString();
	}

}

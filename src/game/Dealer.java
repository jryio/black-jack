package game;

import java.util.Scanner;

public class Dealer {

	private Hand dealerHand;
	private Shoe shoe;
	private Player player;
	private boolean handEnd = false;
	Scanner stringInput = new Scanner(System.in);
	Scanner intInput = new Scanner(System.in);

	public Dealer(Player p, Shoe s) {

		this.shoe = s;
		this.player = p;
	}

	public void firstDeal() {

		this.dealerHand = new Hand(shoe.dealCard(), shoe.dealCard());

		System.out
		.println("====================================================");
		System.out.println(">Dealer's  visible card is: "
				+ dealerHand.getHand().get(1).toString());
		
		System.out.println("TESTING: DEALER'S SECOND CARD - "
				+ dealerHand.getHand().get(0).toString());

		player.clearHand();

		System.out.println(">Dealing cards to player...");
		System.out
		.println("====================================================");

		player.hit(shoe.dealCard());
		player.hit(shoe.dealCard());

		System.out.println(player.toString());

		if (player.getBank() - (2 * player.getBet()) > 0) {
			System.out
			.println("\n>Would you like to double down now?(y/n) You have "
					+ player.getBankString() + " remaining");
			String answer = stringInput.nextLine();
			answer.toLowerCase();
			try {
				if (answer.equals("y")) {
					player.doubleDown();
				}
			} catch (IllegalStateException e) {
				e.getMessage();
				e.printStackTrace();
			}
		}

		if (player.getHand().getHandValue() == 21) {
			dealerStand();
		} else if (dealerHand.getHand().get(1).getRank().equals("Ace")) {
			player.insurance();
			playerTurn();
		} else {
			playerTurn();
		}
	}

	public void playerTurn() {

		do {
			System.out.println("Hit(1):\tStay(2):");
			int playerAction = intInput.nextInt();
			if (playerAction == 1) {
				player.hit(shoe.dealCard());
			} else if (playerAction == 2) {
				System.out.println("You stayed");
				break;
			}
		} while (player.getHand().getHandValue() < 21);

		dealerHit();
	}

	// dealerHit() needs work now because the cards get added without any form
	// of notification.

	// Also follow the logic down to dealerStand() as the
	// "won bet" - "lost bet" ends are stuck in an infinite loop. They need
	// to break out of the infinite loop that playerTurn() and dealerHit() use.
	// Basically once someone has won a hand they need to break out of the
	// while loop somehow.
	public void dealerHit() {

		System.out.println(">Dealer's hidden card was: "
				+ dealerHand.getHand().get(0).toString());

		while (dealerHand.getHandValue() < 21) {

			if (dealerHand.getHandValue() < 17
					&& !dealerHand.getHValues().contains(11)) {

				dealerHand.addCard(shoe.dealCard());
				System.out.println(">Dealer HIT - Dealer's Hand: "
						+ dealerHand.toString());

			} else if (dealerHand.getHandValue() >= 17
					&& dealerHand.getHandValue() > 21
					&& dealerHand.getHValues().contains(11)) {

				dealerHand.getHand().get(dealerHand.getHValues().indexOf(11))
				.setAce();
				dealerHand.setAceValue();

				dealerHand.addCard(shoe.dealCard());
				System.out.println(">Dealer HIT - Dealer's Hand: "
						+ dealerHand.toString());

			} else if ((dealerHand.getHandValue() >= 17 && !dealerHand
					.getHValues().contains(11))) {
				System.out.println(">Dealer stops dealing cards");
				break;
			}
		}

		if (dealerHand.getHandValue() > 21) {
			dealerBust();
		} else {
			dealerStand();
		}

	}

	public void dealerBust() {
		System.out.println("Dealer Busted");
		dealerHand.clearHand();
		player.wonBet();
		handEnd = true;
	}

	public void dealerLost() {
		player.wonBet();
		dealerHand.clearHand();
		handEnd = true;
	}

	public void dealerPush() {
		System.out
		.println(">Dealer and Player have the same hand, game is a push");
		player.playerPush();
		handEnd = true;
	}

	public void dealerWon() {
		if (dealerHand.getHandRanks().contains("Ace")
				&& (dealerHand.getHandRanks().contains("Ten") || dealerHand
						.getHandRanks().contains("Jack"))
						|| dealerHand.getHandRanks().contains("Queen")
						|| dealerHand.getHandRanks().contains("King")) {

			System.out.println("Dealer got BlackJack!");
			dealerHand.clearHand();
			player.playerLost();
			handEnd = true;

		}

		else {
			player.playerLost();
			handEnd = true;
		}
	}

	public void dealerStand() {
		if (player.ifBusted() == true) {
			player.playerBust();
		} else if (dealerHand.getHandValue() < player.getHand().getHandValue()) {
			dealerLost();
		} else if (dealerHand.getHandValue() > player.getHand().getHandValue()) {
			dealerWon();
		} else {
			dealerPush();
		}
	}

	public Player getPlayer() {
		return player;
	}
	
	public boolean getHandEnd(){
		return handEnd;
	}
	
	public void handEndReset(){
		handEnd = false;
	}

	public String toString() {
		return player.toString();
	}
}

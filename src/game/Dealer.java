package game;

import java.util.Scanner;

public class Dealer {

	private Hand dealerHand;
	private Shoe shoe;
	private Player player;
	Scanner stringInput = new Scanner(System.in);
	Scanner intInput = new Scanner(System.in);

	public Dealer(Player p, Shoe s) {

		this.shoe = s;
		this.player = p;
		this.dealerHand = new Hand(new Card(0,0), new Card(0,0));
	}

	public void firstDeal() {

		dealerHand.addCard(shoe.dealCard());
		dealerHand.addCard(shoe.dealCard());

		System.out.println("Dealer's  visible card is: "
				+ dealerHand.getHand().get(1).toString());

		System.out.println("Dealing cards to player...");
		player.hit(shoe.dealCard());
		player.hit(shoe.dealCard());

		player.toString();

		if (player.getHand().getHandValue() == 21) {
			player.wonBet();
		} else if (dealerHand.getHand().get(1).getRank().equals("Ace")) {
			player.insurance();
			playerTurn();
		} 
		else {
			playerTurn();
		}
	}

	public void playerTurn() {
		while (player.getHand().getHandValue() < 21) {
			System.out.println("Hit(1):\tStay(2):");
			int playerAction = intInput.nextInt();
			if (playerAction == 1) {
				player.hit(shoe.dealCard());
			} else if (playerAction == 2) {
				System.out.println("You stayed");
				break;
			}

			dealerHit();
		}
	}

	public void dealerHit() {
		while (dealerHand.getHandValue() < 21) {
			if (dealerHand.getHandValue() < 17
					&& !dealerHand.getHandRanks().contains("Ace")) {

				dealerHand.addCard(shoe.dealCard());
				dealerHand.toString();

			} else if (dealerHand.getHandValue() < 17
					&& dealerHand.getHandRanks().contains("Ace")) {

				dealerHand.getHand()
						.get(dealerHand.getHandRanks().indexOf("Ace")).setAce();

				dealerHand.addCard(shoe.dealCard());
				dealerHand.toString();

			} else if (dealerHand.getHandValue() == 17) {
				dealerStand();
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
	}

	public void dealerLost() {
		System.out.println("Dealer lost");
		dealerHand.clearHand();
		player.wonBet();
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
		} else {
			System.out.println("Dealer won");
			player.playerLost();
		}
	}

	public void dealerStand() {
		if (dealerHand.getHandValue() < player.getHand().getHandValue()) {
			dealerLost();
		} else if (dealerHand.getHandValue() > player.getHand().getHandValue()) {
			dealerWon();
		} else {
			System.out.println("Draw: same value as dealer");
		}
	}

	public Player getPlayer() {
		return player;
	}

	public String toString() {
		return player.toString();
	}
}

package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Shoe {

	//Defines ArrayList Shoe, minimum number of dekcs, cards dealt, the deck
	//count, the total number of cards in the shoe, and the reaminaing cards.
	private ArrayList<Card> Shoe = new ArrayList<Card>();
	private final int minDecks = 4;
	private int dealt = 0;
	private int deckCount;
	private int numCards;
	private int cardsRemaining;

	//Import and instantiate Scanner
	Scanner stringInput = new Scanner(System.in);

	//Constructor takes a number of decks and interates through the dekcs and 
	//fills the shoe
	public Shoe(int numDecks) {
		this.deckCount = numDecks;
		this.numCards = deckCount * numDecks;
		if (numDecks >= minDecks) {
			for (int i = 1; i < 14; i++) {
				for (int j = 1; j < 4; j++) {
					Shoe.add(new Card(i, j));
				}
			}
		} else {
			throw new IllegalStateException("Minimum decks is 4");
		}
		Collections.shuffle(Shoe);
	}

	//Uses Collections to shuffle the ArrayList Shoe.
	public void shuffle() {
		Collections.shuffle(Shoe);
	}

	//Deals a card and keeps track of the cards dealt and reaming cards, if
	//the cards get low the it reshuffles the deck
	public Card dealCard() {
		numCards = deckCount * 52;
		if (dealt >= numCards) {
			throw new IllegalStateException("No Cards Left In The Deck");
		} else {

			cardsRemaining = numCards - dealt;
			switch (cardsRemaining) {
			case 15:
				System.out.println("15 cards remaining in the shoe");
				break;
			case 5:
				System.out
				.println("5 cards remaining in the shoe, adding cards "
						+ "to shoe ");
				Shoe.clear();
				for (int h = 0; h < deckCount; h++) {
					for (int i = 1; i < 14; i++) {
						for (int j = 1; j < 4; j++) {
							Shoe.add(new Card(i, j));
							Collections.shuffle(Shoe);
						}
					}
				}
				break;
			}

			dealt++;
			return Shoe.get(dealt - 1);
		}
	}

	//Returns the ArrayList Shoe;
	public ArrayList<Card> getShoe() {
		return Shoe;
	}

}
package game;

public class Card {

	//Each card has three attributes: Rank, Suit, Value (where value is the 
	//numerical value of the card).
	private int rankNumber, suitNumber;
	private String rank, suit;
	private int value;

	public Card(int r, int s) {

		rankNumber = r; //Construction assigns r to rankNumber
		suitNumber = s; //Construction assigns s to suitNumber

		//Switch statement takes the integer values that are passes into the 
		//Constructor and assigns String to those integer values
		switch (rankNumber) {
		case 0:
			rank = null;
			value = 0;
			break;
		case 1:
			rank = "Ace";
			value = 11;
			break;
		case 2:
			rank = "Two";
			value = rankNumber;
			break;
		case 3:
			rank = "Three";
			value = rankNumber;
			break;
		case 4:
			rank = "Four";
			value = rankNumber;
			break;
		case 5:
			rank = "Five";
			value = rankNumber;
			break;
		case 6:
			rank = "Six";
			value = rankNumber;
			break;
		case 7:
			rank = "Seven";
			value = rankNumber;
			break;
		case 8:
			rank = "Eight";
			value = rankNumber;
			break;
		case 9:
			rank = "Nine";
			value = rankNumber;
			break;
		case 10:
			rank = "Ten";
			value = rankNumber;
			break;
		case 11:
			rank = "Jack";
			value = 10;
			break;
		case 12:
			rank = "Queen";
			value = 10;
			break;
		case 13:
			rank = "King";
			value = 10;
			break;
		default:
				throw new IllegalStateException("Invalid Card Rank");
		}

		switch (suitNumber) {
		case 0:
			suit = null;
			break;
		case 1:
			suit = "Hearts";
			break;
		case 2:
			suit = "Spades";
			break;
		case 3:
			suit = "Clubs";
			break;
		case 4:
			suit = "Diamonds";
			break;
		default:
			throw new IllegalStateException("Invalid Card Suit");
		}
	}

	//returns String rank (2-10 and J-A)
	public String getRank() {

		return rank;
	}

	//returns card's numerical value, value
	public int getValue() {
		return value;
	}

	//if a player goes over 21 with an Ace then setAce() sets the value to 1
	//from 11
	public void setAce() {
		System.out.println("Dealer changes " + this.toString() + " to 1");
		value = 1;
		
	}

	//returns the String suit (Clubs, Diamonds, Spades, Hearts)
	public String getSuit() {
		return suit;
	}

	//returns a String that contains rank and suit Strings
	public String toString() {
		return this.getRank() + " of " + this.getSuit();
	}
}

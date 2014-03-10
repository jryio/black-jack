package game;

import java.io.IOException;
import java.util.ArrayList;

public class Hand {

	private ArrayList<Card> Hand = new ArrayList<Card>();
	private ArrayList<String> Ranks = new ArrayList<String>();
	private int handValue;

	public Hand(Card a, Card b) {
		Hand.add(a);
		Ranks.add(a.getRank());
		handValue += a.getValue();
		Hand.add(b);
		Ranks.add(b.getRank());
		handValue += b.getValue();
	}

	public void addCard(Card c) {
		Hand.add(c);
		Ranks.add(c.getRank());
		handValue += c.getValue();
	}

	public int getHandValue() {
		return handValue;
	}

	public void clearHand() {
		Hand.clear();
	}

	public ArrayList<Card> getHand() {
		return Hand;
	}
	
	public ArrayList<String> getHandRanks(){
		return Ranks;
	}

	public String toString() {
		return Hand.toString();
	}
}

package game;

import java.io.IOException;
import java.util.ArrayList;

public class Hand {

	private ArrayList<Card> Hand = new ArrayList<Card>();
	private ArrayList<String> Ranks = new ArrayList<String>();
	private ArrayList<Integer> Values = new ArrayList<Integer>();
	private int handValue;

	public Hand(Card a, Card b) {
		Hand.add(a);
		Ranks.add(a.getRank());
		Values.add(a.getValue());
		handValue += a.getValue();

		Hand.add(b);
		Ranks.add(b.getRank());
		Values.add(b.getValue());
		handValue += b.getValue();
	}

	public void addCard(Card c) {
		Hand.add(c);
		Ranks.add(c.getRank());
		Values.add(c.getValue());
		handValue += c.getValue();
	}

	public int getHandValue() {
		return handValue;
	}

	public void clearHand() {
		Hand.clear();
		handValue = 0;
		Ranks.clear();
		Values.clear();
	}
	
	public void setAceValue(){
		handValue -= 10;
	}

	public ArrayList<Card> getHand() {
		return Hand;
	}
	
	public ArrayList<Integer> getHValues(){
		return Values;
	}

	public ArrayList<String> getHandRanks() {
		return Ranks;
	}

	public String toString() {
		return Hand.toString();
	}
}

package game;

import java.util.ArrayList;

public class Hand {

	//Defines three ArrayLists, one for all the Cards in the hand, another for
	//the String of the Ranks of each card, and one for the Integer values of 
	//each card.
	private ArrayList<Card> Hand = new ArrayList<Card>();
	private ArrayList<String> Ranks = new ArrayList<String>();
	private ArrayList<Integer> Values = new ArrayList<Integer>();
	private int handValue;

	//Constructor takes two cards as parameters and adds them to Hand while
	//adding their data to Values and Ranks
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

	//addCard inserts a Card into the Hand ArrayList and then adds the data
	//into Values and Ranks while keeping an integer total of the handValue
	public void addCard(Card c) {
		Hand.add(c);
		handValue += c.getValue();
		Ranks.add(c.getRank());
		Values.add(c.getValue());
		
	}

	//Returns the value of the hand (in total)
	public int getHandValue() {
		return handValue;
	}

	//Clears all data from the hand, usually used when a player wins or loses
	//and wants to move onto the next round
	public void clearHand() {
		Hand.clear();
		handValue = 0;
		Ranks.clear();
		Values.clear();
	}
	
	public void handBust(){
		handValue = 0;
	}
	
	//Changes the handValue is an ace is reset at some point in Player
	public void setAceValue(){
		Values.remove(Values.indexOf(11));
		Ranks.remove(Ranks.indexOf("Ace"));
		handValue -= 10;
	}

	//Returns the ArrayList of Cards, Hand
	public ArrayList<Card> getHand() {
		return Hand;
	}
	
	//Returns the ArrayList of Integers, Values
	public ArrayList<Integer> getHValues(){
		return Values;
	}

	//Returns the ArrayList of Strings, Ranks
	public ArrayList<String> getHandRanks() {
		return Ranks;
	}

	//returns a string contain all the cards in the hand.
	public String toString() {
		return Hand.toString();
	}
}

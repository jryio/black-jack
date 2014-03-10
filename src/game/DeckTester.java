package game;

public class DeckTester {

	public static void main (String[] args){
		Deck deckOne = new Deck();
		deckOne.shuffle();
		for(Card c : deckOne.getDeck()){
			System.out.println(c.toString());
		}
	}
}

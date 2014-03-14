package game;

/*
 * Tester tests the Card.java class and covers all methods in the class
 */
public class CardTester {

	public static void main(String[] args) {
	
		//Tests the card if it is an Ace and tests setAce()
		Card c = new Card(1,2);
		
		System.out.println(c.getRank());
		System.out.println(c.getValue());
		System.out.println(c.getSuit());
		c.setAce();
		 
		System.out.println(c.toString());
		
	}
}

package game;

public class ShoeTester {
	public static void main(String[] args) {
		
		Shoe shoe = new Shoe(4);
		
		//Iterates through all of the cards in Shoe and prints its value
		for (int i = 0; i < shoe.getShoe().size(); i++) {
			for (Card c : shoe.getShoe()) {
				System.out.println(c.toString());
			}
		}
		
		System.out.println("TESTING: Dealing a card and printing the value: ");
		System.out.println(shoe.dealCard().toString());
	}
}

package game;

public class ShoeTester {
	public static void main(String[] args) {
		
		Shoe shoe = new Shoe(4);
		
		for (int i = 0; i < shoe.getShoe().size(); i++) {
			for (Card c : shoe.getShoe()) {
				System.out.println(c.toString());
			}
		}
	}
}

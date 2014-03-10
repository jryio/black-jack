package game;


public class HandTester{
	
	public static void main(String[] args){
		Card a = new Card(4, 3);
		Card b = new Card(12, 3);
		Card c = new Card(1,1);
		Hand h = new Hand(a,b);
		
		h.addCard(c);
		System.out.println(h.getHand().toString());
		
		h.clearHand();
		System.out.println(h.getHand().toString());
	}
}

package game;

public class PlayerTester {

	public static void main(String[] args) {
		Shoe shoe = new Shoe(4);
		Hand handp1 = new Hand(shoe.dealCard(), shoe.dealCard());
		Hand handp2 = new Hand(shoe.dealCard(), shoe.dealCard());
		Hand handp3 = new Hand(shoe.dealCard(), shoe.dealCard());
		Player player1 = new Player(handp1, "Jake", 435.0);

		System.out.println(player1.toString());

		System.out.println("Testing playerBet() - Betting $35");
		player1.playerBet(35.0);
		System.out.println(player1.toString());
		
		System.out.println("Testing insurance() - Player can purchase insurance");
		player1.insurance();
		System.out.println(player1.toString());
		
		System.out.println("Testing getHand()");
		System.out.println(player1.getHand());
		
		System.out.println("Testing getBank()");
		System.out.println(player1.getBank());
		
		System.out.println("Testing getBet()");
		System.out.println(player1.getBet());
		
		System.out.println("Testing getBankString()");
		System.out.println(player1.getBankString());
		
		System.out.println("Testing getHandArray() and toString() of Hand.java");
		System.out.println(player1.getHandArray().toString());
		
		Player player2 = new Player(handp2, "Bob", 10.0);
		
		System.out.println("Testing blackJack() with $10");
		player2.playerBet(10.0);
		player2.blackJack();
		
		
		
		
		System.out.println("Player wins - can lead to BlackJack");
		player2.wonBet();
		System.out.println(player1.toString());
		
		
		System.out.println("player hits");
		player2.hit(shoe.dealCard());
		System.out.println(player1.toString());
		
		
		System.out.println("Testing blackJack()");
		player2.blackJack();
		System.out.println(player1.toString());
		
		System.out.println("Testing playerLost()");
		player2.playerLost();
		System.out.println(player1.toString());
		
		System.out.println("Testing playerBust()");
		player2.playerBust();
		System.out.println(player2.toString());
		

	}

}

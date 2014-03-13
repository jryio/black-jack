package game;

import java.util.Scanner;

public class DealerTester {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		Shoe shoe1 = new Shoe(4);
		Hand p1Hand = new Hand(shoe1.dealCard(), shoe1.dealCard());
		Player p1 = new Player(p1Hand, "Bob", 50.0);
		Dealer dealer = new Dealer(p1, shoe1);

		System.out.print("Place your bet, you have: " + p1.getBankString() + "\n");
		p1.playerBet(input.nextDouble());
		dealer.firstDeal();


	}
}

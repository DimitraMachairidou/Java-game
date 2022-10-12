//Dimitra Machairidou 4108

import java.util.Scanner;

class Blackjack
{
	public static void main(String args[]){
		System.out.println("give me number of players");
		Scanner third=new Scanner(System.in);
		int th=third.nextInt();
		BlackjackTable table=new BlackjackTable(th);
		table.play();
	}
}
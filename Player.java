//Dimitra Machairidou 4108

import java.util.Scanner;

class Player
{
	private CasinoCostumer costumer;
	private Hand xeri;
	private double bet;
	
	public Player(CasinoCostumer costumer){ 
		this.costumer=new CasinoCostumer(costumer.getName(),costumer.getMoney());
	}
	
	public Player(Hand xeri,double bet){
		this.xeri=new Hand();
		this.bet=bet;
	}
	
	public CasinoCostumer getCostumer(){
		return costumer;
	}
	
	public Hand getXeri(){
		return xeri;
	}
	
	public double getBet(){
		return bet;
	}
	
	public void wins(){
		System.out.printf("win");
		costumer.collectBet(bet);
	}

	public void winsBlackJack(){
		System.out.printf("BJwin");
		costumer.collectBet(1.5*bet);
	}
	
	public void loses(){
		System.out.printf("lost");
		costumer.payBet(bet);
	}
	
	public void placeBet(){ 
		System.out.println(costumer.getMoney());
		System.out.println("enter bet");
		Scanner newbet=new Scanner(System.in);
		double nb=newbet.nextDouble();
		do{
			System.out.println("enter bet");
			nb=newbet.nextDouble();
		}while(costumer.getMoney()<nb && nb<1.0);
	}
	
	public void doubleBet(){
		bet=2*bet;
	}
	
	public boolean wantsToDouble(){
		boolean resa=true;
		if (costumer.getMoney()>=(2*bet)){
			System.out.println("do you want to double?? yes or no");
			Scanner answer=new Scanner(System.in);
			String an=answer.next();  
			if (an.equals("yes")){
				resa=true; 
			}else{
				resa=false;
			}
		}
		return resa; 
	}
	
	public boolean wantsToSplit(){
		boolean resal=true;
		if (costumer.getMoney()>=(2*bet)){
			System.out.println("do you want to split?? yes or no");
			Scanner ans=new Scanner(System.in);
			String answ=ans.next();  
			if (answ.equals("yes")){
				resal=true;
			}else{
				resal=false;
			}
		}
		return resal; 
	}
	
	public String toString(){
		return costumer.getName() + "" + xeri;
	}

	public static void main(String args[]){
		CasinoCostumer newcostumer = new CasinoCostumer("Dimitra",50.0);
		Player newplayer = new Player(newcostumer);
		System.out.println(newplayer.getCostumer().printState());
		newplayer.placeBet();
		System.out.println(newplayer.getCostumer().printState());
		newplayer.wantsToSplit();
		System.out.println(newplayer.getCostumer().printState());
		newplayer.wantsToDouble();
		System.out.println(newplayer.getCostumer().printState());
		newplayer.wins();
		System.out.println(newplayer.getCostumer().printState());
		newplayer.winsBlackJack();
		System.out.println(newplayer.getCostumer().printState());
		newplayer.loses();
		System.out.println(newplayer.getCostumer().printState());
	}
}
		
	
				
		
	
	
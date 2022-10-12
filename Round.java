//Dimitra Machairidou 4108

import java.util.ArrayList;
import java.util.Scanner;

class Round 
{
	private Dealer rounddealer;
	private ArrayList<Player> players = new ArrayList<Player>();
	private ArrayList<Player> suspension = new ArrayList<Player>();
	
	public Round(River roundriver){
		Dealer rounddealer=new Dealer(roundriver);
	}
	
	public ArrayList<Player> getPlayers(){
		return players;
	}
	
	public void addPlayer(CasinoCostumer cc){
		Player p=new Player(cc);
		players.add(p);
	}
	
	public void playRound(){
		for (int i=0; i<players.size(); i++){
			players.get(i).placeBet();
			rounddealer.deal(players.get(i));
		}
		rounddealer.draw();
		System.out.println(rounddealer.getHand());
		for (int j=0; j<players.size(); j++){
			rounddealer.deal(players.get(j));
		}
		rounddealer.draw();
		for (int k=0; k<players.size(); k++){
			System.out.println(players.get(k).getXeri());
		}
		if (rounddealer.getHand().isBlackJack()==true){
			for (int a=0; a<players.size(); a++){
				if (players.get(a).getXeri().isBlackJack()!=true){
					players.get(a).getCostumer().payBet(players.get(a).getBet());
					break; 
				}
			}
		}else{
			for (int b=0; b<players.size(); b++){
				if (players.get(b).getXeri().isBlackJack()==true){
					players.get(b).winsBlackJack();
				}else{
					this.playPlayer(players.get(b)); //to call the private method
				}
			}
			rounddealer.play();
			for (int e=0; e<suspension.size(); e++){
				rounddealer.settle(suspension.get(e));
			}
		}
	}
	
	private void playNormalHand(Player play){
		rounddealer.deal(play);
		System.out.println(play.getXeri());
		if (play.getXeri().isBust()==true){
			play.loses();
		}else{
			suspension.add(play);
		}
	}
	
	private void playDoubledHand(Player play){
		play.doubleBet();
	}
	
	private void playSplitHand(Player play){
		play.getXeri().split();
		CasinoCostumer ncc = new CasinoCostumer(play.getCostumer().getName(),play.getCostumer().getMoney());
		Player pl =new Player(ncc);
		Player pla =new Player(ncc);
		double x=play.getBet();
		double y=pl.getBet();
		y=x;
		this.playNormalHand(pl);
		double z=pla.getBet();
		z=x;
		this.playNormalHand(pla);
	}
	
	private void playPlayer(Player play){
		System.out.println("do you want a card?? yes or no");
		Scanner answe=new Scanner(System.in);
		String r=answe.next();  
		while(r.equals("yes")){
			this.playNormalHand(play);
		}
		if (play.wantsToDouble()==true){
			this.playDoubledHand(play);
		}
		if (play.wantsToSplit()==true){
			this.playSplitHand(play);
		}
	}
	
	public static void main(String args[]){
		River rr=new River(6);
		Round ro=new Round(rr);
		CasinoCostumer me=new CasinoCostumer("Dimitra",100.0);
		ro.addPlayer(me);
		ro.playRound();
	}
}
		
		
	
	
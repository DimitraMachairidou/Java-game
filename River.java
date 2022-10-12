//Dimitra Machairidou 4108

import java.util.Random;

class River
{
	private int trapoules;
	private Card[] river;
	private int cardsLeft;
	private int numberOfCards;
	
	public River(int trapoules){ 
		this.trapoules=trapoules;
		river=new Card[trapoules*52];
		String[] xartia={"1","2","3","4","5","6","7","8","9","J","Q","K","A"};
		int h=0;
		numberOfCards=0;
		while(h<trapoules){		
			for (int i=0; i<=12; i++){ 
				river[numberOfCards++]=new Card(xartia[i]);
			}
			for (int j=0; j<=12; j++){ 
				river[numberOfCards++]=new Card(xartia[j]);
			}
			for (int k=0; k<=12; k++){ 
				river[numberOfCards++]=new Card(xartia[k]);
			}
			for (int m=0; m<=12; m++){ 
				river[numberOfCards++]=new Card(xartia[m]);
			}
			h++;
		}
		numberOfCards=cardsLeft;
	}
	
	public int getTrapoules(){
		return trapoules;
	}
	
	public Card nextCard(){
		if (cardsLeft==0){
			return null;
		}else{
			Random random = new Random();
			Card temp=river[random.nextInt(cardsLeft)];
			river[random.nextInt(cardsLeft)]=river[cardsLeft-1];
			river[cardsLeft-1]=temp;
			cardsLeft=cardsLeft-1;
			return temp;
		}
	}
		
	public boolean shouldRestart(){
		if (4*cardsLeft<numberOfCards){
			return true;
		}else{
			return false;
		}
	}
	
	public void restart(){ 
		cardsLeft=numberOfCards;
		river=new Card[numberOfCards];
		String[] xartia={"1","2","3","4","5","6","7","8","9","J","Q","K","A"};
		int h=0;
		int x=numberOfCards/52;
		int y=0;
		while(h<x){		
			for (int i=0; i<=12; i++){ 
				river[y++]=new Card(xartia[i]);
			}
			for (int j=0; j<=12; j++){ 
				river[y++]=new Card(xartia[j]);
			}
			for (int k=0; k<=12; k++){ 
				river[y++]=new Card(xartia[k]);
			}
			for (int m=0; m<=12; m++){ 
				river[y++]=new Card(xartia[m]);
			}
			h++;
		}
	}
	
	public static void main(String[] args){
		River revma = new River(1);
		while(revma.shouldRestart()!=true){
			System.out.println(revma.nextCard());
		}
		revma.restart();
		while(revma.nextCard()!=null){
			System.out.println(revma.nextCard());
		}
	}
}

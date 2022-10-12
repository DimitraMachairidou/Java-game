//Dimitra Machairidou 4108

import java.util.ArrayList;

class Hand
{
	private ArrayList<Card> hand = new ArrayList<Card>();
	
	public void addCard(Card card){
		hand.add(card);
	}
	
	public int score(){
		int total=0;
		boolean x=false;
		for (int i=0; i<hand.size(); i++){ 
			if (hand.get(i).isAce()==true){
				x=true;
			}
			total=total+hand.get(i).getValue();
		}
		if (x==true){
			if (total+10<=21){
				total=total+10;
			}
		}
		return total;
	}
	
	public boolean canSplit(){
		boolean result=true;
		for (int j=0; j<hand.size(); j++){
			for (int k=0; k<hand.size(); k++){
				if (hand.get(j).getFigura().equals(hand.get(k).getFigura())){
					result=true; //diatirite
				}
			}
		}
		if(result==true){
			result=true;
		}else{
			result=false;
		}
		return result;
	}
	
	public Hand[] split(){
		Hand[] pinakas=new Hand[2];
		for (int j=0; j<hand.size(); j++){
			for (int k=0; k<hand.size(); k++){
				if (hand.get(j).getFigura().equals(hand.get(k).getFigura())){
					pinakas[0].addCard(hand.get(j));
					pinakas[1].addCard(hand.get(k));
					hand.remove(j);
					hand.remove(k);
				}
			}
		}
		for (int m=0; m<hand.size(); m=m+2){
			pinakas[0].addCard(hand.get(m));
			pinakas[1].addCard(hand.get(m+1));
		}
		return pinakas;
	}
	
	public boolean isBlackJack(){
		boolean res=true;
		if (hand.size()==2){
			int total=0;
			boolean x=false;
			for (int i=0; i<2; i++){ 
				if (hand.get(i).isAce()==true){
					x=true;					
				}
				total=total+hand.get(i).getValue();
			}
			if (x==true){
				if (total+10<=21){
					total=total+10;
				}
			}
			if (total==21){
				res=true; 
			}else{
				res=false;
			}
		}
		return res;
	}
	
	public boolean isBust(){
		int total=0;
		boolean x=false;
		for (int i=0; i<hand.size(); i++){ 
			if (hand.get(i).isAce()==true){
				x=true;
			}
			total=total+hand.get(i).getValue();
		}
		if(x==true){
			if (total+10<=21){
				total=total+10;
			}
		}
		if (total>21){
			return true;
		}else{
			return false;
		}
	}
	
	public String toString(){ 
		String str="";
		for (int a=0; a<hand.size(); a++){
			str=str+hand.get(a)+"";
		}
		return str;
	}
	
	public static void main(String[] args){ 
		Hand xeri=new Hand();
		Card asos=new Card("A");
		xeri.addCard(asos);
		xeri.addCard(asos);
		System.out.println(xeri);
		System.out.println(xeri.score());
		System.out.println(xeri.canSplit());
		Hand[] tosplit=new Hand[2];
		tosplit=xeri.split();
		System.out.println(tosplit[0]);
		System.out.println(tosplit[1]);
		Card rigas=new Card("K");
		tosplit[0].addCard(rigas);
		System.out.println(tosplit[0]);
		System.out.println(tosplit[0].score());
		System.out.println(tosplit[0].isBlackJack());
		tosplit[0].addCard(asos);
		System.out.println(tosplit[0]);
		System.out.println(tosplit[0].score());
		Card dekari=new Card("10");
		tosplit[0].addCard(dekari);
		System.out.println(tosplit[0]);
		System.out.println(tosplit[0].score());
		System.out.println(tosplit[0].isBust());
	}
}
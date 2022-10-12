//Dimitra Machairidou 4108

class Dealer
{
	private River dealersriver;
	private Hand dealearshand;
	
	public Dealer(River dealersriver){
		this.dealersriver=new River(dealersriver.getTrapoules());
	}
	
	public Hand getHand(){
		return dealearshand;
	}
	
	public River getRiver(){
		return dealersriver;
	}
	
	public void draw(){
		dealearshand.addCard(dealersriver.nextCard());
	}
	
	public void deal(Player player){
		player.getXeri().addCard(dealersriver.nextCard());
	}
	
	public void play(){
		while (dealearshand.score()<17){
			dealersriver.nextCard();
		}
	}
	
	public void settle(Player nextplayer){ 
		if (dealearshand.score()<nextplayer.getXeri().score() && nextplayer.getXeri().score()<=21){
			nextplayer.wins();
		}else{
			nextplayer.loses();
		}
	}
	
	public String toString(){
		return "Dealer" + "" + dealearshand;
	}
	
	public static void main(String args[]){
		River trapoula=new River(1);
		Dealer newdealer=new Dealer(trapoula);
		newdealer.play();
		System.out.println(newdealer);
		CasinoCostumer socostumer=new CasinoCostumer("Dimitra",50.0);
		Player soplayer=new Player(socostumer);
		newdealer.deal(soplayer);
		newdealer.deal(soplayer);
		System.out.println(soplayer);
		newdealer.settle(soplayer);
	}
}
		
	
	
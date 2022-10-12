//Dimitra Machairidou 4108

class Card
{
	private String figoura;
	
	public Card(String figoura){
		this.figoura=figoura;
	}
	
	public String getFigura(){
		return figoura;
	}	
	
	public int getValue(){ 
		if (figoura.equals("A")){
			return 1;
		}else if(figoura.equals("2")){
			return 2;
		}else if(figoura.equals("3")){
			return 3;
		}else if(figoura.equals("4")){
			return 4;
		}else if(figoura.equals("5")){
			return 5;
		}else if(figoura.equals("6")){
			return 6;
		}else if(figoura.equals("7")){
			return 7;
		}else if(figoura.equals("8")){
			return 8;
		}else if(figoura.equals("9")){
			return 9;
		}else{
			return 10;
		}
	}
	
	public boolean isAce(){
		if (figoura.equals("A")){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean equals(Card other){
		if (figoura.equals(other.figoura)){
			return true;
		}else{
			return false;
		}
	}
	
	public String toString(){
		return figoura;
	}
}
		
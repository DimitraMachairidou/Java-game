//Dimitra Machairidou 4108

class CasinoCostumer
{
	private String name;
	private double moneytogive;
	
	public CasinoCostumer(String name,double moneytogive){
		this.name=name;
		this.moneytogive=moneytogive;
	}
	
	public String getName(){
		return name;
	}
	
	public double getMoney(){
		return moneytogive;
	}
	
	public void payBet(double lostmoney){
		moneytogive=moneytogive-lostmoney;
	}
	
	public void collectBet(double winmoney){
		moneytogive=moneytogive+winmoney;
	}
	
	public boolean canCover(double money){
		if (moneytogive<money){
			return false;
		}else{
			return true;
		}
	}
	
	public boolean isBroke(){
		if (moneytogive<1.0){
			return true;
		}else{
			return false;
		}
	}
	
	public String toString(){
		return name;
	}
	
	public String printState(){
		String str = moneytogive + "";
		System.out.printf(name,str);
		return ""; //because of types
	}
}
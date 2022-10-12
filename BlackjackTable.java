//Dimitra Machairidou 4108

import java.util.Scanner;

class BlackjackTable
{
	private River tableriver=new River(6);
	private CasinoCostumer[] array;
	private int arifmos;
	
	public BlackjackTable(int arifmos){
		this.arifmos=arifmos;
		array=new CasinoCostumer[arifmos];
		for (int i=0; i<arifmos; i++){
			array[i]=createCasinoCostumer(); 
		}
	}
	
	private CasinoCostumer createCasinoCostumer(){
		System.out.println("give me name");
		Scanner first=new Scanner(System.in);
		String fi=first.next();	
		System.out.println("give me money to give");
		Scanner second=new Scanner(System.in);
		double se=second.nextDouble();		
		CasinoCostumer maincostumer =new CasinoCostumer(fi,se);
		return maincostumer;
	}
	
	public void play(){
		if (tableriver.shouldRestart()==true){
			tableriver.restart();
		}
		Round rou=new Round(tableriver);
		for (int k=0; k<arifmos; k++){
			if (array[k].isBroke()==false){ 
				rou.addPlayer(array[k]);
			}
		}
		for (int m=0; m<rou.getPlayers().size(); m++){
			while(rou.getPlayers().get(m).getCostumer().getMoney() != 0.0){ 
				rou.playRound();
			}
		}
	}
}
	
	
		
		
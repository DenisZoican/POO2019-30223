package zoowsome.models.animals;

import java.util.Date;

public class Spider extends Insect{
	public Spider(Boolean canFly,Boolean isDangerous,Integer nrOfLegs,String name,double maintenanceCost,double dangerPerc){
		super(canFly,isDangerous,nrOfLegs,name,maintenanceCost,dangerPerc);
	}
	
	public Spider(){
		super(false,true,8,"Bee",1.0,0.4);
	}
	
	public double getPredisposition() {
		Date dt = new Date(); 
		int hours = dt.getHours();
		if(hours>=19 || hours<=6)
		{
			return 0.25;
		}
		return 0;
	}
}

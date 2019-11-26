package zoowsome.models.animals;

import static zoowsome.repositories.AnimalRepository.createNode;

import java.util.Date;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import zoowsome.services.factories.animals.Constants;
import static zoowsome.repositories.AnimalRepository.createNode;

public class Spider extends Insect{
	public Spider(Boolean canFly,Boolean isDangerous,Integer nrOfLegs,String name,double maintenanceCost,double dangerPerc){
		super(canFly,isDangerous,nrOfLegs,name,maintenanceCost,dangerPerc);
	}
	
	public Spider(){
		super(false,true,8,"Spider",1.0,0.4);
	}
	
	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Insects.SPIDER);
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

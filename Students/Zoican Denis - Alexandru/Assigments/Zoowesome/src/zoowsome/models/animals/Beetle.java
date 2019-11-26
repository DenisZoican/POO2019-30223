package zoowsome.models.animals;

import static zoowsome.repositories.AnimalRepository.createNode;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import zoowsome.services.factories.animals.Constants;
import static zoowsome.repositories.AnimalRepository.createNode;

public class Beetle extends Insect{
	public Beetle(Boolean canFly,Boolean isDangerous,Integer nrOfLegs,String name,double maintenanceCost,double dangerPerc){
		super(canFly,isDangerous,nrOfLegs,name,maintenanceCost,dangerPerc);
	}
	
	public Beetle(){
		super(false,false,12,"Beetles",3,0.3);
	}
	
	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Insects.BEETLE);
	}
}

package zoowsome.models.animals;

import static zoowsome.repositories.AnimalRepository.createNode;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import zoowsome.services.factories.animals.Constants;

public class Peacock extends Bird{
	public Peacock(Boolean migrates,Integer avgFlightAltitude,String name,Integer nrOfLegs,double maintenanceCost,double dangerPerc){
		super(migrates,avgFlightAltitude,name,nrOfLegs,maintenanceCost,dangerPerc);
	}
	
	public Peacock(){
		super(false,0,"Peacock",2,5.5,0.3);
	}
	
	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Birds.PEACOCK);
	}
}

package zoowsome.models.animals;

import static zoowsome.repositories.AnimalRepository.createNode;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import zoowsome.services.factories.animals.Constants;

public class Parrot extends Bird{
	
	
	public Parrot(Boolean migrates,Integer avgFlightAltitude,String name,Integer nrOfLegs,double maintenanceCost,double dangerPerc){
		super(migrates,avgFlightAltitude,name,nrOfLegs,maintenanceCost,dangerPerc);
	}
	
	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Birds.PARROT);
	}
	
	public Parrot(){
		super(false,5,"Parrot",2,5.4,0.5);
	}
}

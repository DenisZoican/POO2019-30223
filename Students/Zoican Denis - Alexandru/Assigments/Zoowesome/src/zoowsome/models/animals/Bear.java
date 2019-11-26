package zoowsome.models.animals;

import static zoowsome.repositories.AnimalRepository.createNode;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Element;

import zoowsome.services.factories.animals.Constants;

public class Bear extends Mammal{
	
	public Bear(float normalBodyTemp,float percBodyHair,String name,Integer nrOfLegs,double maintenanceCost,double dangerPerc){
		super(normalBodyTemp,percBodyHair,name,nrOfLegs,maintenanceCost,dangerPerc);
	}
	
	public Bear(){
		super(42,80,"Bear",new Integer(4),2.3,0.8);
	}

	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Mammals.BEAR);
	}
	
	@Override
	public void decodeFromXml(Element element) {
		// TODO Auto-generated method stub
		
	}
	

}

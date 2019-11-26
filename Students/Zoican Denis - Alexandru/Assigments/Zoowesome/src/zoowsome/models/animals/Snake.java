package zoowsome.models.animals;

import static zoowsome.repositories.AnimalRepository.createNode;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Element;

import zoowsome.services.factories.animals.Constants;

public class Snake extends Reptile{
	public Snake(boolean layEggs,String name,Integer nrOfLegs,double maintenanceCost,double dangerPerc){
		super(layEggs,name,nrOfLegs,maintenanceCost,dangerPerc);
	}
	
	
	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Reptiles.SNAKE);
	}
	
	public Snake()
	{
		super(true,"Gabi",0,1.5,0.87);
	}


	@Override
	public void decodeFromXml(Element element) {
		// TODO Auto-generated method stub
		
	}
}

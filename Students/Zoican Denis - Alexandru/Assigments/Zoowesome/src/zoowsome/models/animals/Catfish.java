package zoowsome.models.animals;

import static zoowsome.repositories.AnimalRepository.createNode;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Element;

import zoowsome.services.factories.animals.Constants;

public class Catfish extends Aquatic{
	public Catfish(Integer avgSwimDepth,type waterType,String name,Integer nrOfLegs,double maintenanceCost,double dangerPerc){
		super(avgSwimDepth,waterType,name,nrOfLegs,maintenanceCost,dangerPerc);
	}
	
	public Catfish(){
		super(150,type.saltwater,"Catfish",0,1.3,0.05);
	}
	
	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Aquatics.CATFISH);
	}

	@Override
	public void decodeFromXml(Element element) {
		// TODO Auto-generated method stub
		
	}
}

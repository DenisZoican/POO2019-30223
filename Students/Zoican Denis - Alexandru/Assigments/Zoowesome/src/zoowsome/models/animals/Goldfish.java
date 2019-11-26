package zoowsome.models.animals;

import static zoowsome.repositories.AnimalRepository.createNode;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Element;

import zoowsome.models.animals.Aquatic.type;
import zoowsome.services.factories.animals.Constants;

public class Goldfish extends Aquatic{
	public Goldfish(Integer avgSwimDepth,type waterType,String name,Integer nrOfLegs,double maintenanceCost,double dangerPerc){
		super(avgSwimDepth,waterType,name,nrOfLegs,maintenanceCost,dangerPerc);
	}
	
	public Goldfish(){
		super(50,type.freshwater,"Goldfish",0,1.0,0.006);
	}
	
	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Aquatics.GOLDFISH);
	}

	@Override
	public void decodeFromXml(Element element) {
		// TODO Auto-generated method stub
		
	}
}

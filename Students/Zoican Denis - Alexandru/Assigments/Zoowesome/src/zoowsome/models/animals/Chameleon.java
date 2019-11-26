package zoowsome.models.animals;

import static zoowsome.repositories.AnimalRepository.createNode;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Element;

import zoowsome.services.factories.animals.Constants;

public class Chameleon extends Reptile {
	public Chameleon(boolean layEggs, String name, Integer nrOfLegs, double maintenanceCost, double dangerPerc) {
		super(layEggs, name, nrOfLegs, maintenanceCost, dangerPerc);
	}

	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Reptiles.CHAMELEON);
	}

	public Chameleon() {
		super(true, "Chameleon", 4, 3.4, 0.6);
	}

	@Override
	public void decodeFromXml(Element element) {
		// TODO Auto-generated method stub
		
	}
}

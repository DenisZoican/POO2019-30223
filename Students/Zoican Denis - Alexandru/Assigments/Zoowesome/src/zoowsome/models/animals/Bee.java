package zoowsome.models.animals;

import static zoowsome.repositories.AnimalRepository.createNode;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import zoowsome.services.factories.animals.Constants;

public class Bee extends Insect {

	public Bee(Boolean canFly, Boolean isDangerous, Integer nrOfLegs, String name, double maintenanceCost,double dangerPerc) {
		super(canFly, isDangerous, nrOfLegs, name, maintenanceCost, dangerPerc);
	}

	public Bee() {
		super(true, true, 8, "Bee", 2.2, 0.67);
	}

	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Insects.BEE);
	}

}

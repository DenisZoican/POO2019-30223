package zoowsome.models.animals;

import static zoowsome.repositories.AnimalRepository.createNode;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import zoowsome.services.factories.animals.Constants;

public class Flamingo extends Bird {
	public Flamingo(Boolean migrates, Integer avgFlightAltitude, String name, Integer nrOfLegs, double maintenanceCost,
			double dangerPerc) {
		super(migrates, avgFlightAltitude, name, nrOfLegs, maintenanceCost, dangerPerc);
	}

	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Birds.FLAMINGO);
	}

	public Flamingo() {
		super(false, 0, "Flamingo", 1, 6.2, 0.8);
	}
}

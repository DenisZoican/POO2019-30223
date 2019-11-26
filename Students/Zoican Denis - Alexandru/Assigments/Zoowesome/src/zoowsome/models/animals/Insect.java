package zoowsome.models.animals;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Element;

import static zoowsome.repositories.AnimalRepository.createNode;

public class Insect extends Animal {
	private Boolean canFly;
	private Boolean isDangerous;

	Insect(Boolean canFly, Boolean isDangerous, Integer nrOfLegs, String name, double maintenanceCost,
			double dangerPerc) {
		super(nrOfLegs, name, maintenanceCost, dangerPerc);
		this.canFly = canFly;
		this.isDangerous = isDangerous;
	}

	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode(eventWriter, "canFly", String.valueOf(getCanFly()));
		createNode(eventWriter, "isDangerous", String.valueOf(getIsDangerous()));
	}

	public Boolean getCanFly() {
		return this.canFly;
	}

	public Boolean getIsDangerous() {
		return this.isDangerous;
	}

	public void setCanFly(Boolean a) {
		this.canFly = a;
	}

	public void setIsDangerous(Boolean a) {
		this.isDangerous = a;
	}

	public void decodeFromXml(Element element) {
		setCanFly(Boolean.valueOf(element.getElementsByTagName("canFly").item(0).getTextContent()));
		setIsDangerous(Boolean.valueOf(element.getElementsByTagName("isDangerous").item(0).getTextContent()));
	}

	
}

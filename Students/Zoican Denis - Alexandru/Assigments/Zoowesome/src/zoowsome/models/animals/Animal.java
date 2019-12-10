package zoowsome.models.animals;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Element;

import static zoowsome.repositories.AnimalRepository.createNode;
import zoowsome.models.interfaces.XML_Parsable;

public abstract class Animal implements Killer, XML_Parsable {
	private double maintenanceCost;
	private double dangerPerc;
	private Integer nrOfLegs;
	private String name;
	private boolean takenCareOf;

	Animal(Integer nrOfLegs, String name, double maintenanceCost, double dangerPerc) {
		this.dangerPerc = dangerPerc;
		this.maintenanceCost = maintenanceCost;
		this.name = name;
		this.nrOfLegs = nrOfLegs;
	}

	public double getDangerPerc() {
		return dangerPerc;
	}
	public void decodeFromXml( Element element) {
		setNrOfLegs (Integer.valueOf(element.getElementsByTagName("nrOfLegs").item(0).getTextContent()));
		setName(element.getElementsByTagName("name").item(0).getTextContent()) ;
		setMaintenanceCost(Double.valueOf(element.getElementsByTagName( "maintenanceCost").item(0).getTextContent())) ;
		setDangerPerc(Double.valueOf(element.getElementsByTagName("dangerPerc").item(0).getTextContent()));
		setTakenCareOf(Boolean.valueOf(element.getElementsByTagName("takenCareOf").item(0).getTextContent()) );
		}



	private void setDangerPerc(Double d) {
		this.dangerPerc = d;
		
	}

	private void setMaintenanceCost(Double d) {
		this.maintenanceCost = d;
	}

	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		createNode(eventWriter, "nrOfLegs", String.valueOf(this.nrOfLegs));
		createNode(eventWriter, "name", String.valueOf(this.name));
		createNode(eventWriter, "maintenanceCost", String.valueOf(this.maintenanceCost));
		createNode(eventWriter, "dangerPerc", String.valueOf(this.dangerPerc));
		createNode(eventWriter, "takenCareOf", String.valueOf(this.takenCareOf));
	}

	public double getPredisposition() {
		return 0;
	}

	public boolean kill() {
		double nr_r = Math.random();
		if (nr_r < dangerPerc + getPredisposition()) {
			return true;
		}
		return false;
	}

	public Integer getNrOfLegs() {
		return nrOfLegs;
	}

	public String getName() {
		return name;
	}

	public void setNrOfLegs(Integer nrOfLegs) {
		this.nrOfLegs = nrOfLegs;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMaintenanceCost() {
		return maintenanceCost;
	}

	public boolean isTakenCareOf() {
		return takenCareOf;
	}

	public void setTakenCareOf(boolean takenCareOf) {
		this.takenCareOf = takenCareOf;
	}

}

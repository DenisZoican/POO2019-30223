package zoowsome.models.animals;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Element;
import static zoowsome.repositories.AnimalRepository.createNode;

public class Bird extends Animal{
	private Boolean migrates;
	private Integer avgFlightAltitude;
	
	Bird(Boolean migrates,Integer avgFlightAltitude,String name,Integer nrOfLegs,double maintenanceCost,double dangerPerc){
		super(nrOfLegs,name,maintenanceCost,dangerPerc);
		this.migrates = migrates;
		this.avgFlightAltitude = avgFlightAltitude;
	}
	
	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode(eventWriter, "migrates", String.valueOf(getMigrates()));
		createNode(eventWriter, "avgFlightAltitude", String.valueOf(getAvgFlightAltitude()));
		}

	public Boolean getMigrates() {
		return this.migrates;
	}
	
	public Integer getAvgFlightAltitude() {
		return this.avgFlightAltitude;
	}
	
	public void setMigrates (Boolean a) {
		this.migrates = a;
	}
	
	public void setAvgFlightAltitude(Integer a) {
		this.avgFlightAltitude = a;
	}



	public void decodeFromXml(Element element) {
		setMigrates(Boolean.valueOf(element.getElementsByTagName("migrates").item(0).getTextContent()));
		setAvgFlightAltitude(Integer.valueOf(element.getElementsByTagName("avgFlightAltitude").item(0).getTextContent()));
	}
	
	
}

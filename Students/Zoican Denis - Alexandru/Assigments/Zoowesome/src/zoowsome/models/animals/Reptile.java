package zoowsome.models.animals;

import static zoowsome.repositories.AnimalRepository.createNode;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Element;

public abstract class Reptile extends Animal{
	private Boolean layEggs;
	
	Reptile(boolean layEggs,String name,Integer nrOfLegs,double maintenanceCost,double dangerPerc){
		super(nrOfLegs,name,maintenanceCost,dangerPerc);
		this.layEggs = layEggs;
	}
	
	public Boolean getLayEggs() {
		return this.layEggs;
	}
	
	public void decodeFromXml(Element element) {
		setLayEggs(Boolean.valueOf(element.getElementsByTagName("layEggs").item(0).getTextContent()));
	}
	
	public void setLayEggs(Boolean a) {
		this.layEggs = a;
	}
	
	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode(eventWriter, "layEggs", String.valueOf(getLayEggs()));
	 }
	
}

package zoowsome.models.animals;

import static zoowsome.repositories.AnimalRepository.createNode;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Element;

public abstract class Aquatic extends Animal{
	public enum type {
		    saltwater,
		    freshwater
		  }
	private Integer avgSwimDepth;
	private type waterType;
	
	Aquatic(Integer avgSwimDepth,type waterType,String name,Integer nrOfLegs,double maintenanceCost,double dangerPerc){
		super(nrOfLegs,name,maintenanceCost,dangerPerc);
		this.avgSwimDepth = avgSwimDepth;
		this.waterType = waterType;
	}
	
	public void decodeFromXml(Element element) {
		setAvgSwimDepth(Integer.valueOf(element.getElementsByTagName("avgSwimDepth").item(0).getTextContent()));
		setWaterType(type.valueOf(element.getElementsByTagName("isDangerous").item(0).getTextContent()));
	}
	
	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode(eventWriter, "avgSwimDepth", String.valueOf(getAvgSwimDepth()));
		createNode(eventWriter, "waterType", String.valueOf(getWaterType()));
	 }
	
	public Integer getAvgSwimDepth() {
		return this.avgSwimDepth;
	}
	
	public type getWaterType() {
		return this.waterType;
	}
	
	public void setAvgSwimDepth(Integer a) {
		this.avgSwimDepth = a;
	}
	
	public void setWaterType(type a) {
		this.waterType = a;
	}
}

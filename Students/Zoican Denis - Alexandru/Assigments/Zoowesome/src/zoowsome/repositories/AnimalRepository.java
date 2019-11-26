package zoowsome.repositories;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartDocument;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import zoowsome.models.animals.Animal;
import zoowsome.models.animals.Bear;
import zoowsome.models.animals.Bee;
import zoowsome.models.animals.Beetle;
import zoowsome.models.animals.Catfish;
import zoowsome.models.animals.Chameleon;
import zoowsome.models.animals.Clownfish;
import zoowsome.models.animals.Cow;
import zoowsome.models.animals.Flamingo;
import zoowsome.models.animals.Goldfish;
import zoowsome.models.animals.Llama;
import zoowsome.models.animals.Parrot;
import zoowsome.models.animals.Peacock;
import zoowsome.models.animals.Snake;
import zoowsome.models.animals.Spider;
import zoowsome.models.animals.Turtle;
import zoowsome.models.interfaces.XML_Parsable;
import zoowsome.services.factories.animals.Constants;

public class AnimalRepository {
	private static final String XML_FILENAME = "Animals.xml";

	public AnimalRepository() {
	}

	public void save(ArrayList<Animal> animals) throws FileNotFoundException, XMLStreamException {
		XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
		// Create XMLEventWriter
		XMLEventWriter eventWriter = outputFactory.createXMLEventWriter(new FileOutputStream(XML_FILENAME));
		// Create a EventFactory
		XMLEventFactory eventFactory = XMLEventFactory.newInstance();
		XMLEvent end = eventFactory.createDTD("\n ");
		// Create and write Start Tag
		StartDocument startDocument = eventFactory.createStartDocument();
		eventWriter.add(startDocument);
		// Create content open tag
		StartElement configStartElement = eventFactory.createStartElement("", "", "content");
		eventWriter.add(configStartElement);
		eventWriter.add(end);
		for (Animal animal : animals) {			
			StartElement sElement = eventFactory.createStartElement("", "", Constants.XML_TAGS.ANIMAL);
			eventWriter.add(sElement);
			eventWriter.add(end);
			animal.encodeToXml(eventWriter);
			EndElement eElement = eventFactory.createEndElement("", "", Constants.XML_TAGS.ANIMAL);
			eventWriter.add(eElement);
			eventWriter.add(end);
		}
		eventWriter.add(eventFactory.createEndElement("", "", " content"));
		eventWriter.add(eventFactory.createEndDocument());
		eventWriter.close();
	}

	public static void createNode(XMLEventWriter eventWriter, String name, String value) throws XMLStreamException {
		XMLEventFactory eventFactory = XMLEventFactory.newInstance();
		XMLEvent end = eventFactory.createDTD("\n");
		XMLEvent tab = eventFactory.createDTD("\t");
		// Create Start node
		StartElement sElement = eventFactory.createStartElement("", "", name);
		eventWriter.add(tab);
		eventWriter.add(sElement);
		// Create Content
		Characters characters = eventFactory.createCharacters(value);
		eventWriter.add(characters);
		// Create End node
		EndElement eElement = eventFactory.createEndElement("", "", name);
		eventWriter.add(eElement);
		eventWriter.add(end);
	}

	public ArrayList<Animal> load() throws ParserConfigurationException, SAXException, IOException {
		ArrayList<Animal> animals = new ArrayList<Animal>();
		File fXmlFile = new File(XML_FILENAME);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
		doc.getDocumentElement().normalize();
		NodeList nodeList = doc.getElementsByTagName(Constants.XML_TAGS.ANIMAL);
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				String discriminant = element.getElementsByTagName(Constants.XML_TAGS.DISCRIMINANT).item(0)
						.getTextContent();
				switch (discriminant) {
				case Constants.Animals.Insects.SPIDER:
					Animal spider = new Spider();
					spider.decodeFromXml(element);
					animals.add(spider);
					break;
				case Constants.Animals.Insects.BEE:
					Animal bee = new Bee();
					bee.decodeFromXml(element);
					animals.add(bee);
					break;
				case Constants.Animals.Insects.BEETLE:
					Animal beetle = new Beetle();
					beetle.decodeFromXml(element);
					animals.add(beetle);
					break;
				case Constants.Animals.Aquatics.CATFISH:
					Animal catfish = new Catfish();
					catfish.decodeFromXml(element);
					animals.add(catfish);
					break;
				case Constants.Animals.Aquatics.CLOWNFISH:
					Animal clownfish = new Clownfish();
					clownfish.decodeFromXml(element);
					animals.add(clownfish);
					break;
				case Constants.Animals.Aquatics.GOLDFISH:
					Animal goldfish = new Goldfish();
					goldfish.decodeFromXml(element);
					animals.add(goldfish);
					break;
				case Constants.Animals.Birds.FLAMINGO:
					Animal flamingo = new Flamingo();
					flamingo.decodeFromXml(element);
					animals.add(flamingo);
					break;
				case Constants.Animals.Birds.PEACOCK:
					Animal peacock = new Peacock();
					peacock.decodeFromXml(element);
					animals.add(peacock);
					break;
				case Constants.Animals.Birds.PARROT:
					Animal parrot = new Parrot();
					parrot.decodeFromXml(element);
					animals.add(parrot);
					break;
				case Constants.Animals.Reptiles.CHAMELEON:
					Animal chameleon = new Chameleon();
					chameleon.decodeFromXml(element);
					animals.add(chameleon);
					break;
				case Constants.Animals.Reptiles.TURTLE:
					Animal turtle = new Turtle();
					turtle.decodeFromXml(element);
					animals.add(turtle);
					break;
				case Constants.Animals.Reptiles.SNAKE:
					Animal snake = new Snake();
					snake.decodeFromXml(element);
					animals.add(snake);
					break;
				case Constants.Animals.Mammals.COW:
					Animal cow = new Cow();
					cow.decodeFromXml(element);
					animals.add(cow);
					break;
				case Constants.Animals.Mammals.LLAMA:
					Animal llama = new Llama();
					llama.decodeFromXml(element);
					animals.add(llama);
					break;
				case Constants.Animals.Mammals.BEAR:
					Animal bear = new Bear();
					bear.decodeFromXml(element);
					animals.add(bear);
					break;
				default:
					break;
				}
			}
		}
		return animals;
	}

}

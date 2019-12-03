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

public class AnimalRepository extends EntityRepository<Animal> {
	private static final String XML_FILENAME = "Animals.xml";

	public AnimalRepository() {
		super(XML_FILENAME, Constants.XML_TAGS.ANIMAL);
	}

	@Override
	protected Animal getEntityFromXmlElement(Element element) {
		String discriminant = element.getElementsByTagName(Constants.XML_TAGS.DISCRIMINANT).item(0).getTextContent();
		switch (discriminant) {
		case Constants.Animals.Insects.SPIDER:
			Animal spider = new Spider();
			spider.decodeFromXml(element);
			return spider;
		case Constants.Animals.Insects.BEE:
			Animal bee = new Bee();
			bee.decodeFromXml(element);
			return bee;
		case Constants.Animals.Insects.BEETLE:
			Animal beetle = new Beetle();
			beetle.decodeFromXml(element);
			return beetle;
		case Constants.Animals.Aquatics.CATFISH:
			Animal catfish = new Catfish();
			catfish.decodeFromXml(element);
			return catfish;
		case Constants.Animals.Aquatics.CLOWNFISH:
			Animal clownfish = new Clownfish();
			clownfish.decodeFromXml(element);
			return clownfish;
		case Constants.Animals.Aquatics.GOLDFISH:
			Animal goldfish = new Goldfish();
			goldfish.decodeFromXml(element);
			return goldfish;
		case Constants.Animals.Birds.FLAMINGO:
			Animal flamingo = new Flamingo();
			flamingo.decodeFromXml(element);
			return flamingo;
		case Constants.Animals.Birds.PEACOCK:
			Animal peacock = new Peacock();
			peacock.decodeFromXml(element);
			return peacock;
		case Constants.Animals.Birds.PARROT:
			Animal parrot = new Parrot();
			parrot.decodeFromXml(element);
			return parrot;
		case Constants.Animals.Reptiles.CHAMELEON:
			Animal chameleon = new Chameleon();
			chameleon.decodeFromXml(element);
			return chameleon;
		case Constants.Animals.Reptiles.TURTLE:
			Animal turtle = new Turtle();
			turtle.decodeFromXml(element);
			return turtle;
		case Constants.Animals.Reptiles.SNAKE:
			Animal snake = new Snake();
			snake.decodeFromXml(element);
			return snake;
		case Constants.Animals.Mammals.COW:
			Animal cow = new Cow();
			cow.decodeFromXml(element);
			return cow;
		case Constants.Animals.Mammals.LLAMA:
			Animal llama = new Llama();
			llama.decodeFromXml(element);
			return llama;
		case Constants.Animals.Mammals.BEAR:
			Animal bear = new Bear();
			bear.decodeFromXml(element);
			return bear;
		default:
			return null;
		}
	}
}

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

import zoowsome.models.employees.Caretaker;
import zoowsome.models.employees.Employee;
import zoowsome.services.factories.animals.Constants;

public class EmployeesRepository extends EntityRepository<Employee> {
	private static final String XML_FILENAME = "Employees.xml";

	public EmployeesRepository() {
		super(XML_FILENAME, Constants.XML_TAGS.EMPLOYEE);
	}

	@Override
	protected Employee getEntityFromXmlElement(Element element) {
		String discriminant = element.getElementsByTagName(Constants.XML_TAGS.DISCRIMINANT).item(0).getTextContent();
		switch (discriminant) {
		case Constants.Employees.Caretaker:
			Employee caretaker = new Caretaker();
			caretaker.decodeFromXml(element);
			return caretaker;
		default:
			return null;
		}
	}
}

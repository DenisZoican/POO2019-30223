package zoowsome.models.employees;

import static zoowsome.repositories.AnimalRepository.createNode;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Element;

import zoowsome.models.interfaces.XML_Parsable;

public abstract class Employee implements XML_Parsable {
	private String name;
	private String id;
	private BigDecimal salary;
	private Boolean isDead;
	Map<String, Boolean> map = new HashMap<String, Boolean>();

	public Employee(String name, Long id, BigDecimal salary) {

		String gen = getNumericString(13);
		while (map.containsKey(gen) == true)
			gen = getNumericString(13);

		map.put(gen, true);
		this.id = gen;
		this.name = name + "_" + id;
		this.salary = salary;
		this.isDead = false;
	}

	public void decodeFromXml(Element element) {
		setId(String.valueOf(element.getElementsByTagName("id").item(0).getTextContent()));
		setName(element.getElementsByTagName("name").item(0).getTextContent());
		setSalary(BigDecimal.valueOf(Long.valueOf(element.getElementsByTagName("salary").item(0).getTextContent())));
		setIsDead(Boolean.valueOf(element.getElementsByTagName("isDead").item(0).getTextContent()));
	}


	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		createNode(eventWriter, "id", String.valueOf(this.id));
		createNode(eventWriter, "name", String.valueOf(this.name));
		createNode(eventWriter, "salary", String.valueOf(this.salary));
		createNode(eventWriter, "isDead", String.valueOf(this.isDead));
	}
	
	private String getNumericString(int n) {

		String AlphaNumericString = "0123456789";

		StringBuilder sb = new StringBuilder(n);

		for (int i = 0; i < n; i++) {
			int index = (int) (AlphaNumericString.length() * Math.random());
			sb.append(AlphaNumericString.charAt(index));
		}

		return sb.toString();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public Boolean getIsDead() {
		return isDead;
	}

	public void setIsDead(Boolean isDead) {
		this.isDead = isDead;
	}

}

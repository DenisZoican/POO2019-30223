package zoowsome.models.employees;

import static zoowsome.repositories.AnimalRepository.createNode;

import java.math.BigDecimal;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Element;

import zoowsome.models.animals.Animal;
import zoowsome.models.animals.Aquatic.type;
import zoowsome.services.factories.animals.Constants;

public class Caretaker extends Employee implements Caretaker_1 {

	private Double workingHours;
	private static Long idDefault;
	public Caretaker(String name, Long id, BigDecimal salary, Double workingHours) {
		super(name, id, salary);
		this.workingHours = workingHours;
	}

	public Caretaker() {
		super("Default"+idDefault,idDefault,new BigDecimal("23"));
		idDefault++;
		this.workingHours = 0.0;
	}
	
	public void decodeFromXml(Element element) {
		setWorkingHours(Double.valueOf(element.getElementsByTagName("workingHours").item(0).getTextContent()));
	}
	
	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode(eventWriter, "workingHours", String.valueOf(getWorkingHours()));
	 }

	public Double getWorkingHours() {
		return workingHours;
	}

	public void setWorkingHours(Double workingHours) {
		this.workingHours = workingHours;
	}

	@Override
	public String takeCareOf(Animal a) {
		if (a.kill()) {
			this.setIsDead(true);
			return Constants.Employees.CaretakerStatus.TCO_KILLED;
		} else if (this.workingHours < a.getMaintenanceCost()) {
			return Constants.Employees.CaretakerStatus.TCO_NO_TIME;
		}

		a.setTakenCareOf(true);
		this.workingHours -= a.getMaintenanceCost();

		return Constants.Employees.CaretakerStatus.TCO_SUCCES;
	}
}

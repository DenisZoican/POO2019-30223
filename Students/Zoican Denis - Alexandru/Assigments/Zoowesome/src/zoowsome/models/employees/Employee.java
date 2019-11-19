package zoowsome.models.employees;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public abstract class Employee {
	private String name;
	private String id;
	private BigDecimal salary;
	private Boolean isDead;
	Map<String, Boolean> map = new HashMap<String, Boolean>();

	public Employee(String name, Long id, BigDecimal salary) {

		String gen = getNumericString(13);
		while(map.containsKey(gen) == true)
			gen = getNumericString(13);
		
		map.put(gen, true);
		this.id = gen;
		this.name = name + "_" + id;
		this.salary = salary;
		this.isDead = false;
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

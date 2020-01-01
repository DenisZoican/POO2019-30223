import java.util.List;

public class Student {
	private String name;
	private Double averageGrade;
	private List<String> courses;
	
	public Student(String name,Double averageGrade,List<String> courses) {
		this.name = name;
		this.averageGrade = averageGrade;
		this.courses = courses;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getAverageGrade() {
		return averageGrade;
	}
	public void setAverageGrade(Double averageGrade) {
		this.averageGrade = averageGrade;
	}
	public List<String> getCourses() {
		return courses;
	}
	public void setCourses(List<String> courses) {
		this.courses = courses;
	}
}

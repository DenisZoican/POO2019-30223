
public class Car {
	private String brand;
	private Integer year;
	private String color;
	private Double price;

	public Car(String brand,Integer year,String color,Double price) {
		this.brand = brand;
		this.year = year;
		this.color = color;
		this.price = price;
	}
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}

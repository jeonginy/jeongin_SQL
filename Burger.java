public class Burger {
	// 버거 정보 넣고, 빼기 위한 클래스 : 필드, 생성자, getter/setter method
	private int id;
	private String brand;
	private String name;
	private int price;

	public Burger() {
	}

	public Burger(int id, String brand, String name, int price) {
		super();
		this.id = id;
		this.brand = brand;
		this.name = name;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Burger [id=" + id + ", brand=" + brand + ", name=" + name + ", price=" + price + "]";
	}

}

package NoiThat.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Product")
@NamedQuery(name = "Product.findAll", query = "SELECT c FROM Product c")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productID;
	
	@ManyToOne
	@JoinColumn(name = "cateID")
	private Category category;
	
	private String productName;
    private String description;
    private double price;
    private String imgLink1;
    private String imgLink2;
    private String imgLink3;
    private String imgLink4;
    private String imgLink5;
    private String provider;
    private String locate;
    private int stoke;
    private boolean state;
    private String information;
    
	public Product(int productID, Category category, String productName, String description, double price,
			String imgLink1, String imgLink2, String imgLink3, String imgLink4, String imgLink5, String provider,
			String locate, int stoke, boolean state, String information) {
		super();
		this.productID = productID;
		this.category = category;
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.imgLink1 = imgLink1;
		this.imgLink2 = imgLink2;
		this.imgLink3 = imgLink3;
		this.imgLink4 = imgLink4;
		this.imgLink5 = imgLink5;
		this.provider = provider;
		this.locate = locate;
		this.stoke = stoke;
		this.state = state;
		this.information = information;
	}

	public Product() {
		super();
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImgLink1() {
		return imgLink1;
	}

	public void setImgLink1(String imgLink1) {
		this.imgLink1 = imgLink1;
	}

	public String getImgLink2() {
		return imgLink2;
	}

	public void setImgLink2(String imgLink2) {
		this.imgLink2 = imgLink2;
	}

	public String getImgLink3() {
		return imgLink3;
	}

	public void setImgLink3(String imgLink3) {
		this.imgLink3 = imgLink3;
	}

	public String getImgLink4() {
		return imgLink4;
	}

	public void setImgLink4(String imgLink4) {
		this.imgLink4 = imgLink4;
	}

	public String getImgLink5() {
		return imgLink5;
	}

	public void setImgLink5(String imgLink5) {
		this.imgLink5 = imgLink5;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getLocate() {
		return locate;
	}

	public void setLocate(String locate) {
		this.locate = locate;
	}

	public int getStoke() {
		return stoke;
	}

	public void setStoke(int stoke) {
		this.stoke = stoke;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}
    
    
    
}

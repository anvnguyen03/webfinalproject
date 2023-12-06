package NoiThat.Entity;

import java.io.File;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

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
	private int stoke;
	private int state;
	private String information;

	public Product(int productID, Category category, String productName, String description, double price,
			String imgLink1, String imgLink2, String imgLink3, String imgLink4, String imgLink5, int stoke, int state,
			String information) {
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

	public int getStoke() {
		return stoke;
	}

	public void setStoke(int stoke) {
		this.stoke = stoke;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public String ProcessImage(String image, HttpServletRequest req) {
		String imageName = null;

		try {
			Part part = req.getPart(image);

			// Kiểm tra nếu part chứa dữ liệu ảnh
			String storagePath = "D:\\Study\\KH1-3\\Web\\CodeWeb\\WebFinalProject\\src\\main\\webapp\\uploads";
			File storageDirectory = new File(storagePath);

			// Tạo thư mục nếu nó không tồn tại
			if (!storageDirectory.exists()) {
				storageDirectory.mkdirs();
			}

			// Tạo tên file mới dựa trên thời gian hiện tại
			String filename = System.currentTimeMillis() + "_" + part.getSubmittedFileName();
			String filePath = storagePath + File.separator + filename;

			// Ghi dữ liệu ảnh vào đường dẫn đã tạo
			part.write(filePath);
			// Chỉ lấy tên file, không kèm theo đường dẫn
			imageName = filename;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return imageName;
	}

//	public static void main(String[] args) {
//		String storagePath = "\\WebFinalProject\\uploads";
//
//		File storageDirectory = new File(storagePath);
//
//		if (storageDirectory.exists()) {
//			System.out.println("Đường dẫn tồn tại: " + storageDirectory.getAbsolutePath());
//		} else {
//			System.out.println("Đường dẫn không tồn tại hoặc là thư mục rỗng: " + storageDirectory.getAbsolutePath());
//		}
//	}

}

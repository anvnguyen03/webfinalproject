package NoiThat.Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Category")
@NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c")
public class Category {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cateID;

	@Column(columnDefinition = "nvarchar(50)")
	private String cateName;

	private int state;
	
	@ManyToOne
	@JoinColumn(name = "cateParentsID")
	private CategoryParents cateParent;

	@OneToMany(mappedBy = "category", fetch = FetchType.EAGER) 
	private List<Product> product;

	public Category() {
		super();
	}

	public Category(int cateID, String cateName, int state, CategoryParents cateParent, List<Product> product) {
		super();
		this.cateID = cateID;
		this.cateName = cateName;
		this.state = state;
		this.cateParent = cateParent;
		this.product = product;
	}

	public int getCateID() {
		return cateID;
	}

	public void setCateID(int cateID) {
		this.cateID = cateID;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public CategoryParents getCateParent() {
		return cateParent;
	}

	public void setCateParent(CategoryParents cateParent) {
		this.cateParent = cateParent;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}
	
}

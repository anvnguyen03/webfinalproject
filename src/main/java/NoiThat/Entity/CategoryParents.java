package NoiThat.Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CategoryParents")
@NamedQuery(name = "CategoryParent.findAll", query = "SELECT cp FROM CategoryParents cp")

public class CategoryParents {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cateParentsID;

	@Column(columnDefinition = "nvarchar(50)")
	private String cateParentsName;

	private int state;

	@OneToMany(mappedBy = "cateParent", fetch = FetchType.EAGER) // Sửa "categoryparents" thành "cateParents"
	private List<Category> categorys;

	public CategoryParents() {
		super();
	}

	public CategoryParents(int cateParentsID, String cateParentsName, int state, List<Category> categorys) {
		super();
		this.cateParentsID = cateParentsID;
		this.cateParentsName = cateParentsName;
		this.state = state;
		this.categorys = categorys;
	}

	public int getCateParentsID() {
		return cateParentsID;
	}

	public void setCateParentsID(int cateParentsID) {
		this.cateParentsID = cateParentsID;
	}

	public String getCateParentsName() {
		return cateParentsName;
	}

	public void setCateParentsName(String cateParentsName) {
		this.cateParentsName = cateParentsName;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public List<Category> getCategorys() {
		return categorys;
	}

	public void setCategorys(List<Category> categorys) {
		this.categorys = categorys;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "CategoryParents [cateParentsID=" + cateParentsID + ", cateParentsName=" + cateParentsName + ", state="
				+ state + ", categorys=" + categorys + "]";
	}
	
	
}

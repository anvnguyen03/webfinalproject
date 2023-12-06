package NoiThat.Entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "User")
@NamedQuery(name = "User.findAll", query = "SELECT c FROM User c")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userID;
	
	private String username;
	private String password;
	private String email;
	private Timestamp createdAt;
	private Timestamp modifiedAt;
	private int state;
	private String code;
	private String fullname;
	@ManyToOne
	@JoinColumn(name = "roleID")
	private UserRole userrole;
	
	@OneToOne(mappedBy = "user", fetch = FetchType.EAGER)
	private Cart cart;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Bill> bill;


	public User(int userID, String username, String password, String email, Timestamp createdAt, Timestamp modifiedAt,
			int state, String code, String fullname, UserRole userrole, Cart cart, List<Bill> bill) {
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.email = email;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
		this.state = state;
		this.code = code;
		this.fullname = fullname;
		this.userrole = userrole;
		this.cart = cart;
		this.bill = bill;
	}

	public User(String username, String email, String code, String fullname) {
		this.username = username;
		this.email = email;
		this.code = code;
		this.fullname = fullname;
	}

	public User(String username, String password, String email, int state, String code, String fullname,
			UserRole userrole) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.state = state;
		this.code = code;
		this.fullname = fullname;
		this.userrole = userrole;
	}

	public User() {
		
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Timestamp modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public UserRole getUserrole() {
		return userrole;
	}

	public void setUserrole(UserRole userrole) {
		this.userrole = userrole;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public List<Bill> getBill() {
		return bill;
	}

	public void setBill(List<Bill> bill) {
		this.bill = bill;
	}
	
	
	
}
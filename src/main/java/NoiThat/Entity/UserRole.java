package NoiThat.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "UserRole")
@NamedQuery(name = "UserRole.findAll", query = "SELECT u FROM UserRole u")
public class UserRole {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roleID;
	
	private String roleName;

	public UserRole(int roleID, String roleName) {
		super();
		this.roleID = roleID;
		this.roleName = roleName;
	}

	public UserRole() {
	
	}

	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "UserRole [roleID=" + roleID + ", roleName=" + roleName + "]";
	}
	
	
}

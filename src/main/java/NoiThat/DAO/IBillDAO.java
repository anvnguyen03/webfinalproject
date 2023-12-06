package NoiThat.DAO;

import java.util.List;

import NoiThat.Entity.Bill;

public interface IBillDAO {
	List<Bill> findAll();
	List<Bill> findByID(int billid);
	List<Bill> findByUser(int userid);
	void insert(Bill bill);
	void update(Bill bill);
	
}

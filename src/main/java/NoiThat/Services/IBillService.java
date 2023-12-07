package NoiThat.Services;

import java.util.List;

import NoiThat.Entity.Bill;

public interface IBillService {
	List<Bill> findAll();
	Bill findByID(int billid);
	List<Bill> findByUser(int userid);
	void insert(Bill bill);
	void update(Bill bill);
}

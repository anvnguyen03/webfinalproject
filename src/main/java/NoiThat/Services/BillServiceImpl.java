package NoiThat.Services;

import java.util.List;

import NoiThat.DAO.BillDAOImpl;
import NoiThat.DAO.IBillDAO;
import NoiThat.Entity.Bill;

public class BillServiceImpl implements IBillService{
	IBillDAO bd = new BillDAOImpl();
	@Override
	public List<Bill> findAll() {
		return bd.findAll();
	}

	@Override
	public List<Bill> findByID(int billid) {
		return bd.findByID(billid);
	}

	@Override
	public List<Bill> findByUser(int userid) {
		return bd.findByUser(userid);
	}

	@Override
	public void insert(Bill bill) {
		bd.insert(bill);
	}

	@Override
	public void update(Bill bill) {
		bd.update(bill);
	}

}

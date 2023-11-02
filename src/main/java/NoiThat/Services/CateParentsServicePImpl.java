package NoiThat.Services;

import java.util.List;

import NoiThat.DAO.CateParentsDAOImpl;
import NoiThat.DAO.ICateParentsDAO;
import NoiThat.Entity.CategoryParents;

public class CateParentsServicePImpl implements ICateParentsService{

	ICateParentsDAO catepa = new CateParentsDAOImpl();
	@Override
	public List<CategoryParents> findAllCateParents() {
		
		return catepa.findAllCateParents();
	}

}

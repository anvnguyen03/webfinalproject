package NoiThat.Services;

import java.util.List;

import NoiThat.DAO.CateParentsDAOImpl;
import NoiThat.DAO.ICateParentsDAO;
import NoiThat.Entity.CategoryParents;

public class CateParentsServiceImpl implements ICateParentsService{

	ICateParentsDAO catepa = new CateParentsDAOImpl();
	@Override
	public List<CategoryParents> findAllCateParents() {
		
		return catepa.findAllCateParents();
	}
	@Override
	public void insert(CategoryParents cateParents) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void update(CategoryParents cateparents) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(int cateParentsid) throws Exception {
		// TODO Auto-generated method stub
		
	}

}

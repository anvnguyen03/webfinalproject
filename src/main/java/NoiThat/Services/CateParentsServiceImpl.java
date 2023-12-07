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
		catepa.insert(cateParents);
		
	}
	@Override
	public void update(CategoryParents cateparents) {
		catepa.update(cateparents);
		
	}
	@Override
	public void delete(CategoryParents cateparents) throws Exception {
		catepa.delete(cateparents);
		
	}

}

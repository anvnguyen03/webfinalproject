package NoiThat.Services;

import java.util.List;

import NoiThat.DAO.CateDAOImpl;
import NoiThat.DAO.ICateDAO;
import NoiThat.Entity.Category;

public class CateServiceImpl implements ICateService{

	ICateDAO cate = new CateDAOImpl();
	@Override
	public List<Category> findAllCate() {
		
		return cate.findAllCategories();
	}
	@Override
	public void insert(Category category) {
		cate.insert(category);
		
	}
	@Override
	public void update(Category category) {
		cate.update(category);
		
	}
	@Override
	public void delete(int cateid) throws Exception {
		cate.delete(cateid);
		
	}
	@Override
	public List<Category> findByCategoryParentsID(int cateparentsid) {
		return cate.findByCategoryParentsID(cateparentsid);
	}
	@Override
	public int count() {
		return cate.count();
	}	

}

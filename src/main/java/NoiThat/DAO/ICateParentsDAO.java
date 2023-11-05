package NoiThat.DAO;

import java.util.List;

import NoiThat.Entity.CategoryParents;

public interface ICateParentsDAO {
	
	List<CategoryParents> findAllCateParents();
	void insert(CategoryParents cateParents);
	void update(CategoryParents cateparents);
	void delete(int cateParentsid) throws Exception;

}

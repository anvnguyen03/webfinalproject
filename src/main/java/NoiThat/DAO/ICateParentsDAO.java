package NoiThat.DAO;

import java.util.List;

import NoiThat.Entity.CategoryParents;

public interface ICateParentsDAO {

	void delete(int cateParentsid) throws Exception;

	void update(CategoryParents cateparents);

	void insert(CategoryParents cateParents);

	List<CategoryParents> findAllCateParents();
	

	

}

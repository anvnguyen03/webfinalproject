package NoiThat.Services;

import java.util.List;

import NoiThat.Entity.CategoryParents;

public interface ICateParentsService {
	
	List<CategoryParents> findAllCateParents();
	void insert(CategoryParents cateParents);
	void update(CategoryParents cateparents);
	void delete(int cateParentsid) throws Exception;
}

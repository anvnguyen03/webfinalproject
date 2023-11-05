package NoiThat.Services;

import java.util.List;

import NoiThat.Entity.Category;

public interface ICateService {
	List<Category> findAllCate();
	void insert(Category category);
	void update(Category category);
	void delete(int cateid) throws Exception;
	List<Category> findByCategoryParentsID(int cateparentsid);
	int count();
}

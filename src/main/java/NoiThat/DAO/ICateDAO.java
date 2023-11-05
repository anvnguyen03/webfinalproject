package NoiThat.DAO;

import java.util.List;

import NoiThat.Entity.Category;

public interface ICateDAO {
	List<Category> findAllCategories();
	void insert(Category category);
	void update(Category category);
	void delete(int cateid) throws Exception;
	List<Category> findByCategoryParentsID(int cateparentsid);
	int count();
}

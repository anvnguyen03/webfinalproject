package NoiThat.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import NoiThat.Entity.Category;
import NoiThat.Entity.CategoryParents;
import NoiThat.JPAConfig.JPAConfig;

public class CateParentsDAOImpl implements ICateParentsDAO{

	@Override
	public List<CategoryParents> findAllCateParents() {
		EntityManager enma = JPAConfig.getEntityManager();

		TypedQuery<CategoryParents> query = enma.createNamedQuery("CategoryParent.findAll", CategoryParents.class);

		return query.getResultList();
	}

	@Override
	public void insert(CategoryParents cateParents) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			enma.persist(cateParents);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
		
	}

	@Override
	public void update(CategoryParents cateparents) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			enma.merge(cateparents);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
		
	}

	@Override
	public void delete(int cateParentsid) throws Exception {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			Category category = enma.find(Category.class, cateParentsid);
			if (category != null) {
				enma.remove(category);
			} else {
				throw new Exception("Không tìm thấy!!");
			}
			
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
		
	}
	
//	public static void main(String[] args) throws Exception {
//		ICateParentsDAO catepa = new CateParentsDAOImpl();
//		
////		CategoryParents cateparents = new CategoryParents();
////		cateparents.setCateParentsName("test");
////		cateparents.setState(0);
////		catepa.insert(cateparents);
//		
////		cateparents.setCateParentsID(7);
////		cateparents.setCateParentsName("not test");
////		catepa.update(cateparents);
//		
////		int id = 8;
////		try {
////		    catepa.delete(id);
////		    System.out.println("Xóa thành công!");
////		} catch (Exception e) {
////		    e.printStackTrace();
////		    System.out.println("Xóa thất bại: " + e.getMessage());
////		}
//		
//		System.out.println(catepa.findAllCateParents());
//	}

}

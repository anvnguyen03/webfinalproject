package NoiThat.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import NoiThat.Entity.Category;
import NoiThat.JPAConfig.JPAConfig;

public class CateDAOImpl implements ICateDAO{

	@Override
	public List<Category> findAllCategories() {
		EntityManager enma = JPAConfig.getEntityManager();
		
		TypedQuery<Category> query = enma.createNamedQuery("Category.findAll", Category.class);
		
		return query.getResultList();
	} 

	@Override
	public void insert(Category category) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			enma.persist(category);
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
	public void update(Category category) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			enma.merge(category);
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
	public void delete(int cateid) throws Exception {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			Category category = enma.find(Category.class, cateid);
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

	@Override
	public List<Category> findByCategoryParentsID(int cateparentsid) {
		EntityManager enma = JPAConfig.getEntityManager();
		String jpql = "SELECT c from Category c WHERE c.cateParent.cateParentsID like :cateparentsid";
		TypedQuery<Category> query = enma.createQuery(jpql, Category.class);
		query.setParameter("cateparentsid", cateparentsid);
		
		return query.getResultList();
	}

	@Override
	public int count() {
		EntityManager enma = JPAConfig.getEntityManager();
		String jpql = "SELECT count(c) FROM Category c";
		javax.persistence.Query query = enma.createQuery(jpql);
		return ((Long)query.getSingleResult()).intValue();
	}
	
//	public static void main(String[] args) {
//		ICateDAO catepa = new CateDAOImpl();
//		Category cate = new Category();
//		cate.setCateName("testcate");
//		cate.setState(0);
//		cate.setCateParent(null);
//		System.out.println(catepa.insert());
//	}
	
}

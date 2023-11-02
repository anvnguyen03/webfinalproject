package NoiThat.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import NoiThat.Entity.CategoryParents;
import NoiThat.JPAConfig.JPAConfig;

public class CateParentsDAOImpl implements ICateParentsDAO{

	@Override
	public List<CategoryParents> findAllCateParents() {
		EntityManager enma = JPAConfig.getEntityManager();

		TypedQuery<CategoryParents> query = enma.createNamedQuery("CategoryParent.findAll", CategoryParents.class);

		return query.getResultList();
	}
	
	public static void main(String[] args) {
		ICateParentsDAO catepa = new CateParentsDAOImpl();
			
		System.out.println(catepa.findAllCateParents());
	}

}

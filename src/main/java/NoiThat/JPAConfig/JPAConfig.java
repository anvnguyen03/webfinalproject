package NoiThat.JPAConfig;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAConfig {
	
	public static EntityManager getEntityManager() {
		EntityManagerFactory fatory = Persistence.createEntityManagerFactory("bandonoithat");
		return fatory.createEntityManager();
	}

}

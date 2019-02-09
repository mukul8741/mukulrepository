package org.axelor.guice.modules;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import com.google.inject.Inject;
import com.google.inject.persist.Transactional;

/**
 * 
 * we have to bind this class also in module other wise nullPointer Error wiil come
 * (Here binding module used is BindingMod.class
 *
 */
@Path("")
public class RestService {
	
	@Inject
	EntityManager em;
	
	@Path("save")
	@GET
	@Consumes("application/x-www-form-urlencoded")
	@Transactional
	public void save(@QueryParam("id") int id,@QueryParam("name") String name) {
//		 EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "testDB" );
//	      
//	      EntityManager entitymanager = emfactory.createEntityManager( );
//	      entitymanager.getTransaction( ).begin( );
	      
	      CarBank car = new CarBank();
			
			car.setId(id);
			car.setName(name);
			
			
//	      entitymanager.persist( car );
//	      entitymanager.getTransaction( ).commit( );
//
//	      entitymanager.close( );
//	      emfactory.close( );
		
		em.persist(car);
		
		System.out.println("Done");
		
	}

}

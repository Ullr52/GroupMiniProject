package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Borrower;



/**
 * @author jword - jord
 * CIS175 - Spring - 2022
 * Mar 1, 2022
 */
public class BorrowerHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("GroupMiniProject");

	public void insertShopper(Borrower b) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(b);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Borrower> showAllBorrowers() {
		EntityManager em = emfactory.createEntityManager();
		List<Borrower> allBorrowers = em.createQuery("SELECT b FROM Borrower b").getResultList();
		return allBorrowers;
	}
	
	public Borrower findBorrower(String nameToLookUp) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Borrower> typedQuery = em.createQuery("select sh from Borrower sh where sh.borrowerName = :selectedName", Borrower.class);
		typedQuery.setParameter("selectedName", nameToLookUp);
		typedQuery.setMaxResults(1);
		Borrower foundBorrower;
		try {
			foundBorrower = typedQuery.getSingleResult();
		} catch (NoResultException ex) {
			foundBorrower = new Borrower(nameToLookUp);
		}
		em.close();
		return foundBorrower;
	}
	
}

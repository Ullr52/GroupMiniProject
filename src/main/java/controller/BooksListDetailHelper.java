package controller;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.BooksListDetails;







/**
 * @author jword - jord
 * CIS175 - Spring - 2022
 * Mar 1, 2022
 */
public class BooksListDetailHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("GroupMiniProject");
	
	public void insertNewBooksListDetails(BooksListDetails b) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(b);
		em.getTransaction().commit();
		em.close();
	}
	
	public void deleteBooksList(BooksListDetails bookListToDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<BooksListDetails> typedQuery = em.createQuery("select detail from BooksListDetails detail where detail.id = :selectedId", BooksListDetails.class);
	
		typedQuery.setParameter("selectedId", bookListToDelete.getId());

		typedQuery.setMaxResults(1);
	
		BooksListDetails result = typedQuery.getSingleResult();

		em.remove(result);
		em.getTransaction().commit();
		em.close();
		}
	
	public BooksListDetails searchForBooksListDetailsById(Integer tempId) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		BooksListDetails found = em.find(BooksListDetails.class, tempId);
		em.close();
		return found;
	}
	
	public void updateBooksList(BooksListDetails toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
		}
	
	public List<BooksListDetails> getBookLists() {
		EntityManager em = emfactory.createEntityManager();
		List<BooksListDetails> allDetails = em.createQuery("SELECT b FROM BooksListDetails b").getResultList();
		return allDetails;
	}
}

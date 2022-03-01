/**
 * Avon (Andres) Mata - ammata & John Ord
 * CIS175 JAVA II
 * Group Mini Project
 * Completed on: Mar 1, 2022
 */
package controller;

import java.util.List;
import javax.persistence.*;

import model.Bookslist;

public class BookslistHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("FundraiserDonations");
	
	public void addBook(Bookslist book) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(book);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Bookslist> showAllBooks() {
		EntityManager em = emfactory.createEntityManager();
		List<Bookslist> allBooks = em.createQuery("SELECT i FROM Library i").getResultList();
		return allBooks;
	}
	
	public void updateBook(Bookslist toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public Bookslist searchForBookById(int id){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Bookslist found = em.find(Bookslist.class, id);
		em.close();
		return found;
	}
	
	public void deleteBook(Bookslist toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Bookslist> typedQuery = em.createQuery("SELECT i FROM Library i WHERE i.id = :selectedId AND i.title = :selectedTitle", Bookslist.class);
		
		//Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedId", toDelete.getId());
		typedQuery.setParameter("selectedTitle", toDelete.getTitle());
		
		//only one result
		typedQuery.setMaxResults(1);
		
		//get result, save into new list item
		Bookslist result = typedQuery.getSingleResult();
		
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public void cleanUp() {
		emfactory.close();
	}
}

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
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("GroupMiniProject");
	
	public void addBook(Bookslist b) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(b);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Bookslist> showAllBooks() {
		EntityManager em = emfactory.createEntityManager();
		List<Bookslist> allBooks = em.createQuery("SELECT i FROM Bookslist i").getResultList();
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
		TypedQuery<Bookslist> typedQuery = em.createQuery("SELECT b FROM Bookslist b WHERE b.publisher = :selectedPublisher AND b.title = :selectedTitle AND b.genre = :selectedGenre", Bookslist.class);
		
		//Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedPublisher", toDelete.getPublisher());
		typedQuery.setParameter("selectedTitle", toDelete.getTitle());
		typedQuery.setParameter("selectedGenre", toDelete.getGenre());
		
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

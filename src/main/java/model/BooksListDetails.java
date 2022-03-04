package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author jword - jord
 * CIS175 - Spring - 2022
 * Mar 1, 2022
 */
@Entity
public class BooksListDetails {
	@Id
	@GeneratedValue
	private int id;
	private String borrowerListName;
	private LocalDate borrowDate;
	@ManyToOne (cascade=CascadeType.PERSIST)
	private Borrower borrower;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<Bookslist> listOfBooks;
	/**
	 * 
	 */
	public BooksListDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param borrowerListName
	 * @param borrowDate
	 * @param borrower
	 * @param listOfBooks
	 */
	public BooksListDetails(int id, String borrowerListName, LocalDate borrowDate, Borrower borrower,
			List<Bookslist> listOfBooks) {
		super();
		this.id = id;
		this.borrowerListName = borrowerListName;
		this.borrowDate = borrowDate;
		this.borrower = borrower;
		this.listOfBooks = listOfBooks;
	}
	/**
	 * @param borrowerListName
	 * @param borrowDate
	 * @param borrower
	 * @param listOfBooks
	 */
	public BooksListDetails(String borrowerListName, LocalDate borrowDate, Borrower borrower, List<Bookslist> listOfBooks) {
		super();
		this.borrowerListName = borrowerListName;
		this.borrowDate = borrowDate;
		this.borrower = borrower;
		this.listOfBooks = listOfBooks;
	}
	/**
	 * @param borrowDate
	 * @param borrower
	 * @param listOfBooks
	 */
	public BooksListDetails(String borrowerListName, LocalDate borrowDate, Borrower borrower) {
		super();
		this.borrowerListName = borrowerListName;
		this.borrowDate = borrowDate;
		this.borrower = borrower;
		
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the borrowerListName
	 */
	public String getborrowerListName() {
		return borrowerListName;
	}
	/**
	 * @param borrowerListName the borrowerListName to set
	 */
	public void setborrowerListName(String borrowerListName) {
		this.borrowerListName = borrowerListName;
	}
	/**
	 * @return the borrowDate
	 */
	public LocalDate getBorrowDate() {
		return borrowDate;
	}
	/**
	 * @param borrowDate the borrowDate to set
	 */
	public void setBorrowDate(LocalDate borrowDate) {
		this.borrowDate = borrowDate;
	}
	/**
	 * @return the borrower
	 */
	public Borrower getBorrower() {
		return borrower;
	}
	/**
	 * @param borrower the borrower to set
	 */
	public void setBorrower(Borrower borrower) {
		this.borrower = borrower;
	}
	/**
	 * @return the listOfBooks
	 */
	public List<Bookslist> getListOfBooks() {
		return listOfBooks;
	}
	/**
	 * @param listOfBooks the listOfBooks to set
	 */
	public void setListOfBooks(List<Bookslist> listOfBooks) {
		this.listOfBooks = listOfBooks;
	}
	@Override
	public String toString() {
		return "BooksListDetails [id=" + id + ", borrowerListName=" + borrowerListName + ", borrowDate=" + borrowDate
				+ ", borrower=" + borrower + ", listOfBooks=" + listOfBooks + "]";
	}
	
	

	
}

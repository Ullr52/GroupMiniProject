package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author jword - jord
 * CIS175 - Spring - 2022
 * Mar 1, 2022
 */

@Entity
@Table(name = "borrower")
public class Borrower {
	@Id
	@GeneratedValue
	private int id;
	private String borrowerName;
	/**
	 * 
	 */
	public Borrower() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param borrowerName
	 */
	public Borrower(int id, String borrowerName) {
		super();
		this.id = id;
		this.borrowerName = borrowerName;
	}
	/**
	 * @param borrowerName
	 */
	public Borrower(String borrowerName) {
		super();
		this.borrowerName = borrowerName;
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
	 * @return the borrowerName
	 */
	public String getBorrowerName() {
		return borrowerName;
	}
	/**
	 * @param borrowerName the borrowerName to set
	 */
	public void setBorrowerName(String borrowerName) {
		this.borrowerName = borrowerName;
	}
	@Override
	public String toString() {
		return "Borrower [id=" + id + ", borrowerName=" + borrowerName + "]";
	}
	
	

}

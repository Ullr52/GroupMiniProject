package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BooksListDetails;
import model.Bookslist;
import model.Borrower;


/**
 * Servlet implementation class CreateNewBooksListServlet
 */
@WebServlet("/createNewBooksListServlet")
public class CreateNewBooksListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewBooksListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BookslistHelper blh = new BookslistHelper();
		String borrowerListName = request.getParameter("borrowerListName");
		System.out.println("Borrower List Name: "+ borrowerListName);
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String borrowerName = request.getParameter("borrowerName");
		LocalDate ld;
		try {
		ld = LocalDate.of(Integer.parseInt(year),
		Integer.parseInt(month), Integer.parseInt(day));
		}catch(NumberFormatException ex) {
		ld = LocalDate.now();
		}
		String[] selectedBooks = request.getParameterValues("allBooksToAdd");
		List<Bookslist> selectedBooksInList = new ArrayList<Bookslist>();
		//make sure something was selected – otherwise we get a null pointer exception
		if (selectedBooks != null && selectedBooks.length > 0)
		{
		for(int i = 0; i<selectedBooks.length; i++) {
		System.out.println(selectedBooks[i]);
		Bookslist c = blh.searchForBookById(Integer.parseInt(selectedBooks[i]));
		selectedBooksInList.add(c);
		}
		}
		Borrower borrower = new Borrower(borrowerName);
		BooksListDetails bld = new BooksListDetails(borrowerListName, ld, borrower);
		bld.setListOfBooks(selectedBooksInList);
		BooksListDetailHelper bldh = new BooksListDetailHelper();
		bldh.insertNewBooksListDetails(bld);
		System.out.println("Success!");
		System.out.println(bld.toString());
		getServletContext().getRequestDispatcher("/viewAllBooksListServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

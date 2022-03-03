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
 * Servlet implementation class EditBooksDetailsServlet
 */
@WebServlet("/editBooksDetailsServlet")
public class EditBooksDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditBooksDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BooksListDetailHelper dao = new BooksListDetailHelper();
		BookslistHelper blh = new BookslistHelper();
		BorrowerHelper bh = new BorrowerHelper();
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		BooksListDetails borrowerListToUpdate = dao.searchForBooksListDetailsById(tempId);
		String borrowerListName = request.getParameter("borrowerListName");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String borrowerName = request.getParameter("borrowerName");
		// find our add the new shopper
		Borrower newBorrower = bh.findBorrower(borrowerName);
		LocalDate ld;
		
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex) {
			ld = LocalDate.now();
			
		}
		try {
			// books are selected in list to add
			String[] selectedBooks = request.getParameterValues("allBooksToAdd");
			List<Bookslist> selectedBooksInList = new ArrayList<Bookslist>();
			for (int i = 0; i < selectedBooks.length; i++) {
				System.out.println(selectedBooks[i]);
				Bookslist c = blh.searchForBookById(Integer.parseInt(selectedBooks[i]));
				selectedBooksInList.add(c);
			}
			
			borrowerListToUpdate.setListOfBooks(selectedBooksInList);
		} catch (NullPointerException ex) {
			// no items selected in list - set to an empty list
			List<Bookslist> selectedBooksInList = new ArrayList<Bookslist>();
			borrowerListToUpdate.setListOfBooks(selectedBooksInList);
			
		}
		borrowerListToUpdate.setborrowerListName(borrowerListName);
		borrowerListToUpdate.setBorrowDate(ld);
		borrowerListToUpdate.setBorrower(newBorrower);
		dao.updateBooksList(borrowerListToUpdate);
		getServletContext().getRequestDispatcher("/viewAllBooksServlet").forward(request, response);
	}
}
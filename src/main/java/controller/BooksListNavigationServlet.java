package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BooksListDetails;


/**
 * Servlet implementation class BooksListNavagationServlet
 */
@WebServlet("/booksListNavigationServlet")
public class BooksListNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BooksListNavigationServlet() {
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
		String act = request.getParameter("doThisToBooksList");
		
		if (act == null) {
			// no button has been selected
			getServletContext().getRequestDispatcher("/viewAllBooksListServlet").forward(request, response);
			
		} else if (act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				BooksListDetails booksListToDelete = dao.searchForBooksListDetailsById(tempId);
				dao.deleteBooksList(booksListToDelete);
				
			} catch (NumberFormatException e) {
				System.out.println("Forgot to click a button");
			} finally {
				getServletContext().getRequestDispatcher("/viewAllBooksListServlet").forward(request, response);
			}
			
		} else if (act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				BooksListDetails booksListToEdit = dao.searchForBooksListDetailsById(tempId);
				request.setAttribute("booksListToEdit", booksListToEdit);
				request.setAttribute("month", booksListToEdit.getBorrowDate().getMonthValue());
				request.setAttribute("date", booksListToEdit.getBorrowDate().getDayOfMonth());
				request.setAttribute("year", booksListToEdit.getBorrowDate().getYear());
				
				BookslistHelper daoForBooks = new BookslistHelper();
				
				request.setAttribute("allBooks", daoForBooks.showAllBooks());
				if (daoForBooks.showAllBooks().isEmpty()) {
					request.setAttribute("allBooks", " ");
				}
				
				getServletContext().getRequestDispatcher("/edit-books-list.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				getServletContext().getRequestDispatcher("/viewAllBooksListServlet").forward(request, response);
			}
		} else if (act.equals("add")) {
			getServletContext().getRequestDispatcher("/new-books-list.jsp").forward(request, response);
		}
	}
}
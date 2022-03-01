package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Bookslist;

/**
 * Servlet implementation class EditBookServlet
 */
@WebServlet("/editBookServlet")
public class EditBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditBookServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookslistHelper blh = new BookslistHelper();
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		String publisher = request.getParameter("publisher");
		String title = request.getParameter("title");
		String genre = request.getParameter("genre");
		
		Bookslist bookToUpdate = blh.searchForBookById(tempId);
		bookToUpdate.setPublisher(publisher);
		bookToUpdate.setTitle(title);
		bookToUpdate.setGenre(genre);
		
		blh.updateBook(bookToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllBooksServlet").forward(request, response);
	}

}

package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Bookslist;

/**
 * Servlet implementation class AddBookServlet
 */
@WebServlet("/addBookServlet")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBookServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String publisher = request.getParameter("publisher");
		String title = request.getParameter("title");
		String genre = request.getParameter("genre");
		
		Bookslist bookToAdd = new Bookslist(publisher, title, genre);
		BookslistHelper blh = new BookslistHelper();
		blh.addBook(bookToAdd);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}

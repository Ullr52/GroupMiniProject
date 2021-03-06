package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Bookslist;

/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/navigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigationServlet() {
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
		String act = request.getParameter("doThisToBook");
		
		String path = "/viewAllBooksServlet";
		
		if(act.equals("delete")) {
			try{
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Bookslist bookToDelete = blh.searchForBookById(tempId);
				blh.deleteBook(bookToDelete);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select a book.");
			}
			
		} else if(act.equals("edit")) {
			try{
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Bookslist bookToEdit = blh.searchForBookById(tempId);
				request.setAttribute("booksToEdit", bookToEdit);
				path = "/edit-books.jsp";
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select a book.");
			}
			
		} else if(act.equals("add")) {
			path = "/index.html";
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}

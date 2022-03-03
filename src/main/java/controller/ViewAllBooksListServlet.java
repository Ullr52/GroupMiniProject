package controller;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BooksListDetails;
import model.Bookslist;


/**
 * Servlet implementation class ViewAllBooksListServlet
 */
@WebServlet("/viewAllBooksListServlet")
public class ViewAllBooksListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllBooksListServlet() {
        super();
        // TODO Auto-generated constructor stub
        
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BooksListDetailHelper bldh = new BooksListDetailHelper();
		List<BooksListDetails> abc = bldh.getBookLists();
		request.setAttribute("allBooks", abc);
		if(abc.isEmpty()){
		request.setAttribute("allBooks", " ");
		}
		getServletContext().getRequestDispatcher("/books-list-by-borrower.jsp").forward(request, response);
	response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

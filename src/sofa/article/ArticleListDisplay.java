package sofa.article;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.annotation.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sofa.data.ArticleDB;

import sofa.model.Article;


@WebServlet(urlPatterns={"/articleList", "/sam/*"})
public class ArticleListDisplay extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession();
		 ArrayList<Article> articles = ArticleDB.selectArticles();
	     session.setAttribute("articles", articles);
	     String url = "/article/indexList.jsp";
	     RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
	     dispatcher.forward(request, response);        
	 }
	 public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	          doGet(request, response);
	 }
}

package sofa.article;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sofa.data.ArticleDB;
import sofa.model.Article;
@WebServlet("/articleImage")
public class ArticleImageDisplay extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int articleID = Integer.parseInt(request.getParameter("Id"));
        Article article = ArticleDB.selectArticle(articleID);
        byte [] image =  article.getImageBytes();
        response.setContentType("image/jpg");
        response.getOutputStream().write(image);;
        response.getOutputStream().flush();
        response.getOutputStream().close();
      
	}
}


package sofa.article;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import sofa.data.ArticleDB;
import sofa.model.Article;
@MultipartConfig(maxFileSize = 16177215)
@WebServlet("/articleInsert")
public class ArticleInsert extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("UserName");
		String description = request.getParameter("Description");
		//SimpleDateFormat sysForm = new SimpleDateFormat("yyyy/MM/DD");
	   // Date curdate= new Date();
		
		InputStream inputStream = null;
		Part filePart = request.getPart("Photo");
		byte [] bytes = new byte[(int) filePart.getSize()];
		inputStream = filePart.getInputStream();
		inputStream.read(bytes);
		inputStream.close();
		Article article = new Article();
		
		
		article.setUserName(userName);
		article.setDescription(description);
		article.setImageBytes(bytes);
		
		ArticleDB.insert(article);
		
		String url = "/article/"  + "/article.jsp";
	    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
	    dispatcher.forward(request, response);
    }
}

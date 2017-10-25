package sofa.article;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sofa.data.ArticleDB;
import sofa.data.CommentDB;
import sofa.model.Article;
import sofa.model.Comment;
@WebServlet("/articleDisplay")
public class ArticleDisplay extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  HttpSession session = request.getSession();
		  int art = Integer.parseInt(request.getParameter("Id"));
		  /*SimpleDateFormat sysForm = new SimpleDateFormat("yyyy/MM/DD");
	      Date curdate = new Date();*/
	      /*System.out.println(sysForm.format(curdate));*/
          Article article =  ArticleDB.selectArticle(art);
        
         /* session.setAttribute("curdate",  curdate);*/
          session.setAttribute("article",  article);
          String url = "/article/index.jsp";
	      RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
	      dispatcher.forward(request, response);
	}
}
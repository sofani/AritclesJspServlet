package sofa.comment;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import sofa.data.CommentDB;
import sofa.data.UserDB;
import sofa.model.Comment;
import sofa.model.User;
@WebServlet("/commentInsert")
public class CommentInsert extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		int artId = Integer.parseInt(request.getParameter("id"));
		String userName = (String) session.getAttribute("userName");
		String comment = request.getParameter("comment");		
		Comment comm = new Comment();
		comm.setComment(comment);
	    comm.setUserName(userName);
	  
	  
	    String url = null;
		CommentDB.insert(artId, comm);
	    url = "/article/index.jsp";
			
		
		
	
		
		
	     RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
	     dispatcher.forward(request, response);    
    }
}

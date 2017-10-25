package sofa.comment;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sofa.data.CommentDB;
import sofa.model.Comment;
import sofa.model.Reply;
@WebServlet("/commentDisplay")
public class CommentDisplay extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		 int comId = Integer.parseInt(request.getParameter("cId"));

		 Comment commentR = CommentDB.selectComment(comId);
		
	     session.setAttribute("commentR", commentR);
		 String url = "/article/index.jsp";
	     RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
	     dispatcher.forward(request, response); 
    }
}

package sofa.reply;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sofa.data.ReplyDB;
import sofa.model.Reply;

public class ReplyInsert extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  int cid = Integer.parseInt(request.getParameter("cid")); 
	
	  HttpSession session = request.getSession();
	  Reply reply = new Reply();
      String rep = request.getParameter("reply");
  	  String userName = (String) session.getAttribute("userName");
      reply.setReply(rep);
      reply.setUserName(userName);
      ReplyDB.insert(reply, cid);
  	  String url = "/article/index.jsp";
      RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
      dispatcher.forward(request, response);    
      
	}
}

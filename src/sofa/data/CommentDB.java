package sofa.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.util.ArrayList;

import sofa.model.Article;
import sofa.model.Comment;
import sofa.model.Reply;

public class CommentDB {
	public static int insert(int articleId, Comment comment)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
         
        
        String query = 
                "INSERT INTO Comm ( Comment, articleId, commentUserName) " + 
                "VALUES (?, ?, ?) "; 
        try
        {        
            ps = connection.prepareStatement(query);
            ps.setString(3, comment.getUserName());
            ps.setString(1, comment.getComment());
            ps.setInt(2, articleId);
           
            return ps.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return 0;
        }
        finally
        {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    
	public static Comment selectComment(int commentID)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query =  "SELECT  * " +
                "FROM comm " +
                "LEFT OUTER JOIN reply " +
                "ON comm.cId = reply.commentId " +
                "WHERE comm.cId =? ";
        try
        {
            ps = connection.prepareStatement(query);
            ps.setInt(1, commentID);
            rs = ps.executeQuery();
            Comment c = new Comment();
            ArrayList<Reply> replies = new ArrayList<Reply>();
          
            while(rs.next())
            {
               Reply r = new Reply();
               c.setcId(rs.getInt("cId"));
               c.setUserName(rs.getString("commentUserName"));
              
               r.setReply(rs.getString("reply"));
               r.setUserName(rs.getString("replyUserName"));
               replies.add(r);
               c.setReplies(replies);    
            }
          
            return c;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
        finally
        {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
	
}

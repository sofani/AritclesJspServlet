package sofa.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import sofa.model.Reply;



public class ReplyDB {
	public static int insert(Reply reply, int commentId)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
         
        
        String query = 
                "INSERT INTO reply (reply, commentId ,replyUserName) " + 
                "VALUES (?, ?, ?) "; 
        try
        {        
            ps = connection.prepareStatement(query);
            ps.setString(3, reply.getUserName());
            ps.setString(1, reply.getReply());
            ps.setInt(2, commentId);
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

}

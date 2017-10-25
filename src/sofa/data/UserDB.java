package sofa.data;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.util.ArrayList;

import sofa.model.Article;
import sofa.model.Comment;
import sofa.model.User;

public class UserDB implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static int insert(User user)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

       
        String query = 
                "INSERT INTO user (UName,  Password, Email, Photo) " + 
                "VALUES (?, ?, ?, ?) "; 
        try
        {        
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            ps.setBytes(4, user.getImageBytes());
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
	 public static boolean userNameExists(String userName)
	    {
	        ConnectionPool pool = ConnectionPool.getInstance();
	        Connection connection = pool.getConnection();
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        
	        String query = "SELECT UName FROM user " +
	                "WHERE UName = ?";
	        try
	        {
	            ps = connection.prepareStatement(query);
	            ps.setString(1, userName);
	            rs = ps.executeQuery();
	            return rs.next();
	        }
	        catch(SQLException e)
	        {
	            e.printStackTrace();
	            return false;
	        }
	        finally
	        {
	            DBUtil.closeResultSet(rs);
	            DBUtil.closePreparedStatement(ps);
	            pool.freeConnection(connection);
	        }
	    }
	 public static boolean logIn(String userName, String password)
	    {
	        ConnectionPool pool = ConnectionPool.getInstance();
	        Connection connection = pool.getConnection();
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        
	        String query = "SELECT UName, Password FROM user " +
	                "WHERE UName =? AND Password =?";
	        		
	        try
	        {
	            ps = connection.prepareStatement(query);
	            ps.setString(1, userName);
	            ps.setString(2, password);
	            rs = ps.executeQuery();
	            return rs.next();
	        }
	        catch(SQLException e)
	        {
	            e.printStackTrace();
	            return false;
	        }
	        finally
	        {
	            DBUtil.closeResultSet(rs);
	            DBUtil.closePreparedStatement(ps);
	            pool.freeConnection(connection);
	        }
	    }
	 public static User selectUser(String userName)
	    {
	        ConnectionPool pool = ConnectionPool.getInstance();
	        Connection connection = pool.getConnection();
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	       
	        String query = "SELECT * " +
	                "FROM user " +
	                "WHERE user.UName =?";           
	        try
	        {
	            ps = connection.prepareStatement(query);
	            ps.setString(1, userName);
	            
	            rs = ps.executeQuery();
	            User u = new User();
	          
	           
	           
	            while(rs.next())
	            {
	            	u.setUserName(rs.getString("UName"));
	            	u.setImageBytes(rs.getBytes("Photo"));
	                u.setEmail(rs.getString("Email"));
	                u.setPassword(rs.getString("Password"));
	              
	               
	            }
	          
	            return u;
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

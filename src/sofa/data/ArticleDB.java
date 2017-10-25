package sofa.data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.util.ArrayList;

import sofa.model.Article;
import sofa.model.Comment;
import sofa.model.Reply;
import sofa.data.ConnectionPool;
import sofa.data.DBUtil;

public class ArticleDB {
	public static int insert(Article article)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

       
        String query = 
                "INSERT INTO Art (UserName, Description, Photo) " + 
                "VALUES (?, ?, ?) "; 
        try
        {        
            ps = connection.prepareStatement(query);
            ps.setString(1, article.getUserName());
            ps.setString(2, article.getDescription());
            ps.setBytes(3, article.getImageBytes());
            //ps.S(4,  article.getDate());
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
	public static Article selectArticle(int articleID)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
       
        String query = "SELECT * " +
                "FROM art " +
                "LEFT OUTER JOIN comm " +
                "ON art.Id = comm.articleId "+
                "WHERE art.Id =?";           
        try
        {
            ps = connection.prepareStatement(query);
            ps.setInt(1, articleID);
            
            rs = ps.executeQuery();
            Article a = new Article();
            ArrayList<Comment> comments = new ArrayList<Comment>();
           
           
            while(rs.next())
            {
            	Comment c = new Comment();
            	
                a.setId(rs.getInt("Id"));
                a.setUserName(rs.getString("Description"));
                a.setDescription(rs.getString("UserName"));
                a.setImageBytes(rs.getBytes("Photo"));
                c.setComment(rs.getString("Comment"));
                c.setcId(rs.getInt("cId"));
                c.setUserName(rs.getString("commentUserName"));
                comments.add(c);
                a.setComments(comments);
              
               
            }
          
            return a;
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
	 public static ArrayList<Article> selectArticles()
	    {
	        ConnectionPool pool = ConnectionPool.getInstance();
	        Connection connection = pool.getConnection();
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        String query = "SELECT * FROM Art";
	        try
	        {
	            ps = connection.prepareStatement(query);
	            rs = ps.executeQuery();
	            ArrayList<Article> articles = new ArrayList<Article>();
	            while (rs.next())
	            {
	                Article a = new Article();
	                a.setId(rs.getInt("Id"));
	                a.setUserName(rs.getString("UserName"));
	                a.setDescription(rs.getString("Description"));
	                a.setImageBytes(rs.getBytes("Photo"));
	                articles.add(a);
	            }
	            return articles;
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

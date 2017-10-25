package sofa.model;

import java.util.ArrayList;
import java.util.Date;
import java.io.Serializable;

public class Article implements Serializable {
	
      /**
	 * 
	 */
	  private static final long serialVersionUID = 1L;
	  private int id;
	  private Date date;
      private String userName;
      private String description;
      private byte[] imageBytes;
      
     
	public  Date getDate() {
		return  date;
	}
	public void setDate(Date date) {
		this.date =  date;
	}
	private ArrayList<Comment> comments;
	  public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public byte[] getImageBytes() {
		return imageBytes;
	}
	public void setImageBytes(byte[] imageBytes) {
		this.imageBytes = imageBytes;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ArrayList<Comment> getComments() {
		return comments;
	}
	public void setComments(ArrayList<Comment> comments) {
		this.comments = comments;
	}
   
      
}

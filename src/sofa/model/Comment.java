package sofa.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Comment  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private byte[] imageBytes;
	private int cId;
	private String userName;
	private String comment;
	private ArrayList<Reply> replies;
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	

	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public byte[] getImageBytes() {
		return imageBytes;
	}
	public void setImageBytes(byte[] imageBytes) {
		this.imageBytes = imageBytes;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public ArrayList<Reply> getReplies() {
		return replies;
	}
	public void setReplies(ArrayList<Reply> replies) {
		this.replies = replies;
	}
	
	
	
	

}

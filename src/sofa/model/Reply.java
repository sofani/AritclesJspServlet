package sofa.model;

import java.io.Serializable;

public class Reply implements Serializable {
  
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private int rId;
    private String userName;
    private String reply;
    
    public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getrId() {
	   return rId;
    }
   public void setrId(int rId) {
	   this.rId = rId;
   }
   public String getReply() {
	   return reply;
   }
   public void setReply(String reply) {
	   this.reply = reply;
   }
   
}

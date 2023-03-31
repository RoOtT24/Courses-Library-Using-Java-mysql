package application;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Book extends Document{
	private String author ;
	private String edition;
	
	public Book(String dname, int quantity, String cid, String majorid) {
		super(dname, quantity, cid, majorid);
		// TODO Auto-generated constructor stub
	}
	public Book(ResultSet row) throws SQLException {
		super(row.getString("DocName") , row.getInt("Quantity") ,row.getString("CId"),row.getString("MajorId"));
		try {this.author = row.getString("Author") ; 
		this.edition = row.getString("Edition") ;
			
		}catch(SQLException e) {
			
		}

	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	@Override
	public String toString() {
		return "Book [" + (author != null ? "author=" + author + ", " : "")
				+ (edition != null ? "edition=" + edition : "") + "]";
	}
	

}
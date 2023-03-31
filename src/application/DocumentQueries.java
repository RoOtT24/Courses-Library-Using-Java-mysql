package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DocumentQueries {
	private SQLCursor sqlCursor = null;

	public DocumentQueries() {
		this.sqlCursor = SQLCursor.createSQLCursor();
	}

	public ArrayList<Document> getallDocuments() {
		ArrayList<Document> s = new ArrayList<>();
		String query = "select * from document" ;
		ResultSet rs = this.sqlCursor.executeQuery(query);
		try {if(rs != null)
			while (rs.next())
				s .add( new Document(rs) ) ; 
		} catch (SQLException e ){
			System.out.println("-E- Issue happens when checking for a sailor by id: " + e);
		}catch(Exception n) {}
		return s;
	}
	
	public void addDocument(String name , int Quantity , String courseid , String majorid) throws SQLException {
		
		String query = "INSERT INTO document (DocName, Quantity , CId , MajorId) VALUES (?,?,?,?)" ;
		Connection con =this.sqlCursor.getConnection();
		PreparedStatement preparedStmt = con.prepareStatement(query); 
		preparedStmt.setString (1, name);
	      preparedStmt.setInt (2, Quantity);
	      preparedStmt.setString   (3, courseid);
	      preparedStmt.setString(4, majorid);

	      // execute the preparedstatement
	      preparedStmt.execute();
	      
	      con.close();
	}
	
	

	
	public void addNote(String name , int Quantity , int numofchapters ,String teachername, String courseid , String majorid) throws SQLException {
		
		String query = "INSERT INTO notes(DocName, Quantity ,  numOfChapters ,CId ,MajorId)  VALUES (?,?,?,?,?)" ;
		Connection con =this.sqlCursor.getConnection();
		PreparedStatement preparedStmt = con.prepareStatement(query); 
		preparedStmt.setString (1, name);
	      preparedStmt.setInt (2, Quantity);
	      preparedStmt.setInt   (3, numofchapters);
	      preparedStmt.setString(4, courseid);
	      preparedStmt.setString(5, majorid);

	      // execute the preparedstatement
	      preparedStmt.execute();
	      
	      con.close();
	}
	
	public void addBook(String name , int Quantity ,  String author ,String edition, String courseid , String majorid) throws SQLException {
		
		String query = "INSERT INTO book(DocName, Quantity , Author , Edition ,CId , MajorId)  VALUES (?,?,?,?,?,?)" ;
		Connection con =this.sqlCursor.getConnection();
		PreparedStatement preparedStmt = con.prepareStatement(query); 
		preparedStmt.setString (1, name);
	      preparedStmt.setInt (2, Quantity);
	      preparedStmt.setString   (3, author);
	      preparedStmt.setString   (4, edition);
	      preparedStmt.setString(5, courseid);
	      preparedStmt.setString(6, majorid);

	      // execute the preparedstatement
	      preparedStmt.execute();
	      
	      con.close();
	}
	
	
	public Document getDocumentByName(String name) {
		Document s = null;
		String query = "select * from document d Where d.DocName = \'" + name+"\'";
		ResultSet rs = this.sqlCursor.executeQuery(query);
		try {if(rs != null)
			if (rs.next())
				s = new Document(rs);
		} catch (SQLException e) {
			System.out.println("-E- Issue happens when checking for a sailor by id: " + e);
		}
		return s;
	}

	public ArrayList<Document> getDocumentCid(String Cid) {
		ArrayList<Document> s = new ArrayList<>();
		String query = "select * from document d Where d.CId = \'" + Cid +"\'";
		ResultSet rs = this.sqlCursor.executeQuery(query);
		try {if(rs != null)
			while (rs.next())
				s .add( new Document(rs) ) ;
		} catch (SQLException e) {
			System.out.println("-E- Issue happens when checking for a sailor by id: " + e);
		}
		return s;
	}
	
	public Document getDocumentnameandCid(String name ,String Cid) {
		Document s = null ;
		String query = "select * from document d Where d.CourseId = \'" + Cid + "\' and d.DocName = \'"+ name + "\'";
		ResultSet rs = this.sqlCursor.executeQuery(query);
		try {if(rs != null)
			if (rs.next())
				s = new Document(rs)  ;
		} catch (SQLException e) {
			System.out.println("-E- Issue happens when checking for a sailor by id: " + e);
		}
		return s;
	}
	
	public Document getDocumentnameandtype(String name ,String type) {
		Document s = null ;
		String query = "select * from \'" + type + "\' d Where d.DocName = \'"+ name+"\'";
		ResultSet rs = this.sqlCursor.executeQuery(query);
		try {if(rs != null)
			if (rs.next())
				s = new Document(rs)  ;
		} catch (SQLException e) {
			System.out.println("-E- Issue happens when checking for a sailor by id: " + e);
		}
		return s;
	}
	 
	public ArrayList<Document> getDocumentcidandtype(String cid ,String type) {
		ArrayList<Document> s = new ArrayList<>() ;
		String query = "select * from " + type + " Where CId = \'"+ cid + "\'";
		ResultSet rs = this.sqlCursor.executeQuery(query);
		try {if(rs != null)
			while (rs.next())
				s .add( new Document(rs))  ;
		} catch (SQLException e) {
			System.out.println("-E- Issue happens when checking for a sailor by id: " + e);
		}
		return s;
	}
	
	public ArrayList<Document> getDocumentBytype(String type) {
		ArrayList<Document> s = new ArrayList<>();
		String query = "select * from "+type;
		ResultSet rs = this.sqlCursor.executeQuery(query);
		try {if(rs != null)
			while (rs.next())
				s .add( new Document(rs));
		} catch (SQLException e) {
			System.out.println("-E- Issue happens when checking for a sailor by sname: " + e);
		}
		return s;
	}
	
	

	public ArrayList<Document> getAllDocumentsStartWith(String startWith) {
		ArrayList<Document> documents = new ArrayList<Document>();
		String query = "select * from document s Where s.DocName like \'" + startWith + "%\'";
		ResultSet rs = this.sqlCursor.executeQuery(query);
		try {if(rs != null)
			while (rs.next())
				documents.add(new Document(rs));
		} catch (SQLException e) {
			System.out.println("-E- Issue happens when getting all sailors start with: " + e);
		}
		return documents;
	}
	
	public Document getDocumentbyall(String id, String name , String type) {
		Document s = null;
		ResultSet rs ;
		if(type.trim().equals("Notes")) {
			String query = "select * from notes n Where n.CourseId= \'" + id +"\' and n.DocName = \'"+ name+"\'" ;
			rs = this.sqlCursor.executeQuery(query);}
		else {
			String query = "select * from book n Where n.CourseId= \'" + id +"\' and n.DocName = \'"+ name+"\'" ;	
			rs = this.sqlCursor.executeQuery(query);}
		
		try {if(rs != null)
			if (rs.next())
				s = new Document(rs);
		} catch (SQLException e) {
			System.out.println("-E- Issue happens when checking for a sailor by id: " + e);
		}
		return s;
	}

	public void closeConnection() {
		this.sqlCursor.closeConnection();
	}
}


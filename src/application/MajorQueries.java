

package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MajorQueries {

	private SQLCursor sqlCursor = null;

	public MajorQueries() {
		this.sqlCursor = SQLCursor.createSQLCursor();
	}


	public ArrayList<Major> getallMajors() {
		ArrayList<Major> s = new ArrayList<>();
		String query = "select * from major" ;
		ResultSet rs = this.sqlCursor.executeQuery(query);
		try {if(rs != null)
			while (rs.next()) {//System.out.println(new Major(rs));
				s .add( new Major(rs) ) ;} 
		} catch (SQLException e) {
			System.out.println("-E- Issue happens when checking for a sailor by id: " + e);
		}
		
		return s;
	}

	
public void addMajor(String id , String name ,int credithours) throws SQLException {
		
		String query = "INSERT INTO major (MajorId, MajorName , CreditHours) VALUES (?,?,?)" ;
		Connection con =this.sqlCursor.getConnection();
		PreparedStatement preparedStmt = con.prepareStatement(query); 
		preparedStmt.setString (1, id);
	      preparedStmt.setString (2, name);
	      preparedStmt.setInt   (3, credithours);
	      
	}
	
	public Major getMajorByid(String id) {
		Major s = null;
		String query = "select * from major m Where m.MajorId = \'" + id+"\'";
		ResultSet rs = this.sqlCursor.executeQuery(query);
		try {if(rs != null)
			if (rs.next())
				s = new Major(rs);
		} catch (SQLException e) {
			System.out.println("-E- Issue happens when checking for a Student by id: " + e);
		}
		return s;
	}
	
	public Major getMajorByidandname (String id , String name) {
		Major s = null;
		String query = "select * from major m Where m.MajorId = \'" + id + "\' and m.MajorName = \'"+ name+"\'";
		ResultSet rs = this.sqlCursor.executeQuery(query);
		try {if(rs != null)
			if (rs.next())
				s = new Major(rs);
		} catch (SQLException e) {
			System.out.println("-E- Issue happens when checking for a Student by id: " + e);
		}
		return s;
	}

	public Major getMajorbyall(String id , String name , int hours) {
		Major s = null;
		String query = "select * from major m Where m.MajorId = \'" + id+ "\' and m.MajorName = \'"+name + "\' and m.rCreditHours = "+hours;
		ResultSet rs = this.sqlCursor.executeQuery(query);
		try {if(rs != null)
			if (rs.next())
				s = new Major(rs);
		} catch (SQLException e) {
			System.out.println("-E- Issue happens when checking for a Student by id: " + e);
		}
		return s;
	}

	public ArrayList<Major> getMajorByname(String name) {
		ArrayList<Major> s = new ArrayList<Major>();
		String query = "select * from major m Where m.MajorName = \'"+name+"\'";
		ResultSet rs = this.sqlCursor.executeQuery(query);
		try {if(rs != null)
			while (rs.next())
				s .add(new Major(rs));
		} catch (SQLException e) {
			System.out.println("-E- Issue happens when checking for a Student by sname: " + e);
		}
		return s;
	}
	
	
	public ArrayList<Major> getMajorByhours(int hours) {
		ArrayList<Major> s = new ArrayList<Major>();
		String query = "select * from major m Where m.CreditHours = "+hours;
		ResultSet rs = this.sqlCursor.executeQuery(query);
		try {if(rs != null)
			while (rs.next())
				s .add(new Major(rs));
		} catch (SQLException e) {
			System.out.println("-E- Issue happens when checking for a Student by sname: " + e);
		}
		return s;
	}

	public ArrayList<Major> getAllMajorsStartWith(String startWith) {
		ArrayList<Major> major = new ArrayList<>();
		String query = "select * from major m Where m.MajorName like \'" + startWith + "%\'";
		ResultSet rs = this.sqlCursor.executeQuery(query);
		try {if(rs != null)
			while (rs.next())
				major.add(new Major(rs));
		} catch (SQLException e) {
			System.out.println("-E- Issue happens when getting all sailors start with: " + e);
		}
		return major;
	}
	
	public ArrayList<Major> getAllMajorsnameandhours(String name , int hours) {
		ArrayList<Major> major = new ArrayList<>();
		String query = "select * from major m Where m.MajorName = \'" + name + "\' and m.CreditHours = " +hours;
		ResultSet rs = this.sqlCursor.executeQuery(query);
		try {if(rs != null)
			while (rs.next())
				major.add(new Major(rs));
		} catch (SQLException e) {
			System.out.println("-E- Issue happens when getting all sailors start with: " + e);
		}
		return major;
	}


	public Major getAllMajorsidandhours(String id , int hours) {
		Major major = null ;
		String query = "select * from major m Where m.MajorId = \'" + id + "\' and m.CreditHours = " +hours;
		ResultSet rs = this.sqlCursor.executeQuery(query);
		try {if(rs != null)
			if (rs.next())
				major = new Major(rs);
		} catch (SQLException e) {
			System.out.println("-E- Issue happens when getting all sailors start with: " + e);
		}
		return major;
	}

	
	public void closeConnection() {
		this.sqlCursor.closeConnection();
	}
}
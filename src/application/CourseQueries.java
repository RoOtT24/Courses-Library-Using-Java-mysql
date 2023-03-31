
package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CourseQueries {

	private SQLCursor sqlCursor = null;

	public CourseQueries() {
		this.sqlCursor = SQLCursor.createSQLCursor();
	}
	
	public ArrayList<Course> getallCourses() {
		ArrayList<Course> s = new ArrayList<>();
		String query = "select * from course" ;
		ResultSet rs = this.sqlCursor.executeQuery(query);
		try {if(rs != null)
			while (rs.next())
				s .add( new Course(rs) ) ; 
		} catch (SQLException e) {
			System.out.println("-E- Issue happens when checking for a sailor by id: " + e);
		}
		return s;
	}


	public Course getAllCoursesidandcapacity(String id , int capacity) {
		Course course = null ;
		String query = "select * from course c where c.CId = \'" + id + "\' and c.Capacity = " +capacity;
		ResultSet rs = this.sqlCursor.executeQuery(query);
		try {if(rs != null)
			if (rs.next())
				course = new Course(rs);
		} catch (SQLException e) {
			System.out.println("-E- Issue happens when getting all sailors start with: " + e);
		}
		return course;
	}

	
	public Course getCourseByidandname (String id , String name) {
		Course s = null;
		String query = "select * from course c where c.CId = \'" + id + "\' and c.CName = \'"+ name+"\'";
		ResultSet rs = this.sqlCursor.executeQuery(query);
		try {if(rs != null)
			if (rs.next())
				s = new Course(rs);
		} catch (SQLException e) {
			System.out.println("-E- Issue happens when checking for a Student by id: " + e);
		}
		return s;
	}

	
	public Course getCoursebyall(String id , String name , int capacity) {
		Course s = null;
		String query = "select * from course c where c.CId = \'" + id+ "\' and c.CName = \'"+name + "\' and c.CreditHours = "+capacity;
		ResultSet rs = this.sqlCursor.executeQuery(query);
		try {if(rs != null)
			if (rs.next())
				s = new Course(rs);
		} catch (SQLException e) {
			System.out.println("-E- Issue happens when checking for a Student by id: " + e);
		}
		return s;
	}
	
	public Course getCourseByid(String id) {
		Course s = null;
		String query = "select * from course c where c.CID = \'" + id+"\'";
		ResultSet rs = this.sqlCursor.executeQuery(query);
		try {if(rs != null)
			if (rs.next())
				s = new Course(rs);
		} catch (SQLException e) {
			System.out.println("-E- Issue happens when checking for a Course by id: " + e);
		}
		return s;
	}

	public ArrayList<Course> getCourseByname(String name) {
		ArrayList<Course> s = new ArrayList<>();
		String query = "select * from course c where s.CName = \'"+name+"\'";
		ResultSet rs = this.sqlCursor.executeQuery(query);
		try {if(rs != null)
			while (rs.next())
				s .add(new Course(rs));
		} catch (SQLException e) {
			System.out.println("-E- Issue happens when checking for a Student by sname: " + e);
		}
		return s;
	}

	public ArrayList<Course> getCourseBycapacity(int capacity) {
		ArrayList<Course> s = new ArrayList<>();
		String query = "select * from course c where s.Capacity = "+capacity ;
		ResultSet rs = this.sqlCursor.executeQuery(query);
		try {if(rs != null)
			while (rs.next())
				s .add(new Course(rs));
		} catch (SQLException e) {
			System.out.println("-E- Issue happens when checking for a Student by sname: " + e);
		}
		return s;
	}

	
	public ArrayList<Course> getAllCoursesStartWith(String startWith) {
		ArrayList<Course> courses = new ArrayList<>();
		String query = "select * from course c where c.CName like \'" + startWith + "%\'";
		ResultSet rs = this.sqlCursor.executeQuery(query);
		try {if(rs != null)
			while (rs.next())
				courses.add(new Course(rs));
		} catch (SQLException e) {
			System.out.println("-E- Issue happens when getting all sailors start with: " + e);
		}
		return courses;
	}
	
	public ArrayList<Course> getAllCoursesnameandcapacity(String name , int capacity) {
		ArrayList<Course> courses = new ArrayList<>();
		String query = "select * from course c where c.CName = \'" + name + "\' and c.Capacity = "+ capacity ;
		ResultSet rs = this.sqlCursor.executeQuery(query);
		try {if(rs != null)
			while (rs.next())
				courses.add(new Course(rs));
		} catch (SQLException e) {
			System.out.println("-E- Issue happens when getting all sailors start with: " + e);
		}
		return courses;
	}


public void addCourse(String id , String name , int capacity , String majorid) throws SQLException {
		
		String query = "INSERT INTO course (CId, CName , Capacity , MajorId)  VALUES (?,?,?,?)" ;
		Connection con =this.sqlCursor.getConnection();
		PreparedStatement preparedStmt = con.prepareStatement(query); 
		preparedStmt.setString (1, id);
	      preparedStmt.setString (2, name);
	      preparedStmt.setInt   (3, capacity);
	      preparedStmt.setString(4, majorid);

	      // execute the preparedstatement
	      preparedStmt.execute();
	      
	      con.close();
	}
	
	
	public void closeConnection() {
		this.sqlCursor.closeConnection();
	}
}


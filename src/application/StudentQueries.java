
package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentQueries {

	private SQLCursor sqlCursor = null;

	public StudentQueries() {
		this.sqlCursor = SQLCursor.createSQLCursor();
	}

	public ArrayList<Student> getallStudents() {
		ArrayList<Student> s = new ArrayList<>();
		String query = "select * from student" ;
		ResultSet rs = this.sqlCursor.executeQuery(query);
		try {if(rs != null)
			while (rs.next())
				s .add( new Student(rs) ) ; 
		} catch (SQLException e) {
			System.out.println("-E- Issue happens when checking for a sailor by id: " + e);
		}
		return s;
	}

public void addOwns(int sid , String name , String courseid , String majorid) throws SQLException {
		
		String query = "INSERT INTO owns (SID, DocName , CId , MajorId) VALUES (?,?,?,?)" ;
		Connection con =this.sqlCursor.getConnection();
		PreparedStatement preparedStmt = con.prepareStatement(query); 
		preparedStmt.setInt (1, sid);System.out.println(sid);
	      preparedStmt.setString (2, name);
	      preparedStmt.setString   (3, courseid);
	      preparedStmt.setString(4, majorid);

	      // execute the preparedstatement
	      preparedStmt.execute();
	      
	      con.close();
	}
	
	public Student getStudentByidandname (int id , String name) {
		Student s = null;
		String query = "select * from student s where s.SId = " + id  + " and c.CName = \'"+ name+"\'";
		ResultSet rs = this.sqlCursor.executeQuery(query);
		try {if(rs != null)
			if (rs.next())
				s = new Student(rs);
		} catch (SQLException e) {
			System.out.println("-E- Issue happens when checking for a Student by id: " + e);
		}
		return s;
	}

	
	public Student getStudentbyall(int id , String name , String address , String email) {
		Student s = null;
		String query = "select * from student s where s.SId = " + id + " and s.SName = \'"+name + "\' and s.Address = \'"+ address + "\' and s.Email = \'" + email +"\'" ;
		ResultSet rs = this.sqlCursor.executeQuery(query);
		try {if(rs != null)
			if (rs.next())
				s = new Student(rs);
		} catch (SQLException e) {
			System.out.println("-E- Issue happens when checking for a Student by id: " + e);
		}
		return s;
	}
	
	public Student getStudentbyidandnameandaddress(int id , String name , String address ) {
		Student s = null;
		String query = "select * from student s where s.SId = " + Integer.toString(id) + " and s.SName = \'"+name + "\' and s.Address = \'"+ address+"\'" ;
		ResultSet rs = this.sqlCursor.executeQuery(query);
		try {
			if (rs.next())
				s = new Student(rs);
		} catch (SQLException e) {
			System.out.println("-E- Issue happens when checking for a Student by id: " + e);
		}
		return s;

	}


	public Student getStudentbynameandaddressandemail( String name , String address , String email ) {
		Student s = null;
		String query = "select * from student s where s.SName = \'"+name + "\' and s.Address = \'"+ address + "\' and s.Email = \'"+ email +"\'";
		ResultSet rs = this.sqlCursor.executeQuery(query);
		try {if(rs != null)
			if (rs.next())
				s = new Student(rs);
		} catch (SQLException e) {
			System.out.println("-E- Issue happens when checking for a Student by id: " + e);
		}
		return s;

	}



	public Student getStudentbynameandaddress( String name , String address  ) {
		Student s = null;
		String query = "select * from student s where s.SName = \'"+name + "\' and s.Address = \'"+ address+"\'" ;
		ResultSet rs = this.sqlCursor.executeQuery(query);
		try {if(rs != null)
			if (rs.next())
				s = new Student(rs);
		} catch (SQLException e) {
			System.out.println("-E- Issue happens when checking for a Student by id: " + e);
		}
		return s;

	}
	
	public Student getStudentbynameandemail( String name , String email  ) {
		Student s = null;
		String query = "select * from student s where s.SName = \'"+name + "\' and s.Email = \'"+ email +"\'";
		ResultSet rs = this.sqlCursor.executeQuery(query);
		try {if(rs != null)
			if (rs.next())
				s = new Student(rs);
		} catch (SQLException e) {
			System.out.println("-E- Issue happens when checking for a Student by id: " + e);
		}
		return s;

	}
	

	public ArrayList<Student> getStudentbyaddressandemail( String address , String email  ) {
		ArrayList<Student> s = new ArrayList<Student>();
		String query = "select * from student s where s.Address = \'"+address + "\' and s.Email = \'"+ email+"\'" ;
		ResultSet rs = this.sqlCursor.executeQuery(query);
		try {if(rs != null)
			while (rs.next())
				s .add( new Student(rs));
		} catch (SQLException e) {
			System.out.println("-E- Issue happens when checking for a Student by id: " + e);
		}
		return s;

	}

	
	public ArrayList<Student> getStudentbyaddress( String address ) {
		ArrayList<Student> s = new ArrayList<Student>();
		String query = "select * from student s where s.Address = \'"+address +"\'";
		ResultSet rs = this.sqlCursor.executeQuery(query);
		try {if(rs != null)
			while (rs.next())
				s .add( new Student(rs));
		} catch (SQLException e) {
			System.out.println("-E- Issue happens when checking for a Student by id: " + e);
		}
		return s;

	}
	
	public ArrayList<Student> getStudentbyemail( String email) {
		ArrayList<Student> s = new ArrayList<Student>();
		String query = "select * from student s where s.Email = \'"+email+"\'" ;
		ResultSet rs = this.sqlCursor.executeQuery(query);
		try {if(rs != null)
			while (rs.next())
				s .add( new Student(rs));
		} catch (SQLException e) {
			System.out.println("-E- Issue happens when checking for a Student by id: " + e);
		}
		return s;

	}
	
	public void addStudent(int id , String name , String address , String email) throws SQLException {
		
		String query = "insert student (SID , Sname , Address ,Email) VALUES (? ,? , ? ,?)" ;
		//this.sqlCursor.executeQuery(query) ;
		Connection con =this.sqlCursor.getConnection();
		PreparedStatement preparedStmt = con.prepareStatement(query); 
		preparedStmt.setInt (1, id);
	      preparedStmt.setString (2, name);
	      preparedStmt.setString   (3, address);
	      preparedStmt.setString(4, email);

	      // execute the preparedstatement
	      preparedStmt.execute();
	      
	      con.close();
	}
	
	public Student getStudentbyidandnameandemail(int id , String name , String email ) {
		Student s = null;
		String query = "select * from student s where s.SId = " + id + " and s.SName = \'"+name + "\' and s.Email = \'"+ email +"\'" ;
		ResultSet rs = this.sqlCursor.executeQuery(query);
		try {if(rs != null)
			if (rs.next())
				s = new Student(rs);
		} catch (SQLException e) {
			System.out.println("-E- Issue happens when checking for a Student by id: " + e);
		}
		return s;

	}
	

	public Student getStudentbyidandaddressandemail(int id ,  String address,String email ) {
		Student s = null;
		String query = "select * from student s where s.SId = " + id+ " and s.Email = \'"+ email + "\' and s.Address = \'" + address +"\'";
		ResultSet rs = this.sqlCursor.executeQuery(query);
		try {if(rs != null)
			if (rs.next())
				s = new Student(rs);
		} catch (SQLException e) {
			System.out.println("-E- Issue happens when checking for a Student by id: " + e);
		}
		return s;

	}
	
	public Student getStudentbyidandaddress(int id ,  String address) {
		Student s = null;
		String query = "select * from student s where s.SId = " + id+  " and s.Address = \'" + address +"\'";
		ResultSet rs = this.sqlCursor.executeQuery(query);
		try {if(rs != null)
			if (rs.next())
				s = new Student(rs);
		} catch (SQLException e) {
			System.out.println("-E- Issue happens when checking for a Student by id: " + e);
		}
		return s;

	}
	
	public Student getStudentbyidandemail(int id ,  String email) {
		Student s = null;
		String query = "select * from student s where s.SId = " + id+  " and s.Email = \'" + email +"\'";
		ResultSet rs = this.sqlCursor.executeQuery(query);
		try {if(rs != null)
			if (rs.next())
				s = new Student(rs);
		} catch (SQLException e) {
			System.out.println("-E- Issue happens when checking for a Student by id: " + e);
		}
		return s;

	}
	
	public Student getStudentByid(int id) {
		Student s = null;
		String query = "select * from student s where s.SID = " + id;
		ResultSet rs = this.sqlCursor.executeQuery(query);
		try {if(rs != null)
			if (rs.next())
				s = new Student(rs);
		} catch (SQLException e) {
			System.out.println("-E- Issue happens when checking for a Student by id: " + e);
		}
		return s;
	}

	public Student getStudentByname(String name) {
		Student s = null;
		String query = "select * from student s where s.Sname = \'"+name +"\'";
		ResultSet rs = this.sqlCursor.executeQuery(query);
		try {if(rs != null)
			if (rs.next())
				s = new Student(rs);
		} catch (SQLException e) {
			System.out.println("-E- Issue happens when checking for a Student by sname: " + e);
		}
		return s;
	}

	public ArrayList<Student> getAllStudentsStartWith(String startWith) {
		ArrayList<Student> students = new ArrayList<>();
		String query = "select * from student s where s.sname like \'" + startWith + "%\'";
		ResultSet rs = this.sqlCursor.executeQuery(query);
		try {if(rs != null)
			while (rs.next())
				students.add(new Student(rs));
		} catch (SQLException e) {
			System.out.println("-E- Issue happens when getting all sailors start with: " + e);
		}
		return students;
	}
	
	public ArrayList<Student> getAllStudentsinaddress(String startWith) {
		ArrayList<Student> students = new ArrayList<>();
		String query = "select * from student s where s.Address = \'" + startWith +"\'" ;
		ResultSet rs = this.sqlCursor.executeQuery(query);
		try {if(rs != null)
			while (rs.next())
				students.add(new Student(rs));
		} catch (SQLException e) {
			System.out.println("-E- Issue happens when getting all sailors start with: " + e);
		}
		return students;
	}
	public ArrayList<Student> getAllStudentsemail(String startWith) {
		ArrayList<Student> students = new ArrayList<>();
		String query = "select * from student s where s.Email = \'" + startWith +"\'" ;
		ResultSet rs = this.sqlCursor.executeQuery(query);
		try {if(rs != null)
			while (rs.next())
				students.add(new Student(rs));
		} catch (SQLException e) {
			System.out.println("-E- Issue happens when getting all sailors start with: " + e);
		}
		return students;
	}
	
	public ArrayList<Student> getAllStudentsemailandaddress(String email , String address) {
		ArrayList<Student> students = new ArrayList<>();
		String query = "select * from student s where s.Email = \'" + email + "\' and s.Address = \'"+address+"\'" ;
		ResultSet rs = this.sqlCursor.executeQuery(query);
		try {if(rs != null)
			while (rs.next())
				students.add(new Student(rs));
		} catch (SQLException e) {
			System.out.println("-E- Issue happens when getting all sailors start with: " + e);
		}
		return students;
	}
	
	
	
	public void closeConnection() {
		this.sqlCursor.closeConnection();
	}

	
}


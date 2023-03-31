package application;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OwnQueiries {
	private SQLCursor sqlCursor = null;

	public OwnQueiries() {
		this.sqlCursor = SQLCursor.createSQLCursor();
	}

	// only for search
	// insertion is on studentQueries
	public ArrayList<Own> getbysid(int sid) {
		ArrayList<Own> s = new ArrayList<>();
		String query = "select * from owns o Where o.SID = " + sid;
		ResultSet rs = this.sqlCursor.executeQuery(query);
		try {
			if (rs != null)
				while (rs.next())
					s.add(new Own(rs));
		} catch (SQLException e) {
			System.out.println("-E- Issue happens when checking for a sailor by id: " + e);
		}
		return s;
	}

	public ArrayList<Own> getbydocname(String dname) {
		ArrayList<Own> s = new ArrayList<>();
		String query = "select * from owns o Where o.DocName = \'" + dname+"\'";
		ResultSet rs = this.sqlCursor.executeQuery(query);
		try {
			if (rs != null)
				while (rs.next())
					s.add(new Own(rs));
		} catch (SQLException e) {
			System.out.println("-E- Issue happens when checking for a sailor by id: " + e);
		}
		return s;
	}

	public ArrayList<Own> getbyboth(int id, String dname) {
		ArrayList<Own> s = new ArrayList<>();
		String query = "select * from owns o Where o.DocName = \'" + dname + "\' and o.SID = " + id;
		ResultSet rs = this.sqlCursor.executeQuery(query);
		try {
			if (rs != null)
				while (rs.next())
					s.add(new Own(rs));
		} catch (SQLException e) {
			System.out.println("-E- Issue happens when checking for a sailor by id: " + e);
		}
		return s;
	}

	public ArrayList<Own> getallStudents() {
		ArrayList<Own> s = new ArrayList<>();
		String query = "select * from owns";
		ResultSet rs = this.sqlCursor.executeQuery(query);
		try {
			if (rs != null)
				while (rs.next())
					s.add(new Own(rs));
		} catch (SQLException e) {
			System.out.println("-E- Issue happens when checking for a sailor by id: " + e);
		}
		return s;
	}

}

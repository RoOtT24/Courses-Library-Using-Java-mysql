package application;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Notes extends Document {

	private int numofchapters;
	private String instructorname;

	public Notes(String dname, int quantity, String cid, int numofchapters, String instructorname,String majorid) {
		super(dname, quantity, cid, majorid);
		this.numofchapters = numofchapters;
		this.instructorname = instructorname;
	}
	public Notes(ResultSet row) throws SQLException {
		super(row.getString("DocName") , row.getInt("Quantity") ,row.getString("CId"),row.getString("MajorId"));
		try {
			this.instructorname = row.getString("InstructorName") ;
			this.numofchapters = row.getInt("numOfChapters") ;
		} catch (SQLException e) {
			System.out.println();
		}}

	public int getNumofchapters() {
		return numofchapters;
	}

	public void setNumofchapters(int numofchapters) {
		this.numofchapters = numofchapters;
	}

	public String getInstructorname() {
		return instructorname;
	}

	public void setInstructorname(String instructorname) {
		this.instructorname = instructorname;
	}

	@Override
	public String toString() {
		return "Notes [numofchapters=" + numofchapters + ", "
				+ (instructorname != null ? "instructorname=" + instructorname : "") + "]";
	}

}

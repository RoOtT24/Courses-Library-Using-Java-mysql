package application;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Course {

	private String courseid ;
	private String coursename ;
	private int capacity ;
	private String majorid ;
	public Course(String courseid, String coursename, int capacity, String majorid) {
		super();
		this.courseid = courseid;
		this.coursename = coursename;
		this.capacity = capacity;
		this.majorid = majorid;
	}
	
	public Course(ResultSet row) {
		try {
			this.courseid = row.getString("CId");
			this.coursename = row.getString("CName");
			this.capacity = row.getInt("Capacity");
			this.majorid = row.getString("MajorId");
		} catch (SQLException e) {
			System.out.println();
		}
	}
	
	public String getCourseid() {
		return courseid;
	}
	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getMajorid() {
		return majorid;
	}
	public void setMajorid(String majorid) {
		this.majorid = majorid;
	}
	@Override
	public String toString() {
		return "Course [" + (courseid != null ? "courseid=" + courseid + ", " : "")
				+ (coursename != null ? "coursename=" + coursename + ", " : "") + "capacity=" + capacity + ", "
				+ (majorid != null ? "majorid=" + majorid : "") + "]";
	}
	
	
}

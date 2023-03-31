package application;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Major {

	private String mid ;
	private String mname;
	private int chours ;
	public Major(String mid, String mname, int chours) {
		super();
		this.mid = mid;
		this.mname = mname;
		this.chours = chours;
	}
	
	public Major(ResultSet row) {
		try {
			this.mid = row.getString("MajorId");
			this.mname = row.getString("MajorName");
			this.chours = row.getInt("CreditHours");
		} catch (SQLException e) {
			System.out.println();
		}
	}
	
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public int getChours() {
		return chours;
	}
	public void setChours(int chours) {
		this.chours = chours;
	}
	@Override
	public String toString() {
		return "Major [" + (mid != null ? "mid=" + mid + ", " : "") + (mname != null ? "mname=" + mname + ", " : "")
				+ "chours=" + chours + "]";
	}
	
	
}

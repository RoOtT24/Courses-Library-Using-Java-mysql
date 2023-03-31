package application;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Student {

	private int sid;
	private String sname;
	private String address;
	private String email;
	private ArrayList<String> dname;
	
	
	public Student(ResultSet row) {
		try {
			this.sname = row.getString("Sname");
			this.sid = row.getInt("SID");
			this.address = row.getString("Address");
			this.email = row.getString("Email");
		} catch (SQLException e) {
			System.out.println();
		}
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ArrayList<String> getDname() {
		return dname;
	}

	public void setDname(ArrayList<String> dname) {
		this.dname = dname;
	}

	public Student(int sid, String sname, String address, String email) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.address = address;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", " + (sname != null ? "sname=" + sname + ", " : "")
				+ (address != null ? "address=" + address + ", " : "") + (email != null ? "email=" + email + ", " : "")
				+ (dname != null ? "dname=" + dname : "") + "]";
	}

}

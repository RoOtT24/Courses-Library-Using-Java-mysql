package application;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Own {
	private int sid;
	private String Docname;
	private String Cid;
	private String majorid;

	public Own(int sid, String docname, String cid, String majorid) {
		super();
		this.sid = sid;
		Docname = docname;
		Cid = cid;
		this.majorid = majorid;
	}

	public Own(ResultSet row) {
		try {
			this.sid = row.getInt("SID");
			this.Docname = row.getString("DocName");
			this.Cid = row.getString("CID");
			this.majorid = row.getString("MajorId");
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

	public String getDocname() {
		return Docname;
	}

	public void setDocname(String docname) {
		Docname = docname;
	}

	public String getCid() {
		return Cid;
	}

	public void setCid(String cid) {
		Cid = cid;
	}

	public String getMajorid() {
		return majorid;
	}

	public void setMajorid(String majorid) {
		this.majorid = majorid;
	}

	@Override
	public String toString() {
		return "Own [sid=" + sid + ", " + (Docname != null ? "Docname=" + Docname + ", " : "")
				+ (Cid != null ? "Cid=" + Cid + ", " : "") + (majorid != null ? "majorid=" + majorid : "") + "]";
	}

}

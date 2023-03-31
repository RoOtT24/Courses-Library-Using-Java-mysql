package application;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Document {

	private String dname ;
	private int quantity ;
	private String cid ;
	private String majorid;
	private ArrayList<String> sid;
	public ArrayList<String> getSid() {
		return sid;
	}
	public void setSid(ArrayList<String> sid) {
		this.sid = sid;
	}
	
	public String getMajorid() {
		return majorid;
	}
	public void setMajorid(String majorid) {
		this.majorid = majorid;
	}
	public Document(String dname, int quantity, String cid, String majorid) {
		super();
		this.dname = dname;
		this.quantity = quantity;
		this.cid = cid;
		this.majorid = majorid;
	}
	public Document(ResultSet row) {
		try {
			this.dname = row.getString("DocName");
			this.cid = row.getString("CId");
			this.quantity = row.getInt("Quantity");
			this.majorid = row.getString("MajorId");
		} catch (SQLException e) {
			System.out.println();
		}
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	@Override
	public String toString() {
		return "Document [" + (dname != null ? "dname=" + dname + ", " : "") + "quantity=" + quantity + ", "
				+ (cid != null ? "cid=" + cid : "") + "]";
	}
	
	
}

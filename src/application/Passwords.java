package application;

public class Passwords {

	private String sid ;
	private String password;
	public Passwords(String sid, String password) {
		super();
		this.sid = sid;
		this.password = password;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Passwords [sid=" + sid + ", " + (password != null ? "password=" + password : "") + "]";
	}
	
}

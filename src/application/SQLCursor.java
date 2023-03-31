package application;

import java.sql.*;

public class SQLCursor {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String db = "x";
	private String localhost = "jdbc:mysql://127.0.0.1:3306/" + db;
	private String username = "root";
	private String password = "Bellerin123";
	private Connection conn = null;

	private static SQLCursor classObj = null;

	private SQLCursor() {
	}

	public static SQLCursor createSQLCursor() {
		if (classObj == null)
			classObj = new SQLCursor();
		return classObj;
	}

	public Connection getConnection() throws SQLException {
		return this.conn = DriverManager.getConnection(this.localhost, this.username, this.password);
	}
	private void establishConnection() {
		try {
			if (this.conn == null) {
				Class.forName(this.driver);
				this.conn = DriverManager.getConnection(this.localhost, this.username, this.password);
			}
		} catch (Exception e) {
			System.out.println("-E- An issue happens while establishing connection: " + e);
			this.conn = null;
		}
	}

	public void closeConnection() {
		if (this.conn != null) {
			try {
				this.conn.close();
			} catch (Exception e) {
				System.out.println("-E- An issue happens while closing connection: " + e);
				this.conn = null;
			}
		}
	}

	public ResultSet executeQuery(String query) {
		ResultSet rs = null;
		this.establishConnection();
		try {
			this.conn = DriverManager.getConnection(this.localhost, this.username, this.password);
		} catch (SQLException e1) {
			System.out.println("-E- An issue happens while establishing connection: " + e1);
			this.conn = null;
		}
		if (this.conn != null) {
			try {
				Statement stmt = this.conn.createStatement();
				rs = stmt.executeQuery(query);
			} catch (Exception e) {
				System.out.println("-E- An issue happens while executing query \'" + query + "\': " + e);
				rs = null;
			}
		}
		return rs;
	}
}

package andy.test.db;

/**
 * traditional jdbc
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqliteTest1 {
	public static void main(String[] args) {
//		queryDb1();
		queryDb2();
	}

	private static void queryDb2() {
		String url = "jdbc:sqlite:/c:/users/andy/arifdm.db";
		String driver = "org.sqlite.JDBC";
		String username = "";
		String password = "";
		String sql = "select * from model";
//		try {
//			Class.forName(driver);
//		} catch (ClassNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		try(Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()){
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()){
				System.out.println(rs.getString("modelName"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void queryDb1() {
		String sql = "select * from COMPANY";
		String path = SqliteTest1.class.getResource("/andy/test/db/tempdb.db").getPath();
		// display data
		try(Connection conn = DriverManager.getConnection("jdbc:sqlite:" + path);Statement stmt = conn.createStatement()){
			ResultSet rs = stmt.executeQuery(sql);
			while ( rs.next()){
				System.out.println(rs.getString("id") + " " + rs.getString("name") + " " +rs.getString("age"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// insert data
		String addSql = "insert into company (id, name, age) values (7, 'Andy', '35')";
		try(Connection conn = DriverManager.getConnection("jdbc:sqlite:" + path); Statement stmt = conn.createStatement()){
			stmt.executeUpdate(addSql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// display data
		try(Connection conn = DriverManager.getConnection("jdbc:sqlite:" + path);Statement stmt = conn.createStatement()){
			ResultSet rs = stmt.executeQuery(sql);
			while ( rs.next()){
				System.out.println(rs.getString("id") + " " + rs.getString("name") + " " +rs.getString("age"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

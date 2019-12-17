package DungChung;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtils {
	public Connection cn;

	// Import liblary from PHUC/HuongDoiTuong/lib to WEB-INF/lib
	public void KetNoi() throws Exception {
		// Xac dinh HQTCSDL
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		// Ket noi vao CSDL;
		String url = "jdbc:sqlserver://localhost;user=java-web;password=123456;databaseName=QlSach";
		cn = DriverManager.getConnection(url);
		System.out.println("Da ket noi");
	}
}

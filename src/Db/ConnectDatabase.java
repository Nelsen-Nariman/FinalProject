package Db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {

	public ConnectDatabase() {

	}

	public static Connection connectDatabase() {

		Connection connection = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // pastiin Driver nya ada dan utk inisialisasi si Driver
			// port 3306 -> bisa dilihat di xampp control panel punya mysql, kalau beda di
			// sesuaiin aja
			// learningjdbc -> nama database, disesuain aja
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/finalproject?useLegacyDatetimeCode=false&serverTimezone=UTC", "root",
					"");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (connection == null) {
			System.out.println("errorr");
		} else {
			System.out.println("success");
		}

		return connection;
	}

}


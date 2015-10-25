package mysqldao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlDaoConexaoBD{
	 
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public static Connection conectar() throws SQLException {
		return DriverManager
				.getConnection("jdbc:mysql://localhost:3306/projeto?user=alunos&password=alunos");
	}
	
	public static void desconectar(Connection conn) throws SQLException {
		conn.close();
	}
}


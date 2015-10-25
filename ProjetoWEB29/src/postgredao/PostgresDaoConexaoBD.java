package postgredao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresDaoConexaoBD{
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public Connection conectar() throws SQLException {
		return DriverManager
				.getConnection("jdbc:postgresql://localhost/consultoria?user=alunos&password=alunos");
	}
}


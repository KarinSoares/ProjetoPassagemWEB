package mysqldao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.ClienteDAO;
import model.Cliente;

public class MySqlDaoClienteDAO implements ClienteDAO
{
	public void incluir(Cliente cliente) {
		
		String sqlInsert = "INSERT INTO cliente(cod_cliente, id_tipo,tratamento,nome," 
				+ "sobrenome, data_nascimento) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement stm = null;
		try {
			conn = MySqlDaoConexaoBD.conectar();			
			stm = conn.prepareStatement(sqlInsert);
			stm.setInt(1, cliente.getCodigo());
			stm.setInt(2, cliente.getTipoCliente());
			stm.setString(3, cliente.getTratamento());
			stm.setString(4, cliente.getNome());
			stm.setString(5, cliente.getSobrenome());
			stm.setString(6, cliente.getDataNascimento());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
		} finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
			}
		}
	}	
}


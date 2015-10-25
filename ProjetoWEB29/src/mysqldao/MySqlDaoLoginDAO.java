package mysqldao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.LoginDAO;

public class MySqlDaoLoginDAO implements LoginDAO {
	
	public void desconectar(Connection conn) throws SQLException {
		conn.close();
	}

	public boolean validaLogin(String usuario, String senha) {
		String query = "select * from `projeto`.`tb_users` where NOME_USUARIO=? and SENHA_USUARIO=?";
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = MySqlDaoConexaoBD.conectar();
			pst = conn.prepareStatement(query);
			pst.setString(1, usuario);
			pst.setString(2, senha);
			rs = pst.executeQuery();
			if(rs.next()){
				return true;
			}
		} catch (SQLException sqe) {
			sqe.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException sqe) {
					sqe.printStackTrace();
				}
			}
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException sqe) {
					sqe.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					desconectar(conn);
				} catch (SQLException sqe) {
					sqe.printStackTrace();
				}
			}
		}
		return false;
	}
}


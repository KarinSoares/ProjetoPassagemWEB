package mysqldao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import dao.AeronaveDAO;

import model.Aeronave;

public class MySqlDaoAeronaveDAO implements AeronaveDAO{	

	public void incluir(Aeronave aeronave) {
		String sqlInsert = "INSERT INTO aeronave(nm_aeronave, qtde_ass_aeronave,localizacao_assento ) VALUES (?, ?, ?)";
		Connection conn = null;
		PreparedStatement stm = null;
		try {						
			conn = MySqlDaoConexaoBD.conectar();
			stm = conn.prepareStatement(sqlInsert);
			stm.setString(1, aeronave.getNmAeronave());
			stm.setInt(2, aeronave.getQtdeAssAeronave());
			stm.setString(3, aeronave.getLocalizacaoAssento());
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

	public void alterar(Aeronave aeronave)
	{
		String sqlUpdate = "UPDATE aeronave SET nm_aeronave = ?," +
				"qtde_ass_aeronave = ?," +
				"localizacao_assento = ?" +
				"where cod_aeronave = ?";
		
		Connection conn = null;
		
		PreparedStatement stm = null;
		try {	
			conn = MySqlDaoConexaoBD.conectar();
			stm = conn.prepareStatement(sqlUpdate);
			stm.setString(1, aeronave.getNmAeronave());
			stm.setInt(2, aeronave.getQtdeAssAeronave());
			stm.setString(3, aeronave.getLocalizacaoAssento());
			stm.setInt(4, aeronave.getCodAeronave());
			stm.execute();
		
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
			}
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

	public void excluir(Aeronave aeronave) {
		String sqlDelete = "DELETE FROM aeronave WHERE cod_aeronave = ?";
		Connection conn = null;
		PreparedStatement stm = null;
		
		try {
			conn = MySqlDaoConexaoBD.conectar();
			stm = conn.prepareStatement(sqlDelete);
			stm.setInt(1, aeronave.getCodAeronave());
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

	public Aeronave carregar(int codigo) {
		Aeronave aeronave = new Aeronave();
		String sqlSelect = "SELECT * FROM aeronave WHERE cod_aeronave = ?";
		PreparedStatement stm = null;
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = MySqlDaoConexaoBD.conectar();
			stm = conn.prepareStatement(sqlSelect);
			stm.setInt(1, codigo);
			rs = stm.executeQuery();			
			if (rs.next())
			{
				aeronave.setCodAeronave(Integer.parseInt(rs.getString(1)));
				aeronave.setNmAeronave(rs.getString(2));
				aeronave.setQtdeAssAeronave(rs.getInt(3));
				aeronave.setLocalizacaoAssento(rs.getString(4));
			}
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
		return aeronave;
	}
}


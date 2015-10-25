package mysqldao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.VooDAO;
import model.Voo;

public class MySqlDaoVooDAO implements VooDAO{	

	public void incluir(Voo voo) {
		String sqlInsert = "INSERT INTO voo(aero_origem, aero_destino ," 
				+ " data, cod_aeronave, situacao, qtdeDisponivel) " 
				+ "VALUES (?, ?, ?, ?, ?,(select qtde_ass_aeronave from aeronave where cod_aeronave = ?))";
		Connection conn = null;
		PreparedStatement stm = null;
		try {
			conn = MySqlDaoConexaoBD.conectar();
			stm = conn.prepareStatement(sqlInsert);
			stm.setString(1, voo.getAeroportoOrigem());
			stm.setString(2, voo.getAeroportoDestino());
			stm.setString(3, voo.getDataHora());
			stm.setInt(4, voo.getAeronave());
			stm.setString(5, voo.getSituacao());
			stm.setInt(6, voo.getAeronave());
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
	
	public void alterar(Voo voo) {
		
		String sqlInsert = "UPDATE voo SET aero_origem = ?," +
				"aero_destino = ? ,data = ? , cod_aeronave = ? , situacao = ? " +
				"where cod_voo = ?";
		
		Connection conn = null;
		
		PreparedStatement stm = null;
		try {
			conn = MySqlDaoConexaoBD.conectar();
			stm = conn.prepareStatement(sqlInsert);
			stm.setString(1, voo.getAeroportoOrigem());
			stm.setString(2, voo.getAeroportoDestino());
			stm.setString(3, voo.getDataHora());
			stm.setInt(4, voo.getAeronave());
			stm.setString(5, voo.getSituacao());
			stm.setInt(6, voo.getCodVoo());
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
	
	public void excluir(Voo voo) {
		String sqlDelete = "DELETE FROM voo WHERE cod_voo = ?";
		Connection conn = null;
		PreparedStatement stm = null;
		try {
			conn = MySqlDaoConexaoBD.conectar();
			stm = conn.prepareStatement(sqlDelete);
			stm.setInt(1, voo.getCodVoo());
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

	public Voo carregar(int codigo) {
		Voo voo = new Voo();
		String sqlSelect = "SELECT * FROM voo WHERE cod_voo = ?";
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			conn = MySqlDaoConexaoBD.conectar();
			stm = conn.prepareStatement(sqlSelect);
			stm.setInt(1, codigo);
			rs = stm.executeQuery();
			if (rs.next())
			{
				voo.setCodVoo(rs.getInt(1));
				voo.setAeronave(rs.getInt(2));
				voo.setAeroportoOrigem(rs.getString(3));
				voo.setAeroportoDestino(rs.getString(4));
				voo.setDataHora(rs.getString(5));
				voo.setSituacao(rs.getString(6));
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
		return voo;
	}
}


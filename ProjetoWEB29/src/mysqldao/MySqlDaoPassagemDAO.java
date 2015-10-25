package mysqldao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.PassagemDAO;
import model.Cliente;
import model.Pagamento;
import model.Passagem;
import model.Voo;

public class MySqlDaoPassagemDAO implements PassagemDAO
{
	public void alterarAssento(Passagem passagem)
	{
		String sqlInsert = "UPDATE passagem SET cod_assento = ? where cod_passagem = ?";
		Connection conn = null;
		PreparedStatement stm = null;
		try {
			conn = MySqlDaoConexaoBD.conectar();
			stm = conn.prepareStatement(sqlInsert);
			stm.setInt(1, passagem.getCodigoAssento());
			stm.setInt(2, passagem.getCodigo());
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
	
	public boolean consultarAssentoVago(Passagem passagem) {
		
		boolean vago = false;
		String sqlSelect = "select * from passagem where cod_assento = ?";
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		
		try {
			conn = MySqlDaoConexaoBD.conectar();
			stm = conn.prepareStatement(sqlSelect);
			stm.setInt(1, passagem.getCodigoAssento());
			rs = stm.executeQuery();
			if (rs.next()) {
				vago = false;
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
		return vago;
	}
	
	public Passagem consultarCheckIn( Passagem passagem) {
		
		String sqlSelect = "SELECT " +
				" cli.nome," +
				" cli.sobrenome	" +
				" FROM " +
				"passagem pas " +
				"LEFT JOIN " +
				" cliente cli " +
				"ON " +
				" cli.cod_cliente = pas.cod_cliente " +
				"WHERE cod_passagem = ?";
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		
		try {
			conn = MySqlDaoConexaoBD.conectar();
			stm = conn.prepareStatement(sqlSelect);
			stm.setInt(1, passagem.getCodigo());
			rs = stm.executeQuery();
			if (rs.next()) {
				
				Cliente cli = new Cliente();
				
				cli.setNome(rs.getString(1));
				cli.setSobrenome(rs.getString(2));
				passagem.setCliente(cli);
				
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
		return passagem;
	}	
	
	public ArrayList<Passagem> consultarPasssagensVendidas(Passagem passagem)
	{		
		ArrayList<Passagem> passagens = new ArrayList<Passagem>();
		
		String sqlSelect = "SELECT" +
				" pas.cod_passagem," +
				" cli.nome," +
				" voo.cod_voo," +
				" voo.aero_origem," +
				" voo.aero_destino" +
				" FROM"+
				" passagem pas" +
				" LEFT JOIN" +
				" cliente cli" +
				" ON" +
				" cli.cod_cliente = pas.cod_cliente" +
				" LEFT JOIN" +
				" voo voo" +
				" ON" +
				" cli.cod_cliente = pas.cod_cliente";
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			conn = MySqlDaoConexaoBD.conectar();
			stm = conn.prepareStatement(sqlSelect);
			rs = stm.executeQuery();
			while (rs.next()) 
			{
				
				Cliente cli = new Cliente();
				Voo voo = new Voo();
				Passagem pas = new Passagem();
				
				pas.setCodigo(rs.getInt(1));
				cli.setNome(rs.getString(2));
				voo.setCodVoo(rs.getInt(3));
				voo.setAeroportoOrigem(rs.getString(4));
				voo.setAeroportoDestino(rs.getString(5));
				
				pas.setCliente(cli);
				pas.setVoo(voo);
				
				passagens.add(pas);
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
		return passagens;
	}
	
	public static void incluirComprarPassagem(Pagamento pagamento, Cliente cliente)
	{/*

		String sqlInsert = "INSERT INTO pagamento(cod_pag,"
				+ "valor,tipo_pagamento,tipo_cartao,"
                                + "nome_titular,cpf,numero_cartao,"
                                + "data_validade,cod_seg,banco,"
                                + "agencia,conta,email,telefone) "
				+ "VALUES (?,?, ?, ?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement stm = null;
		try {
			conn = MySqlDaoConexaoBD.conectar();
			stm = conn.prepareStatement(sqlInsert);
			stm.setInt(1, pagamento.getCodigo());
			stm.setFloat(2, pagamento.getValor());
			stm.setInt(3, pagamento.getTipoPagamneto());
			stm.setInt(4, pagamento.getTipoCartao());
			stm.setString(5, pagamento.getNomeTitular());
                        stm.setString(6, pagamento.getCpf());
                        stm.setString(7, pagamento.getNumeroCartao());
                        stm.setDate(8, new java.sql.Date(pagamento.getDataValidade().getTime()));
                        stm.setString(9, pagamento.getCodSeguranca());
                        stm.setString(10, pagamento.getBanco());
                        stm.setString(11, pagamento.getAgencia());
                        stm.setString(12, pagamento.getConta());
                        stm.setString(13, pagamento.getEmail());
                        stm.setString(14, pagamento.getTelefone());

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
		}*/
	}
	
	public ArrayList<Passagem> consultarPasssagensDisponiveis(Passagem passagem)
	{		
		ArrayList<Passagem> passagens = new ArrayList<Passagem>();
		
		String sqlSelect = "SELECT" +
				"pas.cod_passagem," +
				" cli.nome," +
				"voo.cod_voo," +
				" voo.aero_origem," +
				" voo.aero_destino" +
				"FROM"+
				"passagem pas" +
				"LEFT JOIN" +
				" cliente cli" +
				"ON" +
				"cli.cod_cliente = pas.cod_cliente" +
				"LEFT JOIN" +
				"voo voo" +
				"ON" +
				" cli.cod_cliente = pas.cod_cliente";
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			conn = MySqlDaoConexaoBD.conectar();
			stm = conn.prepareStatement(sqlSelect);
			rs = stm.executeQuery();
			while (rs.next()) {
				
				Cliente cli = new Cliente();
				Voo voo = new Voo();
				Passagem pas = new Passagem();
				
				pas.setCodigo(rs.getInt(1));
				cli.setCodigo(rs.getInt(2));
				voo.setCodVoo(rs.getInt(3));
				voo.setAeroportoOrigem(rs.getString(4));
				voo.setAeroportoDestino(rs.getString(5));
				
				pas.setCliente(cli);
				pas.setVoo(voo);
				
				passagens.add(pas);
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
		return passagens;
	}

	public ArrayList<Voo> buscarPassagem(String origem, String destino, int quantidade)
	{
		ArrayList<Voo> voos = new ArrayList<Voo>();
		
		String sqlSelect = "SELECT VOO.cod_voo, VOO.AERO_ORIGEM, VOO.AERO_DESTINO, VOO.DATA FROM PROJETO.VOO "
				+ " WHERE VOO.AERO_ORIGEM LIKE ? "
				+ " AND VOO.AERO_DESTINO LIKE ? "
				+ " AND VOO.qtdeDisponivel >= ?" ;
		
				Connection conn = null;
				PreparedStatement stm = null;
				ResultSet rs = null;
				try
				{
					conn = MySqlDaoConexaoBD.conectar();
					stm = conn.prepareStatement(sqlSelect);
					
					stm.setString(1, origem);
					stm.setString(2, destino);
					stm.setInt(3, quantidade);
					
					rs = stm.executeQuery();
					while (rs.next())
					{
						Voo voo = new Voo();
					
						voo.setCodVoo((rs.getInt(1)));
						voo.setAeroportoOrigem(rs.getString(2));
						voo.setAeroportoDestino(rs.getString(3));
						voo.setDataHora(rs.getString(4));
						
						voos.add(voo);
					}
				}
				catch (Exception e)
				{
					e.printStackTrace();
					try {
						conn.rollback();
					} catch (SQLException e1) {
						System.out.print(e1.getStackTrace());
					}
				} 
				finally 
				{
					if (stm != null) {
						try {
							stm.close();
						} catch (SQLException e1) {
							System.out.print(e1.getStackTrace());
						}
					}
				}
				return voos;
	}
	
	public void incluirPagamento(Pagamento pagamento)
	{
		String sqlInsert = "INSERT INTO pagamento(cod_pag, valor, tipo_cartao,nome_titular,cpf,numero_cartao, "
				+ " data_validade, cod_seg, banco, agencia, "
				+ " conta, email, telefone) "
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement stm = null;
		try {
			conn = MySqlDaoConexaoBD.conectar();			
			stm = conn.prepareStatement(sqlInsert);
			stm.setInt(1, pagamento.getCodigo());
			stm.setDouble(2, pagamento.getValor());
			stm.setString(3, pagamento.getTipoCartao());
			stm.setString(4, pagamento.getNomeTitular());
			stm.setString(5, pagamento.getCpf());
			stm.setString(6, pagamento.getNumeroCartao());
			stm.setString(7, pagamento.getDataValidade());
			stm.setString(8, pagamento.getCodSeguranca());
			stm.setString(9, pagamento.getBanco());
			stm.setString(10, pagamento.getAgencia());
			stm.setString(11, pagamento.getConta());
			stm.setString(12, pagamento.getEmail());
			stm.setString(13, pagamento.getTelefone());
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
	
	public void incluirPassagem(int codPagamento, int codCliente, int codVoo)
	{
		String sqlInsert = "INSERT INTO passagem(cod_pag, cod_cliente, cod_voo)"
				+ "VALUES (?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement stm = null;
		try {
			conn = MySqlDaoConexaoBD.conectar();			
			stm = conn.prepareStatement(sqlInsert);
			stm.setInt(1, codPagamento);
			stm.setInt(2, codCliente);
			stm.setInt(3, codVoo);			
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


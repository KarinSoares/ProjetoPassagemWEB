package mysqldao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Pagamento;
import model.Passagem;
import model.Reembolso;
import dao.ReembolsoDAO;

public class MySqlDaoReembolsoDAO  implements ReembolsoDAO{

	@Override
	public void cancelarPassagem(Reembolso reembolso, Pagamento pagamento,
			Passagem passagem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelarPassagem(String numeroBilhete, String banco,
			String agencia, String contaCorrente, String nomeTitular,
			String cpf, String valorReembolso, String dataCancelamento) {
		// TODO Auto-generated method stub
		String sqlInsert = "INSERT INTO reembolso(cod_passagem,banco,agencia,conta_corrente,nm_titular,cpf,valor_reembolso,data_cancelamento)"
				+ "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement stm = null;
		try {
			conn = MySqlDaoConexaoBD.conectar();
			stm = conn.prepareStatement(sqlInsert);
			//stm.setInt(1, Integer.parseInt(cod_reembolso));
			stm.setInt(1, Integer.parseInt(numeroBilhete));
		    stm.setString(2, banco);
		    stm.setString(3, agencia);
		    stm.setString(4, contaCorrente);
		    stm.setString(5, nomeTitular);
		    stm.setString(6, cpf);
		    stm.setDouble(7, Double.parseDouble(valorReembolso));
		    stm.setString(8, dataCancelamento);
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

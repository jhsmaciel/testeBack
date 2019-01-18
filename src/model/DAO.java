package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import controller.CustomerAccount;

public abstract class DAO {
	
	private static String baseDados = "teste_back";
	private final String DRIVER = "org.postgresql.Driver";
	
	private static Connection getConnection(){
		try{
            String url = "jdbc:postgresql://localhost:5432/"+baseDados;
            Properties props = new Properties();
            props.setProperty("user","postgres");
            props.setProperty("password","aluno");
            return DriverManager.getConnection(url, props);
        } catch (Exception ex){
            ex.printStackTrace();
        }
		return null;
	}
	
	
	public static void executeBatch(List<CustomerAccount> listCustomer) {
		Connection conexao = null;
		try {
			conexao = getConnection();
			conexao.setAutoCommit(false);
			PreparedStatement pstm = conexao.prepareStatement("Insert into	tb_customer_account (cpf_cnpj, nm_customer, is_active, vl_total) values	(?,?,?,?)");
		for (CustomerAccount customer : listCustomer) {
			pstm.setDouble(1, customer.getCpfCnpj());
			pstm.setString(2, customer.getNameCustomer());
			pstm.setBoolean(3, customer.isActive());
			pstm.setDouble(4, customer.getVlTotal());
			pstm.addBatch();
		}
			pstm.executeBatch();
			conexao.commit();
			pstm.close();
			conexao.close();
	 
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}
	
	protected ResultSet selectRS(String query) throws SQLException, ClassNotFoundException {
        Class.forName(DRIVER);
        Connection con = getConnection();
        PreparedStatement stmt = con.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        con.close();
        return rs;
    }
}
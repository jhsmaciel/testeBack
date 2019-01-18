package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controller.CustomerAccount;

public class PullCustomerDAO extends DAO {
	
	public PullCustomerDAO() {
		try {
			System.out.println("A média dos itens cujo vl_total é maior que 560 e o campo id_customer está dentro do range de 1500 até 2700, é:  "+getAverage());
			System.out.println("Clientes utilizado para efeturar a média:");
			
			for(CustomerAccount customer: getCustomers()){
				System.out.println(" ----------------------- ");
				System.out.println("ID: "+ customer.getCustomerID());
				System.out.println("Nome: "+customer.getNameCustomer());
				System.out.println("CPF/CNPJ: "+customer.getCpfCnpj());
				System.out.println("Valor Total: "+customer.getVlTotal());
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public long getAverage() throws SQLException, ClassNotFoundException {
        String query = "select avg (vl_total) from tb_customer_account where id_customer > 1500 and id_customer < 2700  and vl_total > 560;" ;
        ResultSet rs = selectRS(query);
        long customerAverage = 0;
        while (rs.next()) {
        	customerAverage = rs.getLong("avg");
        }
        return customerAverage;
    }
	
	public List<CustomerAccount> getCustomers() throws SQLException, ClassNotFoundException {
        List<CustomerAccount> listCostumerAverage= new ArrayList<>();
        String query = "select id_customer, cpf_cnpj, nm_customer, is_active, vl_total from tb_customer_account where id_customer > 1500 and id_customer < 2700  and vl_total > 560 order by vl_total desc;" ;
        ResultSet rs = selectRS(query);

        while (rs.next()) {
            CustomerAccount customer = new CustomerAccount();
            customer.setCustomerID(rs.getInt("id_customer"));
            customer.setCpfCnpj(rs.getDouble("cpf_cnpj"));
            customer.setNameCustomer(rs.getString("nm_customer"));
            customer.setActive(rs.getBoolean("is_active"));
            customer.setVlTotal(rs.getLong("vl_total"));
            listCostumerAverage.add(customer);
        }
        return listCostumerAverage;
    }
}
package model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import controller.CustomerAccount;

public class CustomerDAO extends DAO{
	public CustomerDAO() {
		generatedMassa();
		System.out.println("Massa de dados gerada!!");
		insertList();
		System.out.println("Inserts no banco de dados efetuados!");
	}

	private static List<CustomerAccount> listCustomer = new ArrayList<>();
	private static void generatedMassa(){
		for (int i = 0; i < 10000; i++) {
			CustomerAccount customer = new CustomerAccount();
			customer.setCpfCnpj(11111111111L+i);
			customer.setNameCustomer(generatedString());
			customer.setActive(generatedBoolean());
			customer.setVlTotal(generatedLongTotal());
			listCustomer.add(customer);
		}
	}
	
	private void insertList() {
		executeBatch(listCustomer);
	}
	
	private static String generatedString() {
		int leftLimit = 97; //     a
	    int rightLimit = 122; //   z
	    int targetStringLength = 10; //  Quantidade de caracteres
	    Random random = new Random();
	    StringBuilder buffer = new StringBuilder(targetStringLength);
	    for (int i = 0; i < targetStringLength; i++) {
	        int randomLimitedInt = leftLimit + (int) 
	          (random.nextFloat() * (rightLimit - leftLimit + 1));
	        buffer.append((char) randomLimitedInt);
	    }		    
	    String generatedString = buffer.toString();
	    return generatedString ;
	}
	
	private static boolean generatedBoolean() {
	    return Math.random() < 0.5;
	}
	
	private static long generatedLongTotal() {
		long numero = (long) (Math.random()*(1000 - 10 ) + 10);
		DecimalFormat formato = new DecimalFormat("#.##");      
		numero = Long.valueOf(formato.format(numero));
		return numero;
	}
}

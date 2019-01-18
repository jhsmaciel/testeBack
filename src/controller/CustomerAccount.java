package controller;

public class CustomerAccount {

	private double cpfCnpj;
	private String nameCustomer;
	private boolean isActive;
	private long vlTotal;
	private int customerID;
	
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public double getCpfCnpj() {
		return cpfCnpj;
	}
	public void setCpfCnpj(double cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
	public String getNameCustomer() {
		return nameCustomer;
	}
	public void setNameCustomer(String nameCustomer) {
		this.nameCustomer = nameCustomer;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public double getVlTotal() {
		return vlTotal;
	}
	public void setVlTotal(long vlTotal) {
		this.vlTotal = vlTotal;
	}
}

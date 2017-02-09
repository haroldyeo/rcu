package com.pojos;

public class Agent {
	
	private TableSource tableSource;
	private CustomerMaster master;
	
	
	
	public Agent() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Agent(TableSource tableSource, CustomerMaster master) {
		super();
		this.tableSource = tableSource;
		this.master = master;
	}



	public TableSource getTableSource() {
		return tableSource;
	}



	public void setTableSource(TableSource tableSource) {
		this.tableSource = tableSource;
	}



	public CustomerMaster getMaster() {
		return master;
	}



	public void setMaster(CustomerMaster master) {
		this.master = master;
	}
		
	

}

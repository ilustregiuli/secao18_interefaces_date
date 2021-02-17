package secao18;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contract {
	
	private Integer number;
	private Date date;
	private Double totalValue;
	
	private List<Installment> installments  = new ArrayList<>();
	
	
	public Contract() {
		
	}

	public Contract(Integer number, Date date, Double totalValue) {
		this.number = number;
		this.date = date;
		this.totalValue = totalValue;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public List<Installment> getInstallment() {
		return installments;
	}


	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}
	
	public void addInstall(Installment install) {
		installments.add(install);
	}
	
	public void removeInstall(Installment install) {
		installments.remove(install);
	}
	
	@Override
	public String toString() {
		return "Number of contract: " + this.number 
				+ "\nDate: " + date
				+ "\nContract value: " + this.totalValue;
				
	}

	
	
	
	

}

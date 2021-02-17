package secao18;

import java.util.Calendar;
import java.util.Date;

public class ContractService {

	private OnlinePaymentService onlinePaymentService;
	
	public ContractService() {
		
	}
	
	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}


	public void processContract(Contract contract, Integer months) {
		
		double amountInstal = contract.getTotalValue() / months;
		
		for(int i = 1; i <= months; i++) {
			
			double valueInstallInterest = onlinePaymentService.interest(amountInstal,i);
			
			double valueInstallFee = onlinePaymentService.paymentFee(valueInstallInterest + amountInstal);
			
			double totalAmountInstal = amountInstal + valueInstallInterest + valueInstallFee;
			
			Date date = addMonths(contract.getDate(),i);
			
			contract.addInstall(new Installment(date, totalAmountInstal));
			
		}
		
	}
	
	private Date addMonths(Date date, int months) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, months);
		return cal.getTime();
	}
	
}

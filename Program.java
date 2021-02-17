package secao18;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		System.out.println("Enter contract data");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Date (dd/MM/yyyy): ");
		
		 
		Date date = sdf.parse(sc.next());	//*************** Lê a data e já transforma no formato definido no SimpleDateFormat
		System.out.print("Contract value: ");
		double valueContract = sc.nextDouble();
		
		Contract cont = new Contract(number, date, valueContract);
		
		System.out.print("Enter number of installments: ");
		int months = sc.nextInt();
		
		ContractService contService = new ContractService(new Paypalservice());
		
		contService.processContract(cont, months);
		
		System.out.println();
		
		System.out.println("Installments: ");
		for(Installment install : cont.getInstallment() ) {
			System.out.println(sdf.format(install.getDueDate()) + " - " + install.getAmount());
		}
		
		sc.close();

	}

}

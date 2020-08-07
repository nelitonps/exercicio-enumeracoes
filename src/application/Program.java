package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
	
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Entre com o nome do departamento: ");
		String departmentName = sc.nextLine();
		
		System.out.println("Entre com Dados do Trabalhador: ");
		System.out.print("Nome: ");
        String workerName = sc.nextLine();
        System.out.print("Level: ");
        String workerLevel = sc.nextLine();
        System.out.print("Salario Base: ");
        double salarioBase= sc.nextDouble();
        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), salarioBase, new Department(departmentName));
        
        System.out.print("Quantos contratos este trabalhador vai ter: ");
        int n = sc.nextInt();
        
        for (int i=1; i<=n; i++) {
			System.out.println("Contrato #" + i + "data:");
			System.out.print("Data (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(sc.next());
			System.out.print("Valor por Hora: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duração (Horas): ");
			int horas = sc.nextInt();
			HourContract contract = new HourContract(contractDate, valuePerHour, horas);
			worker.addContract(contract);
		}
        System.out.println();
        System.out.print("Entre com mes e ano para calcular salario (MM/YYYY): ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		System.out.println("Nome: " + worker.getName());
		System.out.println("Departamento: " + worker.getDepartment().getName());
		System.out.println("Ganhou em" + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));
		
		sc.close();
		
	}

}

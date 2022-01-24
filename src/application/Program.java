package application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.BankAccount;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("Enter account data");
			System.out.print("Number: ");
			Integer number = sc.nextInt();
			System.out.print("Holder: ");
			sc.nextLine();
			String holder = sc.nextLine();
			System.out.print("Initial balance: ");
			Double initialBalance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			Double withdrawLimit = sc.nextDouble();
			BankAccount account1 = new BankAccount(number, holder, initialBalance, withdrawLimit);
			System.out.println();
			System.out.print("Enter amount for withdraw: ");
			account1.withdraw(sc.nextDouble());
			System.out.println(account1);
		} catch (InputMismatchException e) {
			System.out.println("Invalid format");
		} catch (DomainException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		}
	}
}

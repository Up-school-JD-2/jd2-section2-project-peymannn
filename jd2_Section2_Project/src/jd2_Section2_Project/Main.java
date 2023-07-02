package jd2_Section2_Project;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			int choice = 0;
			int transactionType = 0;
			PhoneManager phoneManeger = new PhoneManager();

			if (phoneManeger.CreatePhone()) {
				System.out.println(phoneManeger.phone);
				do {
					System.out.println("--------------------------------");
					printMenu();
					System.out.println("--------------------------------");
					choice = sc.nextInt();
					switch (choice) {
					case 1 -> {
						System.out.println("--------------------------------");
						printTransactions();
						System.out.println("4-Search By Name");
						System.out.println("5-Users Sorted By Name\r\n");
						System.out.println("--------------------------------");
						System.out.print("Transaction Type : ");
						transactionType = sc.nextInt();
						phoneManeger.DirectToUserTransaction(transactionType);
					}
					case 2 -> {
						System.out.println("--------------------------------");
						printTransactions();
						System.out.println("4-Search By Name And Version\r\n" + "5-Apps Filter By Size\r\n"
								+ "6-Apps Sorted By Memory\r\n" + "7-Get Memory Sum Grup By App Version\r\n");
						System.out.println("--------------------------------");
						System.out.print("Transaction Type : ");
						transactionType = sc.nextInt();
						phoneManeger.DirectToAppTransaction(transactionType);
					}
					case 3 -> {
						phoneManeger.CheckMemoryInfo();
					}
					case 4 -> {
						phoneManeger.DataBackup();
					}
					case 5 -> {
						phoneManeger.DataRestore();
					}
					case -1 -> {
					}
					default -> System.out.println("Hatalı seçim yaptınız, çıkış için -1");
					}
				} while (choice > -1);
			}
			System.out.println("GoodBye.");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void printMenu() {
		System.out.println("\n##### Menu #####");

		System.out.println("1-User Transaction\r\n" + "2-App Transaction\r\n" + "3-Memory Check\r\n"
				+ "4-Data Backup\r\n" + "5-Data Restore");
		System.out.println("-1: Kullanıcı çıkışı");
	}

	private static void printTransactions() {
		System.out.println("\n##### Transactions #####");
		System.out.println("1-Add \r\n" + "2-Update\r\n" + "3-Remove");
	}
}

package jd2_Section2_Project;

import java.util.Scanner;

import jd2_Section2_Project.Exception.InValidEmailException;
import jd2_Section2_Project.Exception.InValidSerialNumberException;
import jd2_Section2_Project.Model.*;
import jd2_Section2_Project.Transaction.Application.AppTransaction;
import jd2_Section2_Project.Transaction.File.FileTransaction;
import jd2_Section2_Project.Transaction.Phone.PhoneTransaction;
import jd2_Section2_Project.Transaction.User.UserTransaction;
import jd2_Section2_Project.Validation.*;

public class PhoneManager {

	AppTransaction appTransaction = new AppTransaction();
	FileTransaction fileTransaction = new FileTransaction();
	UserTransaction userTransaction = new UserTransaction();

	public static Phone phone;
	Scanner sc = new Scanner(System.in);

	public boolean CreatePhone() {

		PhoneTransaction phoneTransaction = new PhoneTransaction();
		PhoneValidation phoneValidation = new PhoneValidation();
		try {

			System.out.print("Phone brand: ");
			var brand = sc.next();
			System.out.print("Phone model: ");
			var model = sc.next();
			System.out.print("Phone serial Number: ");
			var serialNumber = sc.next();
			System.out.print("Phone memory: ");
			var memory = sc.nextDouble();
			System.out.print("Phone operating system: ");
			var type = sc.next();
			var operatingSystem = OperatingSystemEnum.getOperatingSystem(type);
			Phone phoneInfo = phoneTransaction.Create(brand, model, serialNumber, memory, operatingSystem);
			if (!phoneValidation.IsValid(phoneInfo)) {
				throw new InValidSerialNumberException("seri numarası 11 haneli, rakamlardan oluşmalıdır.");
			}
			phone = phoneInfo;
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public void CheckMemoryInfo() {
		System.out.println("phone memory : " + phone.getMemory());
		System.out.println("sum of size apps : " + appTransaction.getAppsSizeSummaryStatistics().getSum());
		System.out.println("Average of size apps : " + appTransaction.getAppsSizeSummaryStatistics().getAverage());
		System.out.println("empty of phone memory : "
				+ (phone.getMemory() - appTransaction.getAppsSizeSummaryStatistics().getSum()));
	}

	public void DataBackup() {
		System.out.println("Data Backup is starting...");
		fileTransaction.write(phone, userTransaction.getUsers());
		System.out.println("Data Backup finished.");
	}

	public void DataRestore() {
		System.out.println("Data Restore is starting...");
		fileTransaction.read();
		System.out.println("Data Restore finished.");
	}

	public void DirectToAppTransaction(int transactionType) {
		switch (transactionType) {
		case 1 -> {
			try {

				System.out.print("App id: ");
				var id = sc.next();
				System.out.print("App name: ");
				var name = sc.next();
				System.out.print("App version: ");
				var version = sc.next();
				System.out.print("App size: ");
				var size = sc.nextDouble();
				Application app = new Application(id, name, version, size);

				appTransaction.add(app);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		case 2 -> {
			System.out.print("App id for update: ");
			var id = sc.next();
			System.out.print("App name: ");
			var name = sc.next();
			System.out.print("App version: ");
			var version = sc.next();
			System.out.print("App size: ");
			var size = sc.nextDouble();
			Application app = new Application(id, name, version, size);

			appTransaction.update(app);
		}
		case 3 -> {
			System.out.print("App id for remove: ");
			var id = sc.next();
			appTransaction.remove(id);
		}
		case 4 -> {
			System.out.print("App name for search: ");
			var name = sc.next();
			System.out.print("App version for search: ");
			var version = sc.next();
			appTransaction.getApplicationByNameAndVersion(name, version);
		}
		case 5 -> {
			System.out.print("App less then equal size: ");
			var size = sc.nextDouble();
			System.out.print("Apps Filter By Size: \r\n");
			appTransaction.getAppsFilterBySize(size).forEach(System.out::println);
		}
		case 6 -> {
			System.out.print("Apps Sorted By Memory: \r\n");
			appTransaction.getAppsSortedByMemory().forEach(System.out::println);
		}
		case 7 -> {
			System.out.print("get Memory Sum GrupBy AppVersion: \r\n");
			System.out.println(appTransaction.getMemorySumGrupByAppVersion());
		}
		case -1 -> {
		}
		default -> System.out.println("Hatalı seçim yaptınız, çıkış için -1");
		}
	}

	public void DirectToUserTransaction(int transactionType) {
		switch (transactionType) {
		case 1 -> {
			try {
				UserValidation userValidation = new UserValidation();
				System.out.print("User id: ");
				var id = sc.next();
				System.out.print("User name: ");
				var name = sc.next();
				System.out.print("User surname: ");
				var surname = sc.next();
				System.out.print("User phoneNumber: ");
				var phoneNumber = sc.next();
				System.out.print("User email: ");
				var email = sc.next();

				User user = new User(id, name, surname, phoneNumber, email);

				if (!userValidation.IsValid(user)) {
					throw new InValidEmailException("email formatında olmalı.");
				}
				userTransaction.add(user);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		case 2 -> {
			System.out.print("User id for update: ");
			var id = sc.next();
			System.out.print("User name: ");
			var name = sc.next();
			System.out.print("User surname: ");
			var surname = sc.next();
			System.out.print("User phoneNumber: ");
			var phoneNumber = sc.next();
			System.out.print("User email: ");
			var email = sc.next();

			User user = new User(id, name, surname, phoneNumber, email);

			userTransaction.update(user);
		}
		case 3 -> {
			System.out.print("User id for update: ");
			var id = sc.next();
			userTransaction.remove(id);
		}
		case 4 -> {
			System.out.print("User name for search: ");
			var name = sc.next();
			userTransaction.getUserByName(name);
		}case 5 -> {
			System.out.print("Users Sorted By Name: \r\n");
			userTransaction.getUsersSortedByName().forEach(System.out::println);
		}
		case -1 -> {
		}
		default -> System.out.println("Hatalı seçim yaptınız, çıkış için -1");
		}
	}

}

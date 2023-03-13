package collection.impl.account;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Scanner;

public class LoadAccount {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		Account acc = null;
		HashMap<String, Account> hm = new HashMap<>();
		try {
			fis = new FileInputStream("Accounts.txt");
			ois = new ObjectInputStream(fis);
			int count = ois.readInt();
			for (int i = 0; i < count; i++) {
				acc = (Account) ois.readObject();
				System.out.println(acc);
				hm.put(acc.getAccountNo(), acc);
			}
			fis.close();
			ois.close();
		} catch (IOException e) {

		} catch (ClassNotFoundException e) {

		}
		/*********** Writing into file ************************/
		FileOutputStream fos = new FileOutputStream("Accounts.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		System.out.println("Menu");
		int choice;
		String accNo, name;
		double balance;
		do {
			System.out.println("1. Create Your Account.");
			System.out.println("2. Delete Your Account.");
			System.out.println("3. Save Your Account.");
			System.out.println("4. View Your Account.");
			System.out.println("5. View All Account.");
			System.out.println("6. Exit.");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter details accNo, name, and balance.");
				sc.nextLine();
				accNo = sc.nextLine();
				name = sc.nextLine();
				balance = sc.nextDouble();
				acc = new Account(accNo, name, balance);
				hm.put(accNo, acc);
				System.out.println("Your account got cretead " + name);
				break;
			case 2:
				System.out.println("Enter acc no.");
				sc.nextLine();
				accNo = sc.nextLine();
				hm.remove(accNo);
				break;
			case 3:
				oos.writeInt(hm.size());
				for (Account a : hm.values()) {
					oos.writeObject(a);
				}
				break;
			case 4:
				System.out.println("Enter acc no.");
				sc.nextLine();
				accNo = sc.nextLine();
				System.out.println("Your account no " + hm.get(accNo));
				break;
			case 5:
				hm.forEach((k, v) -> System.out.println(k + " " + v));
				break;

			default:
				break;
			}
		} while (choice != 6);
		oos.close();
		oos.flush();
		fos.close();

	}

}

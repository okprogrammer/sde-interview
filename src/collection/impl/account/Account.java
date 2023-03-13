package collection.impl.account;

import java.io.Serializable;

public class Account implements Serializable {
	private String accountNo;
	private String name;
	private double balance;

	public Account(String accountNo, String name, double balance) {
		super();
		this.accountNo = accountNo;
		this.name = name;
		this.balance = balance;
	}

	public String getAccountNo() {
		return accountNo;
	}

	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", name=" + name + ", balance=" + balance + "]";
	}

}

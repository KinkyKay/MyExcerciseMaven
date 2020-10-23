package org.example;

import java.util.ArrayList;
import java.util.List;

public class TransactionDisplay {
	private final Console console;

	public TransactionDisplay(Console console) {
		this.console = console;
	}

	public void print(List<Transaction> transactions) {
		console.printLine("DATE | AMOUNT | BALANCE");


		List<Integer> balances = new ArrayList<>();
		int balance = 0;
		for (Transaction transaction : transactions) {
			balance +=transaction.getAmount();
			balances.add(balance);
		}


		for (int i = transactions.size(); i-- > 0; ) {
			console.printLine("18/10/2020 | "
							  + transactions.get(i).getAmount()
							  + " | "
							  + balances.get(i));
		}

	}
}

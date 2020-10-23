package org.example;

import java.util.ArrayList;
import java.util.List;

public class TransactionRepository {
	ArrayList<Transaction> transactions = new ArrayList<>();

	public void addDeposit(int amount) {
		transactions.add(new Transaction(amount));
	}

	public void addWithdraw(int amount) {
		transactions.add(new Transaction(-amount));
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}
}

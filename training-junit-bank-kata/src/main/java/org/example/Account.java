package org.example;

public class Account {
	private final TransactionRepository transactionRepository;
	private TransactionDisplay transactionDisplay;

	public Account(TransactionRepository transactionRepository, TransactionDisplay transactionDisplay) {
		this.transactionRepository = transactionRepository;
		this.transactionDisplay = transactionDisplay;
	}

	public void deposit(int amount) {
		transactionRepository.addDeposit(amount);
	}

	public void withdraw(int amount) {
		transactionRepository.addWithdraw(amount);
	}

	public void printStatement() {
		transactionDisplay.print(transactionRepository.getTransactions());

	}
}

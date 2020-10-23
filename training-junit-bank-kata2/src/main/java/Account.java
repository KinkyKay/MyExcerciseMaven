public class Account {
	private TransactionHistory transactionHistory;

	public Account(TransactionHistory transactionHistory) {
		this.transactionHistory = transactionHistory;
	}

	public void deposit(int amount) {
		transactionHistory.addDeposit(amount);
	}

	public void withdraw(int amount) {
		transactionHistory.addWithdrawal(amount);
	}

	public int getBalance() {
		transactionHistory.getDeposits();
		return 0;
	}

	public void printStatements(Console console, AccountDisplay accountDisplay) {
		console.print(accountDisplay.getHeader());
	}
}

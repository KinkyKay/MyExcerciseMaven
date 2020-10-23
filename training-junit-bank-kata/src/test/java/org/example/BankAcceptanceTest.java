package org.example;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankAcceptanceTest {

	Console console = mock(Console.class);

	TransactionDisplay transactionDisplay;

	Account account;

	@BeforeEach
	void setUp() {
		transactionDisplay = new TransactionDisplay(console);
		account = new Account(new TransactionRepository(), transactionDisplay);
	}

	@Test
	public void testBank() {

		account.deposit(500);
		account.withdraw(120);
		account.withdraw(100);
		account.deposit(30);

		account.printStatement();

		verify(console).printLine("DATE | AMOUNT | BALANCE");
		verify(console).printLine("21/10/2020 | 30 | 310");
		verify(console).printLine("21/10/2020 | -100 | 280");
		verify(console).printLine("20/10/2020 | -120 | 380");
		verify(console).printLine("18/10/2020 | 500 | 500");

	}
}

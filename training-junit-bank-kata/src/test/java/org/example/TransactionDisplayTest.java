package org.example;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

class TransactionDisplayTest {

	private final Console console = Mockito.mock(Console.class);


	private TransactionDisplay transactionDisplay;

	@BeforeEach
	void setUp() {
		transactionDisplay = new TransactionDisplay(console);
	}

	@Test
	public void testPrintFirstLine() {
		transactionDisplay.print(Collections.emptyList());
		verify(console).printLine("DATE | AMOUNT | BALANCE");
	}

	@Test
	public void testDeposit100AndPrint() {
		transactionDisplay.print(Collections.singletonList(new Transaction(100)));

		verify(console).printLine("DATE | AMOUNT | BALANCE");
		verify(console).printLine("18/10/2020 | 100 | 100");
	}

	@Test
	public void testDeposit200AndPrint() {
		transactionDisplay.print(Collections.singletonList(new Transaction(200)));


		verify(console).printLine("DATE | AMOUNT | BALANCE");
		verify(console).printLine("18/10/2020 | 200 | 200");
	}

	@Test
	public void testDeposit100TwiceAndPrint() {

		ArrayList<Transaction> transactions = new ArrayList<>();
		transactions.add(new Transaction(100));
		transactions.add(new Transaction(100));
		transactionDisplay.print(transactions);

		InOrder inOrder = inOrder(console);
		inOrder.verify(console).printLine("DATE | AMOUNT | BALANCE");
		inOrder.verify(console).printLine("18/10/2020 | 100 | 200");
		inOrder.verify(console).printLine("18/10/2020 | 100 | 100");

	}



}
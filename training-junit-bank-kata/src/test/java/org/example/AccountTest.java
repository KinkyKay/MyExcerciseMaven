package org.example;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AccountTest {


	TransactionRepository transactionRepository = mock(TransactionRepository.class);

	TransactionDisplay transactionDisplay = mock(TransactionDisplay.class);

	Account account;

	@BeforeEach
	void setUp() {
		account = new Account(transactionRepository, transactionDisplay);
	}

	@Test
	public void testDeposit() {
		account.deposit(100);
		verify(transactionRepository).addDeposit(100);
	}

	@Test
	public void testWithdraw() {
		account.withdraw(100);
		verify(transactionRepository).addWithdraw(100);
	}


}
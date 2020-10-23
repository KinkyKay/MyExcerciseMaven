package org.example;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TransactionRepositoryTest {

	private TransactionRepository transactionRepository;

	@BeforeEach
	void setUp() {
		transactionRepository = new TransactionRepository();
	}

	@Test
	void testAddDeposit() {
		transactionRepository.addDeposit(100);
		Transaction transaction =  transactionRepository.getTransactions().get(0);
		Assertions.assertThat(transaction.getAmount()).isEqualTo(100);
	}

	@Test
	void testAddWithdraw() {
		transactionRepository.addWithdraw(100);
		Transaction transaction =  transactionRepository.getTransactions().get(0);
		Assertions.assertThat(transaction.getAmount()).isEqualTo(-100);

	}

	@Test
	void testAddDeposit_200() {
		transactionRepository.addDeposit(200);
		Transaction transaction =  transactionRepository.getTransactions().get(0);
		Assertions.assertThat(transaction.getAmount()).isEqualTo(200);
	}
}
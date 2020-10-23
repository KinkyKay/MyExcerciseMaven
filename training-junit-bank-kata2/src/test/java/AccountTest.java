import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AccountTest {
	@Mock
	TransactionHistory transactionHistory;

	@Mock
	Console console;

	@Mock
	AccountDisplay accountDisplay;

	@Test
	public void testDeposit(){
		Account account= new Account(transactionHistory);
		account.deposit(1);
		verify(transactionHistory).addDeposit(1);
	}

	@Test
	public void testWithdraw(){
		Account account= new Account(transactionHistory);
		account.withdraw(1);
		verify(transactionHistory).addWithdrawal(1);
	}

	@Test
	public void testSaldo(){
		Account account= new Account(transactionHistory);
		assertThat(account.getBalance()).isEqualTo(0);
	}
	@Test
	public void testPrintStatement(){
		when(accountDisplay.getHeader()).thenReturn("");
		Account account = new Account(transactionHistory);

		account.printStatements(console, accountDisplay);

		verify(console).print(anyString());
		verify(accountDisplay).getHeader();

	}

	@Test
	public void testPrintStatement_afterDeposit(){
		when(accountDisplay.getHeader()).thenReturn("");
		Account account = new Account(transactionHistory);
		account.deposit(1);

		account.printStatements(console, accountDisplay);

		verify(console, times(2)).print(anyString());
		verify(accountDisplay).getHeader();
		verify(accountDisplay).displayTransaction();

	}
}

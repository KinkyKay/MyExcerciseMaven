import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BankAccountAcceptanceTest {

	@Mock
	private Console console;


	@Test
	public void test(){
		//Given

		Account account = new Account(new TransactionHistory());
		AccountDisplay accountDisplay = new TextualAccountDisplay();
		account.deposit(500);
		account.withdraw(120);
		account.withdraw(100);
		account.deposit(30);

		//When
		account.printStatements(console, accountDisplay);

		//Then
		Mockito.verify(console).print("DATE | AMOUNT | BALANCE");
		Mockito.verify(console).print("21/10/2020 | 30 | 310");
		Mockito.verify(console).print("21/10/2020 | -100 | 280");
		Mockito.verify(console).print("20/10/2020 | -120 | 380");
		Mockito.verify(console).print("18/10/2020 | 500 | 500");

	}
}

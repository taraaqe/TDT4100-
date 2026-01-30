package oving1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AccountTest {

	private double delta = 1e-8;
	private Account account;

	@BeforeEach
	public void setUp() {
		account = new Account();
	}

	@Test
	@DisplayName("Constructor")
	public void testConstructor() {
		assertEquals(0.0, account.getBalance(), delta, "Wrong balance for newly created account");
	}

	@Test
	@DisplayName("Deposit")
	public void testDeposit() {
		account.deposit(100);

		assertEquals(100.0, account.getBalance(), delta, "Wrong balance after depositing");
	}

	@Test
	@DisplayName("Negative deposit")
	public void testNegativeDeposit() {
		account.deposit(-50);

		assertEquals(0.0, account.getBalance(), delta,
				"Wrong balance after making negative deposit");
	}

	@Test
	@DisplayName("Adding interest")
	public void testAddInterest() {
		account.setInterestRate(5);
		assertEquals(0, account.getBalance(), delta, "Wrong balance after updating interest rate");
		assertEquals(5, account.getInterestRate(), delta,
				"Wrong interest rate after updating interest rate");

		account.deposit(100);
		assertEquals(100, account.getBalance(), delta, "Wrong balance after depositing");

		account.addInterest();
		assertEquals(105, account.getBalance(), delta, "Wrong balance after adding interest");
	}
}

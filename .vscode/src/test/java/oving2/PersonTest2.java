package oving2;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonTest2 {

	private static final int[] factors1 = {3, 7, 6, 1, 8, 9, 4, 5, 2};
	private static final int[] factors2 = {5, 4, 3, 2, 7, 6, 5, 4, 3, 2};

	private Person person;

	@BeforeEach
	public void setUp() {
		person = new Person();
	}

	private static String generateValid(int n1, int n2, int n3, String birthday) {
		birthday = birthday + n1 + n2 + n3;
		int k1 = 0, k2 = 0;

		for (int i = 0; i < birthday.length(); i++) {
			int num = Character.getNumericValue(birthday.charAt(i));
			k1 += factors1[i] * num;
			k2 += factors2[i] * num;
		}

		k1 = 11 - (k1 % 11);

		if (k1 == 11) {
			k1 = 0;
		}

		k2 += k1 * factors2[9];
		k2 = 11 - (k2 % 11);

		if (k2 == 11) {
			k2 = 0;
		}

		return k1 + "" + k2;
	}

	@Test
	public void testSetSSN() {
		LocalDate localDate = LocalDate.of(1994, 1, 1);
		Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

		person.setBirthday(date);
		person.setGender('M');

		assertThrows(IllegalArgumentException.class, () -> {
			person.setSSN(null);
		}, "SSN cannot be null");

		assertDoesNotThrow(() -> {
			person.setSSN("010194111" + PersonTest2.generateValid(1, 1, 1, "010194"));
		});

		assertEquals("01019411156", person.getSSN());

		assertThrows(IllegalArgumentException.class, () -> {
			person.setSSN("010194112" + PersonTest2.generateValid(1, 1, 2, "010194"));
		});

		assertEquals("01019411156", person.getSSN());

		assertThrows(IllegalArgumentException.class, () -> {
			person.setSSN("01019411122");
		});

		assertEquals("01019411156", person.getSSN());
	}

	@Test
	public void testModifyingState() {
		LocalDate localDate = LocalDate.of(1994, 1, 1);
		Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

		person.setBirthday(date);
		person.setGender('M');
		person.setSSN("010194111" + PersonTest2.generateValid(1, 1, 1, "010194"));

		assertThrows(IllegalStateException.class, () -> {
			person.setGender('F');
		});
		assertThrows(IllegalStateException.class, () -> {
			person.setBirthday(new Date());
		});
	}
}

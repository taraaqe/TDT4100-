package oving1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LocationTest {

	private Location loc;

	/**
	 * Check that the position of {@link #loc} is equal to the parameters.
	 * 
	 * @param x Expected x position
	 * @param y Expected y position
	 */
	private void checkPos(int x, int y) {
		assertEquals(x, loc.getX(), "Wrong x coordinate");
		assertEquals(y, loc.getY(), "Wrong y coordinate");
	}

	@BeforeEach
	public void beforeEach() {
		loc = new Location();
	}

	@Test
	@DisplayName("Constructor")
	public void testConstructor() {
		this.checkPos(0, 0);
	}

	@Test
	@DisplayName("Move up")
	public void testUp() {
		loc.up();
		this.checkPos(0, -1);

		loc.up();
		this.checkPos(0, -2);
	}

	@Test
	@DisplayName("Move down")
	public void testDown() {
		loc.down();
		this.checkPos(0, 1);

		loc.down();
		this.checkPos(0, 2);
	}

	@Test
	@DisplayName("Move left")
	public void testLeft() {
		loc.left();
		this.checkPos(-1, 0);

		loc.left();
		this.checkPos(-2, 0);
	}

	@Test
	@DisplayName("Move right")
	public void testRight() {
		loc.right();
		this.checkPos(1, 0);

		loc.right();
		this.checkPos(2, 0);
	}

	@Test
	@DisplayName("Move multiple directions")
	public void testComplexMovement() {
		loc.right();
		this.checkPos(1, 0);

		loc.down();
		this.checkPos(1, 1);

		loc.right();
		this.checkPos(2, 1);

		loc.down();
		this.checkPos(2, 2);

		loc.left();
		this.checkPos(1, 2);

		loc.up();
		this.checkPos(1, 1);

		loc.up();
		this.checkPos(1, 0);

		loc.left();
		this.checkPos(0, 0);
	}
}

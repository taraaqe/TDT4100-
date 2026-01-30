package oving1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineEditorTest {

	private LineEditor lineEditor;

	private void checkEditorContent(String s) {
		assertEquals(s, lineEditor.toString(), "Wrong value returned by toString()");

		int pos = s.indexOf('|');
		assertEquals(s.substring(0, pos) + s.substring(pos + 1), lineEditor.getText(),
				"Wrong text value returned");
		assertEquals(pos, lineEditor.getInsertionIndex(), "Wrong insertion index");
	}

	@BeforeEach
	public void setUp() {
		lineEditor = new LineEditor();
	}

	@Test
	@DisplayName("Constructor")
	public void testContstructor() {
		this.checkEditorContent("|");
	}

	@Test
	@DisplayName("Setter methods")
	public void testSetters() {
		lineEditor.setText("Hello World!");
		this.checkEditorContent("|Hello World!");

		lineEditor.setInsertionIndex(5);
		this.checkEditorContent("Hello| World!");
	}

	@Test
	@DisplayName("Insert string at end")
	public void testInsertStringAtEnd() {
		lineEditor.insertString("");
		this.checkEditorContent("|");

		lineEditor.insertString("Java");
		this.checkEditorContent("Java|");

		lineEditor.insertString(" er gøy!");
		this.checkEditorContent("Java er gøy!|");
	}

	@Test
	@DisplayName("Insert string in the middle")
	public void testInsertStringMiddle() {
		lineEditor.setText("Javagøy!");
		lineEditor.setInsertionIndex(4);
		lineEditor.insertString(" er ");
		this.checkEditorContent("Java er |gøy!");
	}

	@Test
	@DisplayName("Insert string at the begginning")
	public void testInsertStringAtBeginning() {
		lineEditor.setText("er gøy!");
		lineEditor.setInsertionIndex(0);
		lineEditor.insertString("Java ");
		this.checkEditorContent("Java |er gøy!");
	}

	@Test
	@DisplayName("Move left")
	public void testLeft() {
		lineEditor.left();
		this.checkEditorContent("|");

		lineEditor.setText("J");
		lineEditor.setInsertionIndex(1);
		this.checkEditorContent("J|");

		lineEditor.left();
		this.checkEditorContent("|J");
	}

	@Test
	@DisplayName("Move right")
	public void testRight() {
		lineEditor.right();
		this.checkEditorContent("|");

		lineEditor.setText("J");
		lineEditor.setInsertionIndex(0);
		this.checkEditorContent("|J");

		lineEditor.right();
		this.checkEditorContent("J|");
	}

	@Test
	@DisplayName("Delete left")
	public void testDeleteLeft() {
		lineEditor.deleteLeft();
		this.checkEditorContent("|");

		lineEditor.insertString("J");
		lineEditor.deleteLeft();
		this.checkEditorContent("|");

		lineEditor.insertString("Java");
		lineEditor.setInsertionIndex(2);
		this.checkEditorContent("Ja|va");

		lineEditor.deleteLeft();
		this.checkEditorContent("J|va");
	}

	@Test
	@DisplayName("Delete right")
	public void testDeleteRight() {
		lineEditor.deleteRight();
		this.checkEditorContent("|");

		lineEditor.insertString("J");
		lineEditor.setInsertionIndex(0);
		lineEditor.deleteRight();
		this.checkEditorContent("|");

		lineEditor.insertString("Java");
		lineEditor.setInsertionIndex(2);
		this.checkEditorContent("Ja|va");

		lineEditor.deleteRight();
		this.checkEditorContent("Ja|a");
	}
}

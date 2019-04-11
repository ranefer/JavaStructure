import static org.junit.Assert.assertEquals;

import org.junit.Test;

import collection.DoublyLinkedList.DoublyLinkedList;

public class DoublyLinkedList_t {

	final String[] TEST_0 = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L" };

	final String[] TEST_1 = { "\0", "\\", "\t" };

	final String[] TEST_2 = {};
	final String[] TEST_3 = {};

	private DoublyLinkedList<String> createNewRep(String... args) {

		DoublyLinkedList<String> dll = new DoublyLinkedList<String>();
		for (int i = 0; i < args.length; i++) {
			dll.add(args[i]);
		}
		return dll;
	}

	// TODO:
	@Test
	public void constructor_0() {

	}

	/** private methods, to test or not to test */

	public void createNewRep_0() {
		// DoublyLinkedList<String> dll = this.createNewRep(TEST_0);
		// Method method = dll.getClass().getDeclaredMethod("moveTo", String);
	}

	public void moveTo_0() {

	}

	/** public methods */
	@Test
	public void add_0() {
		String result = "(A,B,C,D,E,F,G,H,I,J,K,L)";
		DoublyLinkedList<String> dll = new DoublyLinkedList<String>();
		for (int i = 0; i < TEST_0.length; i++) {
			dll.add(TEST_0[i]);
		}
		result = dll.toString();
		assertEquals(result, dll.toString());
	}

	@Test
	public void remove_0() {
		int result = "ABCDEFGHIJKL".length();
		DoublyLinkedList<String> dll = this.createNewRep(TEST_0);
		dll.remove();
		result--;
		System.out.print(dll.toString());
		assertEquals(result, dll.length());
	}

	@Test
	public void remove_T_0() {
		String result_str = "(B,C,D,E,F,G,H,I,J,K,L)";
		int result_len = "BCDEFGHIJKL".length();
		DoublyLinkedList<String> dll = this.createNewRep(TEST_0);
		dll.remove("A");
		assertEquals(result_len, dll.length());
		assertEquals(result_str, dll.toString());
	}

	@Test
	public void length_0() {
		int result = "ABCDEFGHIJKL".length();
		DoublyLinkedList<String> dll = this.createNewRep(TEST_0);

		assertEquals(result, dll.length());
	}

	@Test
	public void length_1() {
		int result = "\0\\\t".length();
		DoublyLinkedList<String> dll = this.createNewRep(TEST_1);
		assertEquals(result, dll.length());
	}

	@Test
	public void contains_0() {
		DoublyLinkedList<String> dll = this.createNewRep(TEST_0);
		String result = "(A,B,C,D,E,F,G,H,I,J,K,L)";
		assert (dll.contains("L"));
		assertEquals(result, dll.toString());
	}

	// TODO:
	@Test
	public void compartT0_0() {
		int result = TEST_0.toString().compareTo(TEST_0.toString());
		DoublyLinkedList<String> dll1 = this.createNewRep(TEST_0);
		DoublyLinkedList<String> dll2 = this.createNewRep(TEST_0);

		assertEquals(result, dll1.compareTo(dll2));
	}

	@Test
	public void compartT0_1() {
		int result = TEST_0.toString().compareTo(TEST_1.toString());
		DoublyLinkedList<String> dll1 = this.createNewRep(TEST_0);
		DoublyLinkedList<String> dll2 = this.createNewRep(TEST_1);

		assertEquals(result, dll1.compareTo(dll2));
	}

	@Test
	public void compartT0_2() {
		int result = TEST_1.toString().compareTo(TEST_0.toString());
		DoublyLinkedList<String> dll1 = this.createNewRep(TEST_1);
		DoublyLinkedList<String> dll2 = this.createNewRep(TEST_0);

		assertEquals(result, dll1.compareTo(dll2));
	}

	// TODO:
	@Test
	public void sort_0() {
		String result = "(ABCDEFGHIJKL)";
		DoublyLinkedList<String> dll = this.createNewRep(TEST_0);

		assertEquals(result, dll.toString());
	}

	@Test
	public void toString_0() {
		String result = "(A,B,C,D,E,F,G,H,I,J,K,L)";
		DoublyLinkedList<String> dll = this.createNewRep(TEST_0);

		assertEquals(result, dll.toString());

	}

	@Test
	public void toString_1() {
		String result = "(\0,\\,\t)";
		DoublyLinkedList<String> dll = this.createNewRep(TEST_1);

		assertEquals(result, dll.toString());

	}

}

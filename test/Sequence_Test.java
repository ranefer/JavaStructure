import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import collection.Sequence.Sequence;

/**
 * 
 */

/**
 * <pre>
 * @author Nate
 * 
 * @convention
 * 
 * @correspondence
 * </pre>
 */
public class Sequence_Test {

	private Sequence createTestSeq() {
		return new Sequence();
	}

	private Sequence<Integer> createTestSeq(int... args) {
		Sequence<Integer> result = new Sequence<Integer>();
		for (int i = 0; i < args.length; i++) {
			result.add(args[i], result.length());
		}
		return result;

	}

	@Test
	public void add() {
		Sequence<Integer> s = this.createTestSeq();
		s.add(9, 0);

		assertEquals(1, s.length());
		assertEquals("(9)", s.toString());
	}

	@Test
	public void add_01() {
		Sequence<Integer> s = this.createTestSeq(1, 2, 3, 4, 5, 6);
		String result = "(1, 2, 3, 4, 5, 6)";

		assertEquals(result, s.toString());
		assertEquals(6, s.length());

		s.add(9, 0);

		assertEquals(7, s.length());
		assertEquals("(9, " + result.substring(1), s.toString());
	}

	@Test
	public void remove() {
		Sequence<Integer> s = this.createTestSeq(1, 2, 3, 4, 5, 6);
		String result = "(1, 2, 3, 4, 5, 6)";

		assertEquals(result, s.toString());
		assertEquals(6, s.length());

		s.remove(6);

		// assertEquals(5, s.length());
		assertEquals(result.substring(0, 14) + ")", s.toString());
	}

	@Test
	public void peek() {
		fail("Not yet implemented");
	}

	@Test
	public void contains() {
		Sequence<Integer> s = this.createTestSeq(1, 2, 3, 4, 5, 6);

		assertEquals(s.contains(4), true);

	}

}

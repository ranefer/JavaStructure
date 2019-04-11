import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import collection.Collection;

public abstract class ACollectionTest {

	Collection<String> collection;
	String[] data;

	abstract protected Collection<String> setCollection();

	abstract protected String[] setData();

	@Before
	public void setUp() {
		this.collection = setCollection();
		this.data = setData();
	}

	@After
	public void tearDown() {
		this.collection = null;
		this.data = null;
	}

	@Test
	public void addTest0() {
		String expected = "(";
		for (String d : data) {
			expected += d;
		}
		expected += ")";

		for (int i = 0; i < data.length; i++) {
			collection.add(data[i]);
		}
		assertEquals(expected, collection.toString());
	}

	@Test
	public void remove() {
		fail();
	}

	@Test
	public void removeFirstTest() {
		fail();
	}

	@Test
	public void containsTest() {
		fail();
	}

	@Test
	public void getAllTest() {
		fail();
	}

	@Test
	public void removeAllTest() {
		fail();
	}

	@Test
	public void lengthTest() {
		fail();
	}
}

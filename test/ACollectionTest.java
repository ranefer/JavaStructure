import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import collection.Collection;

public abstract class ACollectionTest {

	Collection<String> collection;
	Iterator<String> iterator;
	String[] data;

	abstract protected Collection<String> setCollection();

	abstract protected String[] setData();

	@Before
	public void setUp() {
		this.collection = setCollection();
		this.data = setData();
		this.iterator = Arrays.stream(data).iterator();

		for (int i = 0; i < data.length; i++) {
			collection.add(data[i]);
		}
	}

	@After
	public void tearDown() {
		this.collection = null;
		this.data = null;
	}

	@Test
	public void addTest0() {
		String expected = "(";
		while (iterator.hasNext()) {
			expected += iterator.next();
			if (iterator.hasNext())
				expected += ",";
		}
		expected += ")";
		assertEquals(expected, collection.toString());
	}

	@Test
	public void remove() {
		fail();
	}

	@Test
	public void removeFirstTest() {
		String expected = "(";
		iterator.next(); // remove first
		while (iterator.hasNext()) {
			expected += iterator.next();
			if (iterator.hasNext())
				expected += ",";
		}
		expected += ")";
		collection.removeFirst();
		assertEquals(expected, collection.toString());
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

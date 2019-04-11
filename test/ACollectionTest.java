import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import collection.Collection;

public abstract class ACollectionTest {

	Collection<String> collection;
	String[] data;
	String[] invalidData;

	Iterator<String> iterator;
	Iterator<String> invalidIterator;

	abstract protected Collection<String> setCollection();

	abstract protected String[] setData();

	abstract protected String[] setInvalidData();

	@Before
	public void setUp() {
		this.collection = setCollection();
		this.data = setData();
		this.invalidData = setInvalidData();

		iterator = Arrays.stream(data).iterator();
		invalidIterator = Arrays.stream(invalidData).iterator();

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
		while (iterator.hasNext()) {
			String expected = iterator.next();
			assert (collection.remove(expected));

		}
	}

	@Test
	public void removeWrongItem() {
		while (invalidIterator.hasNext()) {
			String expected = invalidIterator.next();
			assertFalse(collection.remove(expected));
		}
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
		while (iterator.hasNext()) {
			String expected = iterator.next();
			assert (collection.contains(expected));
		}
	}

	@Test
	public void doesNotContain() {
		while (invalidIterator.hasNext()) {
			String expected = invalidIterator.next();
			assertFalse(collection.contains(expected));

		}
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

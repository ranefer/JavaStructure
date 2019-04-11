import static org.junit.Assert.fail;

import org.junit.Test;

import collection.Collection;
import collection.DoublyLinkedList.DoublyLinkedList;

public class DLLCollectionTest extends ACollectionTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	@Override
	protected Collection<String> setCollection() {
		return new DoublyLinkedList<String>();
	}

	@Override
	protected String[] setData() {
		return new String[] { "One", "Two", "Three", "Four", "Five" };
	}

}

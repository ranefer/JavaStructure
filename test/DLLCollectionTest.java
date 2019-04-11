import collection.Collection;
import collection.DoublyLinkedList.DoublyLinkedList;

public class DLLCollectionTest extends ACollectionTest {

	@Override
	protected Collection<String> setCollection() {
		return new DoublyLinkedList<String>();
	}

	@Override
	protected String[] setData() {
		return new String[] { "One", "Two", "Three", "Four", "Five" };
	}

	@Override
	protected String[] setInvalidData() {
		return new String[] { "Sean", "Paul", "Mike", "Debora", "Sarah" };
	}

}

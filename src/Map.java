
public class Map<KeyType, ValueType> {
	public Map() {
		
	}
	
	public void put(KeyType key, ValueType val) {
		items.insert(new Entry(key, val));
	}
	public ValueType get(KeyType key) {
		return (ValueType) items.get(new Entry(key, null)).value;
	}
	public boolean isEmpty() {
		if (items.capacity() == 0) return true;
		else return false;
	}
	public void makeEmpty() {
		items.makeEmpty();
	}
	
	private QuadraticProbingHashTable<Entry<KeyType, ValueType>> items;
	
	private static class Entry<KeyType, ValueType>
	{
		private Entry(KeyType key, ValueType value){
			this.key = key;
			this.value = value;
		}
		
		KeyType key;
		ValueType value;
		//appropriate constructions, etc.
	}
}

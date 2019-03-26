public class Map<KeyType, ValueType> {
	private QuadraticProbingHashTable<Entry<KeyType, ValueType>> items;
	
	public Map() {
		items = new QuadraticProbingHashTable<Entry<KeyType, ValueType>>();
	}
	
	public Map(int size) {
		items = new QuadraticProbingHashTable<Entry<KeyType, ValueType>>(size);
	}
	
	public void put(KeyType key, ValueType val) {
		items.insert(new Entry(key, val));
	}
	
	public ValueType get(KeyType key) {
		return items.get(new Entry(key)).value;
	}
	
	public boolean isEmpty() {
		if (items.size() == 0) return true;
		else return false;
	}
	
	public void makeEmpty() {
		items.makeEmpty();
	}
	
	private static class Entry<KeyType, ValueType>
	{
		private Entry(KeyType key, ValueType value){
			this.key = key;
			this.value = value;
		}
		
		private Entry(KeyType key) {
			this.key = key;
			this.value = null;
		}
		
		KeyType key;
		ValueType value;

		public boolean equalsKey(KeyType key2) {
			if (key.hashCode() == key2.hashCode())
				return true;
				else return false;
		}
		
		@Override
		public int hashCode() {
			return (int) key.hashCode() % 10;
		}
	}
}
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
		return (ValueType) items.get(new Entry(key)).value;
	}
	
	public boolean isEmpty() {
		return items.size() == 0 ? true : false;
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
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((key == null) ? 0 : key.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Entry other = (Entry) obj;
			if (key == null) {
				if (other.key != null)
					return false;
			} else if (!key.equals(other.key))
				return false;
			return true;
		}
	}
}
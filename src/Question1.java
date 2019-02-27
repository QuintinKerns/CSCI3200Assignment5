
public class Question1 {

	public static void main(String[] args) {
		final int TABLE_SIZE = 10;
		
		SeparateChainingHashTable schTable = new SeparateChainingHashTable(TABLE_SIZE);
		LinearProbingHashTable lphTable = new LinearProbingHashTable(TABLE_SIZE);
		QuadraticProbingHashTable qphTable = new QuadraticProbingHashTable(TABLE_SIZE);
		// Table with Second Hash Function (double hash table)
		LinearProbingHashTable dbhTable = new LinearProbingHashTable(TABLE_SIZE);
		
		int[] data = new int[]{4371, 1323, 6173, 4199, 4344, 9679, 1989};
		
		for (Object obj : data) {
			schTable.insert(obj);
			lphTable.insert(obj);
			qphTable.insert(obj);
			dbhTable.insert(obj);
		}
			
	}

}

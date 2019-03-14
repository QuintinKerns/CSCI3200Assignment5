
public class Questions1and2 {

	public static void main(String[] args) {
		final int TABLE_SIZE = 10;
		
		SeparateChainingHashTable<Integer> schTable = new SeparateChainingHashTable<Integer>(TABLE_SIZE);
		LinearProbingHashTable<Integer> lphTable = new LinearProbingHashTable<Integer>(TABLE_SIZE);
		QuadraticProbingHashTable<Integer> qphTable = new QuadraticProbingHashTable<Integer>(TABLE_SIZE);
		// Table with Second Hash Function (double hash table)
		SecondFunctionHashTable<Integer> sfhTable = new SecondFunctionHashTable<Integer>(TABLE_SIZE);
		
		int[] data = new int[]{4371, 1323, 6173, 4199, 4344, 9679, 1989};
		
		for (Integer num : data) {
			schTable.insert(num);
			lphTable.insert(num);
			qphTable.insert(num);
			sfhTable.insert(num);
		}
		
		System.out.println("Seperate Chaining Hash Table:");
		schTable.printTable();
		System.out.println("Linear Probing Hash Table:");
		lphTable.printTable();
		System.out.println("Quadratic Probing Hash Table:");
		qphTable.printTable();
		System.out.println("Second Function Hash Table:");
		sfhTable.printTable();
		// Question 2: Rehashing
		
		
			
	}

}


public class Question1 {

	public static void main(String[] args) {
		SeparateChainingHashTable schTable = new SeparateChainingHashTable(10);
		
		
		
		
		int[] data = new int[]{4371, 1323, 6173, 4199, 4344, 9679, 1989};
		
		for (Object obj : data) {
			schTable.insert(obj);
			
		}
			
	}

}

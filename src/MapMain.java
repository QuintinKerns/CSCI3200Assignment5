
public class MapMain {

	public static void main(String[] args) {
		Map map = new Map(); //default size 10
		
		// Test that isEmpty is working
		System.out.println("Empty? " + map.isEmpty());
		
		// Enter sample data
		map.put("A", 1);
		map.put("B", 2);
		map.put("C", 3);
		
		// Test that sample data is in map
		System.out.println("A: " + map.get("A"));
		System.out.println("B: " + map.get("B"));
		System.out.println("C: " + map.get("C"));
		
		// Test that isEmpty is working
		System.out.println("Empty? " + map.isEmpty());
		
		// Test that empty map is working
		System.out.println("Emptying map...");
		map.makeEmpty();
		
		// Test that isEmpty is working
		System.out.println("Empty? " + map.isEmpty());
	}

}


public class MapMain {

	public static void main(String[] args) {
		Map map = new Map(); //default size 10
		
		map.put("A", 1);
		map.put("B", 2);
		map.put("C", 3);
		
		System.out.println("A: " + map.get("A"));
		System.out.println("B: " + map.get("B"));
		System.out.println("C: " + map.get("C"));
		
		map.makeEmpty();
		System.out.println("Empty?" + map.isEmpty());
	}

}

package anonymous_class;

import java.util.HashMap;
import java.util.Map;

public class MapForEach {

	public static void main(String[] args) {
		Map<Integer, String> namesMap = new HashMap<>();
		namesMap.put(1, "Larry");
		namesMap.put(2, "Steve");
		namesMap.put(3, "James");
		namesMap.forEach((key, value) -> System.out.println(key + " " + value));
		
		namesMap.entrySet().forEach(entry -> System.out.println(
				  entry.getKey() + " " + entry.getValue()));
	}

}

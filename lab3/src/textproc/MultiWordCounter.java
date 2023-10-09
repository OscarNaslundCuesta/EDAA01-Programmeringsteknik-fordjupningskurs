package textproc;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MultiWordCounter implements TextProcessor {
	private Map<String, Integer> landskapCount;
	
	
	public MultiWordCounter(String[] landskapsLista) {
		landskapCount = new TreeMap<>();
		for (String landskap : landskapsLista) {
			landskapCount.put(landskap, 0);
		}
	}
	
	@Override
	public void process(String w) {
		if (landskapCount.containsKey(w)) {
			landskapCount.put(w, landskapCount.get(w) + 1);
		}
		
	}

	@Override
	public void report() {
		for (String key : landskapCount.keySet()) {
			System.out.println(key + ": " + landskapCount.get(key));
		}
		
	}

}


import java.util.LinkedHashMap;

public class dataMemory {
	
	static LinkedHashMap<Integer, Integer> dataMemo = new LinkedHashMap<>();
	
	
	public static void initializeDataMemo() {
		for (int i = 0; i <= 396; i+=4) {
			dataMemo.put(i, 0);
		}	
		
	}
	
}

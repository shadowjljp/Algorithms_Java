package design;

import java.util.HashMap;
import java.util.Map;

public class LoggerRatelimiter {
	Map<String,Integer> map ;
	public LoggerRatelimiter() {
		map = new HashMap<>();
		
	}
	public boolean shouldPrintMessage(int timestamp, String message) {
		if(!map.containsKey(message)) {
			map.put(message,timestamp+10);
			return true;
		}else {
			if(timestamp >=map.get(message)) {
				map.put(message, timestamp);
				return true;
			}else {
				return false;
			}
			
		}
	}
	public static void main(String[] args) {
		LoggerRatelimiter re = new LoggerRatelimiter();
		System.out.println(re.shouldPrintMessage(1, "foo"));
		System.out.println(re.shouldPrintMessage(2, "bar"));
		System.out.println(re.shouldPrintMessage(3, "foo"));
		System.out.println(re.shouldPrintMessage(8, "bar"));
		System.out.println(re.shouldPrintMessage(10, "foo"));
		System.out.println(re.shouldPrintMessage(11, "foo"));
	}

}

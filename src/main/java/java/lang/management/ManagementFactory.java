package java.lang.management;

import java.lang.String;
import java.util.ArrayList;
import java.util.List;

public class ManagementFactory {
	public static class RuntimeMXBean {
		public String getName() {
			return "RuntimeMXBean";
		}
		
		public List<String> getInputArguments() {
			return new ArrayList<>();
		}
	}
	
	public static RuntimeMXBean getRuntimeMXBean() {
		return new RuntimeMXBean();
	}
}

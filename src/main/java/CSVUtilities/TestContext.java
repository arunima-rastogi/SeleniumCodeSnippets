package CSVUtilities;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class TestContext {

	private Map<String, Object> testContext = new HashMap<String, Object>();

	public void put(String K, Object V) {
		if (StringUtils.isEmpty(K)) {
			String err = "Key can't be null or empty";
			IllegalArgumentException ex = new IllegalArgumentException(err);
			System.out.println("Exception occurred during context insertion" + ex.getMessage());
			throw ex;
		} else {
			this.testContext.put(K, V);
		}
	}

	public void clear() {
		this.testContext.clear();
	}

	public String get(String K) {
		Object obj = this.testContext.get(K);
		if (obj == null) {
			System.out.println("No match found .. returning null");
			return null;
		} else {
			return (String) obj;
		}
	}

	public void remove(String key) {
		if (StringUtils.isNotEmpty(key)) {
			this.testContext.remove(key);
		}

	}

}
package SeleniumGridUtilities;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import org.openqa.grid.internal.utils.configuration.GridHubConfiguration;
import org.openqa.grid.web.Hub;

import CSVUtilities.Initializer;


import org.apache.log4j.Logger;

public class HubUtilities {
	private static final Logger LOG = Logger.getLogger(HubUtilities.class);

	private GridHubConfiguration gridHubConfig;
	private Hub myHub;
	private Map<String, Object> hubProperties;

	
	public HubUtilities() throws Exception {
		Initializer obj = new Initializer();
		hubProperties = obj.readMap();
	}

	public void startHub() {
		if (!isHubRunning()) {
			try {
				gridHubConfig = new GridHubConfiguration();
				gridHubConfig.role = (String) hubProperties.get("HubRole");
				gridHubConfig.host = (String) hubProperties.get("HubHost");
				gridHubConfig.port = Integer.parseInt((String) hubProperties.get("HubPort"));

				myHub = new Hub(gridHubConfig);
				myHub.start();

			} catch (Exception e) {
				LOG.error("Exception occurred during Hub initialization {} {}" + e.getMessage()
						+ HubUtilities.class.getName());
			}
		}
	}

	public void stopHub() {
		String line;
		String[] pID;

		if (isHubRunning()) {
			try {

				java.lang.Process p = Runtime.getRuntime().exec("netstat -ano");
				BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
				while ((line = input.readLine()) != null) {
					if (line.contains(":4444")) {
						pID = line.split("\\s+");
						String cmd = "taskkill /PID " + pID[5] + " /F";
						p = Runtime.getRuntime().exec(cmd);
					}
				}
			} catch (Exception e) {
				LOG.error("Exception occurred on trying to stop hub {} {}" + e.getMessage()
						+ HubUtilities.class.getName());
			}
		}

	}

	public boolean isHubRunning() {

		String line;
		String[] pID = null;
		try {
			java.lang.Process p = Runtime.getRuntime().exec("netstat -ano");
			BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while ((line = input.readLine()) != null) {
				if (line.contains((CharSequence) hubProperties.get("HubPort"))) {
					pID = line.split("\\s+");
				}
			}

		} catch (Exception e) {
			LOG.error("Exception occurred while checking Hub running status {} {}" + e.getMessage()
					+ HubUtilities.class.getName());
		}
		if (pID == null) {
			return false;
		} else {
			return true;
		}
	}
}
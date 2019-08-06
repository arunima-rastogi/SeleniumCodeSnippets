package CodeSnippets;

import SeleniumGridUtilities.HubUtilities;
import SeleniumGridUtilities.NodeUtilities;

public class StartGrid {

	public static void main(String[] args) throws Exception {
		HubUtilities hubUtilities = new HubUtilities();
		NodeUtilities nodeUtilities = new NodeUtilities();
		
		hubUtilities.startHub();
		Thread.sleep(30000);
		nodeUtilities.configNode();
		Thread.sleep(10000);
		
		Thread.sleep(20000);
		hubUtilities.stopHub();

	}

}

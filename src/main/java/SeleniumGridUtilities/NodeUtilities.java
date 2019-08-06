package SeleniumGridUtilities;

import java.util.Map;
import org.apache.log4j.Logger;
import org.openqa.grid.common.GridRole;
import org.openqa.grid.common.RegistrationRequest;
import org.openqa.grid.internal.utils.SelfRegisteringRemote;
import org.openqa.grid.internal.utils.configuration.GridNodeConfiguration;
import org.openqa.grid.selenium.proxy.DefaultRemoteProxy;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.server.SeleniumServer;
import CSVUtilities.Initializer;

public class NodeUtilities {
	private static final Logger LOG = Logger.getLogger(NodeUtilities.class);
	private GridNodeConfiguration gridNodeConfig = new GridNodeConfiguration();
	private Map<String, Object> nodeProperties;
	private SelfRegisteringRemote remote;

	public NodeUtilities() throws Exception {
		Initializer obj = new Initializer();
		nodeProperties = obj.readMap();
	}

	public void configNode() {
		if (((String) nodeProperties.get("Run")).equalsIgnoreCase("local")) {
			gridNodeConfig.hub = "http://" + nodeProperties.get("NodeHost") + ":" + nodeProperties.get("HubPort")
					+ "/grid/register";
			gridNodeConfig.host = (String) nodeProperties.get("NodeHost");
			gridNodeConfig.port = Integer.parseInt((String) nodeProperties.get("NodePort"));
			gridNodeConfig.role = "node";

			RegistrationRequest req = new RegistrationRequest(gridNodeConfig);
			req.getConfiguration();
			req.validate();
			RegistrationRequest.build(gridNodeConfig);

			SelfRegisteringRemote remote = new SelfRegisteringRemote(req);
			remote.setRemoteServer(new SeleniumServer(gridNodeConfig));
			remote.startRemoteServer();
			remote.startRegistrationProcess();

		} else {
			LOG.info("Starting remote node registration");
			remote = new SelfRegisteringRemote(getNodeConfiguration());
			remote.addBrowser(DesiredCapabilities.chrome(), 5); // 5 # of instances
			SeleniumServer server = new SeleniumServer(remote.getConfiguration());
			remote.setRemoteServer(server);
			remote.startRemoteServer();
			remote.startRegistrationProcess();
		}
	}

	private GridNodeConfiguration getNodeConfiguration() {
		GridNodeConfiguration nodeConfiguration = new GridNodeConfiguration();

		nodeConfiguration.register = true;
		nodeConfiguration.hub = String.format("http://%s:%s", nodeProperties.get("NodeHost"),
				nodeProperties.get("HubPort"));
		nodeConfiguration.port = 5000;
		nodeConfiguration.proxy = DefaultRemoteProxy.class.getCanonicalName();
		nodeConfiguration.maxSession = 1;
		nodeConfiguration.cleanUpCycle = 2000;
		nodeConfiguration.unregisterIfStillDownAfter = 20000;
		nodeConfiguration.role = GridRole.NODE.toString();
		nodeConfiguration.getHubHost();
		nodeConfiguration.nodeConfigFile = System.getProperty("user.dir") + "\\configs\\nodeConfigJSon.json";
		return nodeConfiguration;
	}

}
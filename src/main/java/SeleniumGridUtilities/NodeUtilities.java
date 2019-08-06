package SeleniumGridUtilities;


import java.util.Map;
import org.apache.log4j.Logger;
import org.openqa.grid.common.RegistrationRequest;
import org.openqa.grid.internal.utils.SelfRegisteringRemote;
import org.openqa.grid.internal.utils.configuration.GridNodeConfiguration;
import org.openqa.selenium.remote.server.SeleniumServer;
import CSVUtilities.Initializer;


public class NodeUtilities {
	private static final Logger LOG = Logger.getLogger(NodeUtilities.class);
	private GridNodeConfiguration gridNodeConfig = new GridNodeConfiguration();
	private Map<String, Object> nodeProperties;
	
	public NodeUtilities() throws Exception {
		Initializer obj = new Initializer();
		nodeProperties = obj.readMap();
	}

	public void configNode() {
		if(((String) nodeProperties.get("Run")).equalsIgnoreCase("local")) {
			gridNodeConfig.hub = "http://" + nodeProperties.get("NodeHost") + ":"+nodeProperties.get("HubPort")+"/grid/register";
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
			LOG.info("Node will be initialized on Perfecto");
		}
	}

}
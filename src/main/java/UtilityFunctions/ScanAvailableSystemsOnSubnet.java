package UtilityFunctions;

import java.net.InetAddress;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

public class ScanAvailableSystemsOnSubnet {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Map<String, String> getConnectedDevices = new HashMap<>();

		getConnectedDevices = checkHosts("127.0.0");

		System.out.println(getConnectedDevices.toString());
	}

	public static Map<String, String> checkHosts(String subnet) throws UnknownHostException, IOException {
		Map<String, String> connectedDevice = new HashMap<>();

		int timeout = 1000;
		for (int i = 1; i < 255; i++) {
			String host = subnet + "." + i;
			if (InetAddress.getByName(host).isReachable(timeout)) {
				connectedDevice.put(host, "is reachable");
			}
		}

		return connectedDevice;
	}

}
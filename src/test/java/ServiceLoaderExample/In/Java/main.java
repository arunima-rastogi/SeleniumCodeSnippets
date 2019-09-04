package ServiceLoaderExample.In.Java;

import java.util.ServiceLoader;

public class main {

	public static void main(String[] args) {
		ServiceLoader<Account> serviceLoader = ServiceLoader.load(Account.class);
		for (Account cpService : serviceLoader) {
			cpService.display();
		}

	}

}

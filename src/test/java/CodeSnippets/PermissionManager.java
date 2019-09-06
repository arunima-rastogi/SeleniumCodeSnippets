package CodeSnippets;


public class PermissionManager {
	public static void main(String[] args) {
		System.setProperty("java.security.policy", "demo.policy");
		System.setProperty("java.security.auth.login.config", "demo.config");
		System.out.println(System.getProperty("java.home"));
		System.setSecurityManager(new SecurityManager());
	}

}
